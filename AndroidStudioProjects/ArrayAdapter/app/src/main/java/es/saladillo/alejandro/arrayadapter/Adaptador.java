package es.saladillo.alejandro.arrayadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Alejandro on 28/10/2016.
 */

public class Adaptador extends ArrayAdapter<Alumno> {

    private Alumno[] datos;

    public Adaptador(Context contexto, Alumno[] datos) {
        super(contexto, R.layout.fila, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vistaFila = LayoutInflater.from(getContext()).inflate(R.layout.fila, parent ,false);
        TextView lblNombre = (TextView) vistaFila.findViewById(R.id.lblNombre);
        TextView lblEdad = (TextView) vistaFila.findViewById(R.id.lblEdad);
        TextView lblRepetidor = (TextView) vistaFila.findViewById(R.id.lblRepetidor);
        Alumno a = datos[position];

        lblNombre.setText(a.getNombre());
        lblEdad.setText(String.valueOf(a.getEdad()));
        if (a.isRepetidor())
            lblRepetidor.setText(R.string.repetidor);

        return vistaFila;
    }
}
