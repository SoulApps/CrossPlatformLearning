package es.saladillo.alejandro.starwars;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.saladillo.alejandro.starwars.models.Film;

/**
 * Created by Alejandro on 06/02/2017.
 */

public class Adaptador extends ArrayAdapter<Film> {

    private ArrayList<Film> peliculas;

    public Adaptador(Context context, ArrayList<Film> peliculas) {
        super(context, R.layout.fila);
        this.peliculas = peliculas;
    }

    public void setPeliculas(ArrayList<Film> peliculas) {
        this.peliculas = peliculas;
        super.clear();
        super.addAll(peliculas);
    }

    private static class ViewHolder {

        private final TextView lblInfo;

        public ViewHolder(View view) {
            lblInfo = (TextView) view.findViewById(R.id.lblInfo);
        }

        public void bind(Film pelicula) {
            lblInfo.setText(pelicula.getTitle());
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
        Film pelicula = peliculas.get(position);
        holder.bind(pelicula);
    }
}
