package es.saladillo.alejandro.practica02_alejandro.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.saladillo.alejandro.practica02_alejandro.MostradorFotoAsyncTask;
import es.saladillo.alejandro.practica02_alejandro.R;
import es.saladillo.alejandro.practica02_alejandro.models.Alumno;

/**
 * Created by Alejandro on 25/02/2017.
 */

public class AdaptadorListaAlumnos extends ArrayAdapter<Alumno> {

    public AdaptadorListaAlumnos(Context context, ArrayList<Alumno> alumnos) {
        super(context, R.layout.fila_alumno, alumnos);
    }

    private static class ViewHolder {

        private final TextView lblNombreAlumno;
        private final ImageView imgFotoAlumno;

        public ViewHolder(View view) {
            lblNombreAlumno = (TextView) view.findViewById(R.id.lblNombreAlumno);
            imgFotoAlumno = (ImageView) view.findViewById(R.id.imgFotoAlumno);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_alumno, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        Alumno alumno = getItem(position);
        if (alumno != null) {
            holder.lblNombreAlumno.setText(alumno.getNombre());
            if (alumno.getImagen() != null)
                new MostradorFotoAsyncTask(getContext(), holder.imgFotoAlumno, alumno.getNombre() + ".jpg").execute(alumno.getImagen());
            else
                holder.imgFotoAlumno.setImageResource(R.drawable.default_alumno_image);
        }
    }
}
