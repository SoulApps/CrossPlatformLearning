package es.iessaladillo.iessaladillo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import es.iessaladillo.iessaladillo.util.GlobalValues;

public class DiaReservaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_reserva);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String dia = getIntent().getStringExtra(GlobalValues.ARG_DIA);

        //Compruebo que el fragmento ya exista.
        if (getSupportFragmentManager().findFragmentByTag(GlobalValues.ID_DIA_RESERVA_FRAGMENT) == null) {
            getSupportFragmentManager()
                    .beginTransaction().add(R.id.flHueco, DiaReservaFragment.newInstance(dia), GlobalValues.ID_DIA_RESERVA_FRAGMENT)
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
