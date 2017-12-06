package es.iessaladillo.iessaladillo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import es.iessaladillo.iessaladillo.R;
import es.iessaladillo.iessaladillo.models.Aula;
import es.iessaladillo.iessaladillo.models.TramoHorarioReserva;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alejandro on 24/04/2017.
 */

public class TramosHorariosReservaAdapter extends ArrayAdapter<TramoHorarioReserva> {

    private Context mContext;
    private static String mDia;
    private static Aula mAula;

    public TramosHorariosReservaAdapter(Context context, String dia) {
        super(context, R.layout.fila_tramo_horario);
        mDia = dia;
        mContext = context;
    }

    public void actualizar(Aula aula, ArrayList<TramoHorarioReserva> tramos) {
        mAula = aula;
        clear();
        addAll(tramos);
    }

    private class ViewHolder {
        private final TextView lblHoraTramo;
        private final Button btnReservar;
        private final TextView lblReservado;
        private final ProgressBar progressBar;

        ViewHolder(View view, final int position) {
            lblHoraTramo = (TextView) view.findViewById(R.id.lblHoraTramo);
            btnReservar = (Button) view.findViewById(R.id.btnReservar);
            lblReservado = (TextView) view.findViewById(R.id.lblReservado);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

            btnReservar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String OPCION = btnReservar.getText().toString();
                    if (OPCION.equals(mContext.getString(R.string.reservar)))
                        reservar(view.getContext(), (byte) position, mAula.getPlanta(), mAula.getCodAula());
                    else
                        cancelarReserva(view.getContext(), (byte) position, mAula.getPlanta(), mAula.getCodAula());
                }
            });
        }

        private void reservar(final Context context, byte tramo, byte planta, short codAula) {
            btnReservar.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

            Call<ArrayList<TramoHorarioReserva>> peticion = Api.getApiInterface()
                    .reservar(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken(), mDia, planta, codAula, tramo);
            peticion.enqueue(new Callback<ArrayList<TramoHorarioReserva>>() {
                @Override
                public void onResponse(Call<ArrayList<TramoHorarioReserva>> call, Response<ArrayList<TramoHorarioReserva>> response) {
                    progressBar.setVisibility(View.INVISIBLE);
                    // Si la respuesta es correcta.
                    if (response != null) {
                        if (response.isSuccessful() && response.body().isEmpty()) {
                            btnReservar.setText(mContext.getString(R.string.cancelar_reserva));
                            btnReservar.setVisibility(View.VISIBLE);
                            Toast.makeText(context, R.string.reserva_ok, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, R.string.reserva_error, Toast.LENGTH_SHORT).show();
                            lblReservado.setText(String.format(Locale.getDefault(), "Reservado por:\n%s %s", response.body().get(0).getNombre(), response.body().get(0).getApellido1()));
                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<TramoHorarioReserva>> call, Throwable t) {
                    Toast.makeText(context, R.string.error_internet, Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    btnReservar.setVisibility(View.VISIBLE);
                }
            });
        }

        private void cancelarReserva(final Context context, byte tramo, byte planta, short codAula) {
            btnReservar.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

            Call<Void> peticion = Api.getApiInterface()
                    .cancelarReserva(planta, codAula, mDia, tramo, GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken());
            peticion.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    progressBar.setVisibility(View.INVISIBLE);
                    // Si la respuesta es correcta.
                    if (response != null && response.isSuccessful()) {
                        Toast.makeText(context, R.string.reserva_cancelada, Toast.LENGTH_SHORT).show();
                        btnReservar.setText(mContext.getString(R.string.reservar));
                        btnReservar.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, R.string.error_internet, Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    btnReservar.setVisibility(View.VISIBLE);
                }
            });
        }

        void bind(TramoHorarioReserva tramoHorarioReserva) {
            lblHoraTramo.setText(String.format(Locale.getDefault(), "%s - %s", tramoHorarioReserva.getHoraInicio(), tramoHorarioReserva.getHoraFin()));
            Integer profesor = tramoHorarioReserva.getCodProf();
            if (profesor != null) {
                if (profesor.equals(GlobalValues.profesor.getCodProf())) {
                    btnReservar.setVisibility(View.VISIBLE);
                    btnReservar.setText(R.string.cancelar_reserva);
                } else {
                    btnReservar.setVisibility(View.INVISIBLE);
                    lblReservado.setText(String.format(Locale.getDefault(), "Reservado por:\n%s %s", tramoHorarioReserva.getNombre(), tramoHorarioReserva.getApellido1()));
                }
            } else {
                btnReservar.setText(R.string.reservar);
                btnReservar.setVisibility(View.VISIBLE);
                lblReservado.setText("");
            }
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_tramo_horario, parent, false);
            holder = new ViewHolder(convertView, position + 1);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        TramoHorarioReserva tramoHorarioReserva = getItem(position);
        holder.bind(tramoHorarioReserva);
    }
}
