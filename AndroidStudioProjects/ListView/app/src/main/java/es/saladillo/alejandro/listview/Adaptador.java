package es.saladillo.alejandro.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Saha on 08/11/2016.
 */

public class Adaptador extends ArrayAdapter {

    private ArrayList<String> alumnos;

    public Adaptador(Context context, ArrayList<String> alumnos) {
        super(context, R.layout.item, alumnos);
        this.alumnos = alumnos;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        onBind(position, holder);
        convertView.setTag(holder);

        return convertView;
    }

    private static class ViewHolder {
        private TextView nombre;

        public ViewHolder(View vista) {
            nombre = (TextView) vista.findViewById(R.id.lblNombre);
        }

    }

    public void onBind(int position, ViewHolder holder) {
        holder.nombre.setText(alumnos.get(position));
    }
}
