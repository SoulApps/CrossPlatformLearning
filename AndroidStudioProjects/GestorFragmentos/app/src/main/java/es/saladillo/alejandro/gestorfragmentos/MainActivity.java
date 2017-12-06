package es.saladillo.alejandro.gestorfragmentos;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainFragment.Listener {

    private MainFragment frgMain;
    private SaludoFragment frgSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarFragmentoMain();
    }

    private void cargarFragmentoSaludo() {
        FragmentManager gestor = getSupportFragmentManager();
        frgSaludo = SaludoFragment.newInstance(frgMain.txtNombre.getText().toString());
        FragmentTransaction transaccion = gestor.beginTransaction();
        transaccion.replace(R.id.huecoSaludo, frgSaludo);

        transaccion.commit();
    }

    private void cargarFragmentoMain() {
        FragmentManager gestor = getSupportFragmentManager();
        frgMain = MainFragment.newInstance();
        FragmentTransaction transaccion = gestor.beginTransaction();
        transaccion.replace(R.id.huecoMain, frgMain);

        transaccion.commit();
    }


    @Override
    public void saludar(String nombre) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            cargarFragmentoSaludo();
        else {
            Intent intent = new Intent(this, SaludoActivity.class);
            intent.putExtra(MainFragment.ARG_NOMBRE, frgMain.txtNombre.getText().toString());
            startActivity(intent);
        }
    }
}
