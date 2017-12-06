package es.saladillo.alejandro.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.saladillo.alejandro.json.models.Alumno;

/**
 * Created by Alejandro on 06/02/2017.
 */

public class Adaptador extends ArrayAdapter<Alumno> {

    private ArrayList<Alumno> alumnos;

    public Adaptador(Context context) {
        super(context, R.layout.fila);
        this.alumnos = alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
        super.clear();
        super.addAll(alumnos);
    }

    private static class ViewHolder {

        private final TextView lblInfo;

        public ViewHolder(View view) {
            lblInfo = (TextView) view.findViewById(R.id.lblInfo);
        }

        public void bind(Alumno alumno) {
            lblInfo.setText(alumno.toString());
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
        Alumno personaje = alumnos.get(position);
        holder.bind(personaje);
    }
}
