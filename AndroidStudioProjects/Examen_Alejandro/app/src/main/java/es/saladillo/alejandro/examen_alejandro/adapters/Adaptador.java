package es.saladillo.alejandro.examen_alejandro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.saladillo.alejandro.examen_alejandro.R;
import es.saladillo.alejandro.examen_alejandro.models.Libro;

/**
 * Created by Alejandro on 28/10/2016.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private ArrayList<Libro> mDatos;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Libro libro, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public Adaptador() {
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
                            mDatos.get(posicion),
                            posicion);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Libro l = mDatos.get(position);
        holder.lblTitulo.setText(l.getTitulo());
        holder.lblAutor.setText(l.getAutor());
        holder.lblPublicacion.setText(String.valueOf(l.getPublicacion()));
        if (!l.getPortada().equals(""))
            Picasso.with(holder.imgPortada.getContext()).load(l.getPortada()).into(holder.imgPortada);
        else
            holder.imgPortada.setImageResource(R.drawable.placeholder);
    }

    @Override
    public int getItemCount() {
        return mDatos == null ? 0 : mDatos.size();
    }


    public void swapData(ArrayList<Libro> libros) {
        mDatos = libros;
        notifyItemInserted(libros.size() - 1);
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
}
