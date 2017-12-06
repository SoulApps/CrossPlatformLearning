package es.saladillo.alejandro.practica02_alejandro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Alejandro on 24/01/2017.
 */

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_preferencias, PreferencesFragment.newInstance()).commit();
    }

}
