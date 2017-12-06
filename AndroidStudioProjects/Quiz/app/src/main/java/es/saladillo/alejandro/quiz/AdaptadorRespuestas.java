package es.saladillo.alejandro.quiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 03/12/2016.
 */

public class AdaptadorRespuestas extends ArrayAdapter<String> {

    private ArrayList<String> respuestas;

    public AdaptadorRespuestas(Context context, ArrayList<String> respuestas) {
        super(context, R.layout.respuesta, respuestas);
        this.respuestas = respuestas;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.respuesta, parent, false);
            holder = new ViewHolder(convertView);
        } else
            holder = (ViewHolder) convertView.getTag();

        escribir(position, holder);
        convertView.setTag(holder);

        return convertView;
    }

    private static class ViewHolder {
        private TextView lblRespuesta;

        private ViewHolder(View vista) {
            lblRespuesta = (TextView) vista.findViewById(R.id.lblRespuesta);
        }
    }

    private void escribir(int position, ViewHolder holder) {
        holder.lblRespuesta.setText(respuestas.get(position));
    }
}
