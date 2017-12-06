package es.saladillo.alejandro.arrayadaptercompra;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 28/10/2016.
 */

public class Adaptador extends ArrayAdapter<String> {

    private final ArrayList<String> datos;

    public Adaptador(Context contexto, ArrayList<String> datos) {
        super(contexto, R.layout.fila, datos);
        this.datos = datos;
    }


    private static class ViewHolder {

        private final TextView lblElemento;

        public ViewHolder(View view) {
            lblElemento = (TextView) view.findViewById(R.id.lblElemento);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);


        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        String s = datos.get(position);
        holder.lblElemento.setText(s);
    }
}
