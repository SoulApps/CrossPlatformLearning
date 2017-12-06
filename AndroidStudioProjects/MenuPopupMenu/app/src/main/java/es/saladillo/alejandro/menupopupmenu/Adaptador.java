package es.saladillo.alejandro.menupopupmenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Alejandro on 28/10/2016.
 */

public class Adaptador extends ArrayAdapter<Alumno> {

    private final Alumno[] datos;

    public Adaptador(Context contexto, Alumno[] datos) {
        super(contexto, R.layout.fila, datos);
        this.datos = datos;
    }


    private static class ViewHolder {

        private final TextView lblNombre;
        private final TextView lblEdad;
        private final TextView lblRepetidor;
        private final ImageView imgFoto;

        public ViewHolder(View view) {
            lblNombre = (TextView) view.findViewById(R.id.lblNombre);
            lblEdad = (TextView) view.findViewById(R.id.lblEdad);
            lblRepetidor = (TextView) view.findViewById(R.id.lblRepetidor);
            imgFoto = (ImageView) view.findViewById(R.id.imgFoto);
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

    private void onBindViewHolder(ViewHolder holder, int position) {
        Alumno a = datos[position];
        holder.lblNombre.setText(a.getNombre());
        holder.lblEdad.setText(String.valueOf(a.getEdad()));
        if (a.isRepetidor())
            holder.lblRepetidor.setText(R.string.repetidor);
        else
            holder.lblRepetidor.setText("");

        holder.imgFoto.setOnClickListener(new imgPopupMenuOnClickListener(
                datos[position]));
    }

    private class imgPopupMenuOnClickListener implements View.OnClickListener {

        private final Alumno mAlumno;

        // Constructor. Recibe el alumno asociado.
        public imgPopupMenuOnClickListener(Alumno alumno) {
            mAlumno = alumno;
        }

        // Cuando se hace click sobre el icono.
        @Override
        public void onClick(View v) {
            // Se crea el menú.
            PopupMenu popup = new PopupMenu(getContext(), v);
            // Se infla la especificación de menú.
            MenuInflater inflador = popup.getMenuInflater();
            inflador.inflate(R.menu.menu_alumno, popup.getMenu());
            // Se crea el listener para cuando se pulse un ítem del menú, a cuyo
            // constructor se le pasa el mAlumno asociado.
            popup.setOnMenuItemClickListener(new PopupMenuOnMenuItemClickListener(mAlumno));
            // Se muestra el menú.
            popup.show();
        }
    }

    private class PopupMenuOnMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        Alumno alumno;
        public PopupMenuOnMenuItemClickListener(Alumno alumno) {
            this.alumno = alumno;
        }

        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nmuLlamar:
                    Toast.makeText(getContext(), "LLamando a " + alumno.getNombre(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.nmuEnviarEmail:
                    Toast.makeText(getContext(), "Enviando email a " + alumno.getNombre(), Toast.LENGTH_LONG).show();
                    break;
            }
            return true;
        }
    }
}
