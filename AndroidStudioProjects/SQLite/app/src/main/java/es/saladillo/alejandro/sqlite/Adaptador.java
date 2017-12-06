package es.saladillo.alejandro.sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.saladillo.alejandro.sqlite.db.models.Alumno;


/**
 * Created by Alejandro on 04/02/2017.
 */

public class Adaptador extends ArrayAdapter<Alumno> {

    private ArrayList<Alumno> alumnos;

    public Adaptador(Context context, ArrayList<Alumno> alumnos) {
        super(context, R.layout.fila, alumnos);
        this.alumnos = alumnos;
    }

    public void actualizar(ArrayList<Alumno> alumnos) {
        clear();
        addAll(alumnos);
    }

    private static class ViewHolder {

        private final TextView lblNombre;

        public ViewHolder(View view) {
            lblNombre = (TextView) view.findViewById(R.id.lblNombre);
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
        holder.lblNombre.setText(alumnos.get(position).toString());
    }

}
