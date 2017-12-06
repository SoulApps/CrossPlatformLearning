package es.iessaladillo.iessaladillo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.iessaladillo.iessaladillo.R;
import es.iessaladillo.iessaladillo.models.Hardware;

/**
 * Created by Alejandro on 22/05/2017.
 */

public class InventarioAdapter extends ArrayAdapter<Hardware> {

    private Context mContext;

    public InventarioAdapter(Context context) {
        super(context, R.layout.fila_inventario);
        mContext = context;
    }

    public void actualizar(ArrayList<Hardware> inventario) {
        clear();
        addAll(inventario);
    }

    private static class ViewHolder {
        private final TextView lblCodBarras;
        private final TextView lblDescripcion;
        private final TextView lblDisponibles;

        ViewHolder(View view) {
            lblCodBarras = (TextView) view.findViewById(R.id.lblCodBarras);
            lblDescripcion = (TextView) view.findViewById(R.id.lblDescripcion);
            lblDisponibles = (TextView) view.findViewById(R.id.lblDisponibles);
        }

        void bind(Hardware hardware, Context context) {
            short unidadesDisponibles = (short) (hardware.getUnidadesTotales() - hardware.getUnidadesEnUso());
            lblCodBarras.setText(hardware.getCodBarras());
            if (hardware.getDescripcion().length() <= 32)
                lblDescripcion.setText(hardware.getDescripcion());
            else
                lblDescripcion.setText(String.format("%s%s", hardware.getDescripcion().substring(0, 30), "..."));
            lblDisponibles.setText(context.getResources()
                    .getQuantityString(R.plurals.disponibles, unidadesDisponibles, unidadesDisponibles));
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_inventario, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        Hardware hardware = getItem(position);
        holder.bind(hardware, mContext);
    }
}
