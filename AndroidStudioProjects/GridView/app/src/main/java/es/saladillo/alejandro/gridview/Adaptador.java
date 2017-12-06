package es.saladillo.alejandro.gridview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alejandro on 11/11/2016.
 */

public class Adaptador extends ArrayAdapter {

    private ArrayList<Concepto> conceptos;
    private LayoutInflater inflador;

    public Adaptador(Context contexto, ArrayList<Concepto> conceptos) {
        super(contexto, R.layout.celda, conceptos);
        this.conceptos = conceptos;
        inflador = LayoutInflater.from(contexto);
    }

    private static class ViewHolder {

        private final ImageView foto;
        private final TextView lblSpanish;
        private final TextView lblEnglish;

        public ViewHolder(View view) {
            foto = (ImageView) view.findViewById(R.id.imgFoto);
            lblSpanish = (TextView) view.findViewById(R.id.lblSpanish);
            lblEnglish = (TextView) view.findViewById(R.id.lblEnglish);
        }

        public void bind(Concepto concepto) {
            foto.setImageResource(concepto.getFoto());
            lblEnglish.setText(concepto.getEnglish());
            lblSpanish.setText(concepto.getSpanish());
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.celda, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        onBindViewHolder(holder, position);

        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        Concepto concepto = conceptos.get(position);
        holder.bind(concepto);
    }
}
