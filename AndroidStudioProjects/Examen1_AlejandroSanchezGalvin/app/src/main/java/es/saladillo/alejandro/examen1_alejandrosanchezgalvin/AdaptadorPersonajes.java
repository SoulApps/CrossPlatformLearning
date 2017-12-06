package es.saladillo.alejandro.examen1_alejandrosanchezgalvin;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Alejandro on 13/12/2016.
 */

public class AdaptadorPersonajes extends ArrayAdapter<Personaje> {

    private ArrayList<Personaje> lista;
    private Activity actividad;
    private View referencia;

    public AdaptadorPersonajes(Activity actividad, View v) {
        super(actividad, R.layout.celda, Coleccion.getLista());
        this.lista = Coleccion.getLista();
        this.actividad = actividad;
        referencia = v;
    }

    private static class ViewHolder {

        private final ImageView imagen;
        private final TextView lblNombrePersonaje;
        private final TextView lblNombreActor;
        private final ImageView menu;

        public ViewHolder(View view) {
            imagen = (ImageView) view.findViewById(R.id.imagen);
            lblNombrePersonaje = (TextView) view.findViewById(R.id.lblNombrePersonaje);
            lblNombreActor = (TextView) view.findViewById(R.id.lblNombreActor);
            menu = (ImageView) view.findViewById(R.id.botones);
        }

        public void bind(Personaje personaje) {
            lblNombrePersonaje.setText(personaje.getNombre());
            lblNombreActor.setText(personaje.getInterprete());
            if (!personaje.getUrlPoster().equals(""))
                Picasso.with(imagen.getContext()).load(personaje.getUrlPoster()).into(imagen);
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
        Personaje personaje = lista.get(position);
        holder.bind(personaje);

        holder.menu.setOnClickListener(new ImgPopupMenuOnClickListener(lista.get(position)));
    }

    //Click menú puntitos.
    private class ImgPopupMenuOnClickListener implements View.OnClickListener {

        private final Personaje personaje;

        // Constructor. Recibe el personaje asociado.
        public ImgPopupMenuOnClickListener(Personaje personaje) {
            this.personaje = personaje;
        }

        // Cuando se hace click sobre el icono.
        @Override
        public void onClick(View v) {
            // Se crea el menú.
            PopupMenu popup = new PopupMenu(getContext(), v);
            // Se infla la especificación de menú.
            MenuInflater inflador = popup.getMenuInflater();
            inflador.inflate(R.menu.menu_puntos, popup.getMenu());
            // Se crea el listener para cuando se pulse un ítem del menú, a cuyo
            // constructor se le pasa el mAlumno asociado.
            popup.setOnMenuItemClickListener(new PopupMenuOnMenuItemClickListener(personaje));
            // Se muestra el menú.
            popup.show();
        }
    }

    private class PopupMenuOnMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        Personaje personaje;

        public PopupMenuOnMenuItemClickListener(Personaje personaje) {
            this.personaje = personaje;
        }

        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mnuEliminar:
                    eliminar(personaje);
                    break;
                case R.id.mnuBuscar:
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, personaje.getNombre());
                    startActivity(actividad, intent, null);
                    break;
            }
            return true;
        }
    }

    private void eliminar(final Personaje personaje) {
        remove(personaje);
        String cadena = getContext().getResources().getString(R.string.eliminado, personaje.getNombre());

        Snackbar.make(referencia, cadena, Snackbar.LENGTH_LONG).setAction(getContext().getResources().getString(R.string.deshacer), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(personaje);
                MainActivity.actualizarVista();
            }
        }).show();
        MainActivity.actualizarVista();
    }
}
