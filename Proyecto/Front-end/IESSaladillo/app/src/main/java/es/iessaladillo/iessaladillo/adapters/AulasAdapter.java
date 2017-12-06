package es.iessaladillo.iessaladillo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.iessaladillo.iessaladillo.models.Aula;

/**
 * Created by Alejandro on 28/04/2017.
 */

public class AulasAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private ArrayList<Aula> mLista;

    public AulasAdapter(@NonNull Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void actualizar(@NonNull ArrayList<Aula> lista) {
        mLista = lista;
        notifyDataSetChanged();
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        Aula aula = (Aula) getItem(position);
        if (aula != null)
            holder.lblElemento.setText(aula.getNombre());
    }

    private static class ViewHolder {
        private final TextView lblElemento;

        ViewHolder(View view) {
            lblElemento = (TextView) view.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(android.R.layout.simple_spinner_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        onBindViewHolder(holder, position);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        onBindViewHolder(holder, position);

        return convertView;
    }

    @Override
    public int getCount() {
        if (mLista != null)
            return mLista.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int i) {
        return mLista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
