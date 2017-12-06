package es.saladillo.alejandro.quiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;

import static java.text.DateFormat.SHORT;
import static java.text.DateFormat.getDateTimeInstance;

/**
 * Created by Alejandro on 03/12/2016.
 */

public class AdaptadorPuntuaciones extends ArrayAdapter<Puntuacion> {

    private ArrayList<Puntuacion> puntuaciones;

    public AdaptadorPuntuaciones(Context context, ArrayList<Puntuacion> puntuaciones) {
        super(context, R.layout.puntuacion, puntuaciones);
        this.puntuaciones = puntuaciones;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.puntuacion, parent, false);
            holder = new ViewHolder(convertView);
        } else
            holder = (ViewHolder) convertView.getTag();

        escribir(position, holder);
        convertView.setTag(holder);

        return convertView;
    }

    private static class ViewHolder {
        private TextView lblFecha;
        private TextView lblPuntos;

        private ViewHolder(View vista) {
            lblFecha = (TextView) vista.findViewById(R.id.lblFecha);
            lblPuntos = (TextView) vista.findViewById(R.id.lblPuntos);
        }

    }

    private void escribir(int position, ViewHolder holder) {
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        DateFormat formato = getDateTimeInstance(SHORT, SHORT);
        holder.lblFecha.setText(formato.format(puntuaciones.get(position).getFecha()));
        holder.lblPuntos.setText(String.valueOf(puntuaciones.get(position).getPuntos()));
    }
}
