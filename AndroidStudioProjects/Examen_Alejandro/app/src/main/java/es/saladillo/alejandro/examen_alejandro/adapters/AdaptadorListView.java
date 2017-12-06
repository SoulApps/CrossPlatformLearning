package es.saladillo.alejandro.examen_alejandro.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.saladillo.alejandro.examen_alejandro.R;
import es.saladillo.alejandro.examen_alejandro.models.Libro;

/**
 * Created by Alejandro on 03/03/2017.
 */

public class AdaptadorListView extends ArrayAdapter<Libro> {

    public AdaptadorListView(Context context) {
        super(context, R.layout.fila);
    }

    public void swapData(ArrayList<Libro> libros) {
        clear();
        addAll(libros);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lblTitulo;
        private final TextView lblAutor;
        private final TextView lblPublicacion;
        private final ImageView imgPortada;

        public ViewHolder(View view) {
            super(view);
            lblTitulo = (TextView) view.findViewById(R.id.lblTitulo);
            lblAutor = (TextView) view.findViewById(R.id.lblAutor);
            lblPublicacion = (TextView) view.findViewById(R.id.lblPublicacion);
            imgPortada = (ImageView) view.findViewById(R.id.imgPortada);
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

    public void onBindViewHolder(ViewHolder holder, int position) {
        Libro l = getItem(position);
        if (l != null) {
            holder.lblTitulo.setText(l.getTitulo());
            holder.lblAutor.setText(l.getAutor());
            holder.lblPublicacion.setText(String.valueOf(l.getPublicacion()));
            if (!l.getPortada().equals(""))
                Picasso.with(holder.imgPortada.getContext()).load(l.getPortada()).into(holder.imgPortada);
            else
                holder.imgPortada.setImageResource(R.drawable.placeholder);
        }
    }

}
