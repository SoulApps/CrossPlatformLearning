package es.saladillo.alejandro.preferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lblPreferencias = (TextView) findViewById(R.id.lblPreferencias);
    }

    private void verPreferencias() {
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
        String insulta = preferencias.getBoolean("prefInsultar", true)?"le gusta robar pens":"le gusta ser manteado";
        String nombre = preferencias.getString("prefNombre", "?");
        String equipo = preferencias.getString("prefEquipo", "?");
        lblPreferencias.setText(String.format("A %s %s y su equipo favorito es el %s", nombre, insulta, equipo));
    }

    @Override
    protected void onResume() {
        super.onResume();
        verPreferencias();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.configuracion:
                startActivity(new Intent(this, PreferencesActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
