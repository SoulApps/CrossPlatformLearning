package es.saladillo.alejandro.progresoasynctask;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MainFragment frg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null)
            cargarFragmento();

    }



    private void cargarFragmento() {
        FragmentManager gestor = getSupportFragmentManager();
        frg = MainFragment.newInstance();
        FragmentTransaction transaccion = gestor.beginTransaction();
        transaccion.replace(R.id.flFragmento, frg);

        transaccion.commit();
    }
}
