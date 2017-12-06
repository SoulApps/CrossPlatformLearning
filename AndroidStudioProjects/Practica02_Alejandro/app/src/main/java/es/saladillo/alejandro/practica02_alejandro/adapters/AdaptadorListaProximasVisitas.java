package es.saladillo.alejandro.practica02_alejandro.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import es.saladillo.alejandro.practica02_alejandro.R;

/**
 * Created by Alejandro on 27/02/2017.
 */

public class AdaptadorListaProximasVisitas extends ArrayAdapter<Object[]> {

    public AdaptadorListaProximasVisitas(Context context, ArrayList<Object[]> visitas) {
        super(context, R.layout.fila_proxima_visita, visitas);
    }

    public void actualizar(ArrayList<Object[]> visitas) {
        clear();
        addAll(visitas);
    }

    private static class ViewHolder {

        private final ImageView imgFotoAlumno;
        private final TextView lblNombreAlumno;
        private final TextView lblFechaVisita;

        public ViewHolder(View view) {
            imgFotoAlumno = (ImageView) view.findViewById(R.id.imgFotoAlumno);
            lblNombreAlumno = (TextView) view.findViewById(R.id.lblNombreAlumno);
            lblFechaVisita = (TextView) view.findViewById(R.id.lblFechaVisita);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_proxima_visita, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        final long UN_DIA = 86400000L, DIAS_HASTA_PROXIMA_VISITA = 15;
        final long MILIS_DIAS_HASTA_PROXIMA_VISITA = UN_DIA * DIAS_HASTA_PROXIMA_VISITA; //Milisegundos de 15 días.
        Object[] fila = getItem(position);
        if (fila != null) {
            holder.lblNombreAlumno.setText((String) fila[0]);
            if (fila[1] != null)
                holder.imgFotoAlumno.setImageURI(Uri.parse((String) fila[1]));
            else
                holder.imgFotoAlumno.setImageResource(R.drawable.default_alumno_image);

            if ((long) fila[2] != 0)
                holder.lblFechaVisita.setText(FORMATO.format((long) fila[2] + MILIS_DIAS_HASTA_PROXIMA_VISITA));
            else
                holder.lblFechaVisita.setText(R.string.visita_sin_fecha);
        }
    }
}
