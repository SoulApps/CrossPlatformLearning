package es.saladillo.alejandro.listaalumnos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 28/10/2016.
 */

public class Adaptador extends ArrayAdapter<Alumno> {

    private final ArrayList<Alumno> alumnos;

    public Adaptador(Context contexto, ArrayList<Alumno> alumnos) {
        super(contexto, R.layout.fila, alumnos);
        this.alumnos = alumnos;
    }


    private static class ViewHolder {

        private final TextView lblNombre;
        private final TextView lblEdad;
        private final TextView lblRepetidor;
        private final ImageView imgFoto;

        public ViewHolder(View view) {
            lblNombre = (TextView) view.findViewById(R.id.lblNombre);
            lblEdad = (TextView) view.findViewById(R.id.lblEdad);
            lblRepetidor = (TextView) view.findViewById(R.id.lblRepetidor);
            imgFoto = (ImageView) view.findViewById(R.id.imgFoto);
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
        Alumno a = alumnos.get(position);
        holder.lblNombre.setText(a.getNombre());
        holder.lblEdad.setText(String.valueOf(a.getEdad()));
        if (a.isRepetidor())
            holder.lblRepetidor.setText(R.string.repetidor);
        else
            holder.lblRepetidor.setText("");

        //holder.imgFoto.setImageResource(a.getImagen());
    }
}
