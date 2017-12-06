package es.saladillo.alejandro.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 07/03/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private ArrayList<Alumno> datos;

    public Adaptador(ArrayList<Alumno> datos) {
        this.datos = datos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila, parent, false);
        final ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Alumno a = datos.get(position);
        holder.bind(a);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lblNombre;
        private final TextView lblEdad;

        public ViewHolder(View view) {
            super(view);
            lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
            lblEdad = (TextView) itemView.findViewById(R.id.lblEdad);
        }

        public void bind(Alumno a) {
            lblNombre.setText(a.getNombre());
            lblEdad.setText(String.valueOf(a.getEdad()));
        }
    }
}
