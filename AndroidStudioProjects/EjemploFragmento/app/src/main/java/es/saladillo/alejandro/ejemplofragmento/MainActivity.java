package es.saladillo.alejandro.ejemplofragmento;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.Listener {

    private MainFragment frg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String nombre = frg.getArguments().getString(MainFragment.EXTRA_NOMBRE);
        MainFragment.saludar(nombre, MainActivity.this);
        return super.onOptionsItemSelected(item);
    }

    private void initVistas() {
        cargarFragmento();
    }

    private void cargarFragmento() {
        FragmentManager gestor = getSupportFragmentManager();
        frg = MainFragment.newInstance("Baldomero");
        FragmentTransaction transaccion = gestor.beginTransaction();
        transaccion.replace(R.id.flFragmento, frg);

        transaccion.commit();
    }


    @Override
    public void insultar(String nombre, Context context) {
        //Toast.makeText(context, "Stfu " + nombre, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, OtraActivity.class);
        intent.putExtra("nombre", frg.txtNombre.getText().toString());
        startActivity(intent);
    }
}
