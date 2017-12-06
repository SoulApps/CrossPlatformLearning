package es.iessaladillo.iessaladillo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import es.iessaladillo.iessaladillo.R;
import es.iessaladillo.iessaladillo.models.Incidencia;
import es.iessaladillo.iessaladillo.util.GlobalValues;

/**
 * Created by Alejandro on 10/05/2017.
 */

public class IncidenciasAdapter extends ArrayAdapter<Incidencia> {

    public IncidenciasAdapter(Context context) {
        super(context, R.layout.fila_incidencia);
    }

    public void actualizar(ArrayList<Incidencia> incidencias) {
        clear();
        addAll(incidencias);
    }

    private static class ViewHolder {
        private final View colorEstado;
        private final TextView lblUsuario;
        private final TextView lblCodigo;
        private final TextView lblFecha;

        ViewHolder(View view) {
            colorEstado = view.findViewById(R.id.colorEstado);
            lblUsuario = (TextView) view.findViewById(R.id.lblUsuario);
            lblCodigo = (TextView) view.findViewById(R.id.lblCodigo);
            lblFecha = (TextView) view.findViewById(R.id.lblFecha);
        }

        void bind(Incidencia incidencia) {
            colorEstado.setBackgroundColor(ContextCompat.getColor(colorEstado.getContext(), incidencia.getEstado().getColor()));
            lblUsuario.setText(String.format(Locale.getDefault(), "%s %s", incidencia.getNombre(), incidencia.getApellido1()));
            lblCodigo.setText(String.format(Locale.getDefault(), "%d.%d.%d",
                    incidencia.getPlanta(), incidencia.getCodAula(), incidencia.getCodMaterial()));
            lblFecha.setText(GlobalValues.FORMATO_FECHA_INCIDENCIA.format(incidencia.getFecha()));
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_incidencia, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        Incidencia incidencia = getItem(position);
        holder.bind(incidencia);
    }
}
