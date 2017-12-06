package es.saladillo.alejandro.gestorfragmentos;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SaludoActivity extends AppCompatActivity {

    private SaludoFragment frgSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        cargarFragmentoSaludo();
    }

    private void cargarFragmentoSaludo() {
        FragmentManager gestor = getSupportFragmentManager();
        Intent intent = getIntent();
        frgSaludo = SaludoFragment.newInstance(intent.getStringExtra(MainFragment.ARG_NOMBRE));
        FragmentTransaction transaccion = gestor.beginTransaction();
        transaccion.replace(R.id.huecoSaludo, frgSaludo);

        transaccion.commit();
    }
}
