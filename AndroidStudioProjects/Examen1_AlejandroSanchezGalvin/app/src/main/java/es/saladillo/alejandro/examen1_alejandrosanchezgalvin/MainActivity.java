package es.saladillo.alejandro.examen1_alejandrosanchezgalvin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView grdPersonajes;
    private TextView lblVacio;

    private TextView lblPersonaje;
    private ImageView flecha;

    //Estáticos para ocultar la barra desplegable cuando esté vacía.
    private static TextView lblDescripcion;
    private static View desplegable;

    private AdaptadorPersonajes adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        grdPersonajes = (GridView) findViewById(R.id.grdPersonajes);
        lblVacio = (TextView) findViewById(R.id.lblVacio);
        lblPersonaje = (TextView) findViewById(R.id.lblNombrePersonaje);
        lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);
        flecha = (ImageView) findViewById(R.id.flecha);
        desplegable = findViewById(R.id.desplegabe);

        adaptador = new AdaptadorPersonajes(this, grdPersonajes);
        grdPersonajes.setEmptyView(lblVacio);
        grdPersonajes.setAdapter(adaptador);

        grdPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Personaje personaje = (Personaje) grdPersonajes.getItemAtPosition(position);
                lblPersonaje.setText(personaje.getNombre());
                lblDescripcion.setText(personaje.getDescripcion());
            }
        });


        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lblDescripcion.getVisibility() == View.GONE) {
                    lblDescripcion.setVisibility(View.VISIBLE);
                    flecha.setImageResource(R.mipmap.flecha_abajo);
                }
                else {
                    lblDescripcion.setVisibility(View.GONE);
                    flecha.setImageResource(R.mipmap.flecha_arriba);
                }
            }
        });

        lblVacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu_activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuNuevo:
                agregar();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void agregar() {
        Intent intent = new Intent(this, AgregarActivity.class);
        startActivityForResult(intent, AgregarActivity.RC_AGREGAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == AgregarActivity.RC_AGREGAR && resultCode == RESULT_OK) {
            adaptador.notifyDataSetChanged();
            actualizarVista();
        }
    }

    public static void actualizarVista() {
        if (Coleccion.getLista().size() > 0)
            desplegable.setVisibility(View.VISIBLE);
        else {
            lblDescripcion.setVisibility(View.GONE);
            desplegable.setVisibility(View.INVISIBLE);
        }
    }
}
