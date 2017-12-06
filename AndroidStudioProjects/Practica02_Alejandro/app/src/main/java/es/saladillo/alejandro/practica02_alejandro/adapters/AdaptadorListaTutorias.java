package es.saladillo.alejandro.practica02_alejandro.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import es.saladillo.alejandro.practica02_alejandro.R;
import es.saladillo.alejandro.practica02_alejandro.models.Visita;

/**
 * Created by Alejandro on 26/02/2017.
 */

public class AdaptadorListaTutorias extends ArrayAdapter<Visita> {

    public AdaptadorListaTutorias(Context context, ArrayList<Visita> alumnos) {
        super(context, R.layout.fila_tutoria, alumnos);
    }

    public void actualizar(ArrayList<Visita> visitas) {
        clear();
        addAll(visitas);
    }

    private static class ViewHolder {

        private final TextView lblFechaVisita;
        private final TextView lblHoraVisita;
        private final TextView lblContenidoResumen;

        public ViewHolder(View view) {
            lblFechaVisita = (TextView) view.findViewById(R.id.lblFechaVisita);
            lblHoraVisita = (TextView) view.findViewById(R.id.lblHoraVisita);
            lblContenidoResumen = (TextView) view.findViewById(R.id.lblContenidoResumen);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_tutoria, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Visita visita = getItem(position);
        if (visita != null) {
            holder.lblFechaVisita.setText(FORMATO.format(visita.getFecha()));
            holder.lblHoraVisita.setText(String.format("%s-%s", visita.getHoraInicio() == null?"?":visita.getHoraInicio(), visita.getHoraFin() == null?"?":visita.getHoraFin()));
            holder.lblContenidoResumen.setText(visita.getResumen());
        }
    }
}
