package es.saladillo.alejandro.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView nav;
    private FragmentManager mGestorFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        mGestorFragmentos = getSupportFragmentManager();
        nav = (BottomNavigationView) findViewById(R.id.nav);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.op1:
                        mostrarFragmento("Opción 1");
                        break;
                    case R.id.op2:
                        mostrarFragmento("Opción 2");
                        break;
                    case R.id.op3:
                        mostrarFragmento("Opción 3");
                        break;
                }
                return true;
            }
        });
    }

    private void mostrarFragmento(String opcion) {
        mGestorFragmentos.beginTransaction()
                .replace(R.id.flContent, MainFragment.newInstance(opcion), MainFragment.ARG_TITULO)
                .commit();
    }
}
