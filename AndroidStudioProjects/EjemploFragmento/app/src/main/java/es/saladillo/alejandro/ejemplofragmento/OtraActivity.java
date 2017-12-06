package es.saladillo.alejandro.ejemplofragmento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        initVistas();
    }

    private void initVistas() {
        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String nombre = extras.getString("nombre");
                txtNombre.setText(nombre);
            }
        }
    }
}
