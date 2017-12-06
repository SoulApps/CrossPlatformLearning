package es.iessaladillo.iessaladillo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import es.iessaladillo.iessaladillo.R;
import es.iessaladillo.iessaladillo.models.Material;

/**
 * Created by Alejandro on 25/05/2017.
 */

public class MaterialesAdapter extends RecyclerView.Adapter<MaterialesAdapter.ViewHolder> {

    private ArrayList<Material> mMateriales;

    public MaterialesAdapter() {
        mMateriales = new ArrayList<>();
    }

    public void addAll(ArrayList<Material> materiales) {
        mMateriales.addAll(materiales);
        notifyDataSetChanged();
    }

    public void add(Material material, int position) {
        mMateriales.add(material);
        notifyItemInserted(position);
    }

    public Material remove(int position) {
        Material material = mMateriales.get(position);
        mMateriales.remove(position);
        notifyItemRemoved(position);
        return material;
    }

    public boolean isEmpty() {
        return mMateriales.isEmpty();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_material, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Material material = mMateriales.get(position);
        holder.lblAula.setText(material.getNombre());
        holder.lblMaterial.setText(String.format(Locale.getDefault(),
                "%d.%d.%d", material.getPlanta(), material.getCodAula(), material.getCodMaterial()));
    }

    @Override
    public int getItemCount() {
        return mMateriales.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblAula;
        private final TextView lblMaterial;

        ViewHolder(View itemView) {
            super(itemView);
            lblAula = (TextView) itemView.findViewById(R.id.lblAula);
            lblMaterial = (TextView) itemView.findViewById(R.id.lblMaterial);
        }
    }
}
