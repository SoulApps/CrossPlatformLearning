package es.saladillo.alejandro.recycledview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 28/10/2016.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private ArrayList<Alumno> datos;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Alumno alumno, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public Adaptador(ArrayList<Alumno> datos) {
        this.datos = datos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila, parent, false);
        final ViewHolder viewHolder = new ViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posicion = viewHolder.getAdapterPosition();
                if (onItemClickListener != null && posicion >= 0) {
                    // Se informa al listener.
                    onItemClickListener.onItemClick(v,
                            datos.get(posicion),
                            posicion);
                }
            }
        });
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
            lblNombre = (TextView) view.findViewById(R.id.lblNombre);
            lblEdad = (TextView) view.findViewById(R.id.lblEdad);
        }

        public void bind(Alumno a) {
            lblNombre.setText(a.getNombre());
            lblEdad.setText(String.valueOf(a.getEdad()));
        }
    }
}
