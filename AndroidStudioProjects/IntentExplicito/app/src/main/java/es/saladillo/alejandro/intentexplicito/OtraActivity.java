package es.saladillo.alejandro.intentexplicito;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class OtraActivity extends AppCompatActivity {

    private TextView lblNombre;
    private TextView lblEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        initVistas();
    }

    private void initVistas() {
        Intent intent = getIntent();
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblEdad = (TextView) findViewById(R.id.lblEdad);

        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (intent.hasExtra("Nombre"))
                    lblNombre.setText(extras.getString("Nombre"));
                if (intent.hasExtra("Edad"))
                    lblEdad.setText(String.valueOf(extras.getInt("Edad")));

            }
        }
    }

    public static void start(Context contexto, String nombre, int edad) {
        Intent intent = new Intent(contexto, OtraActivity.class);
        intent.putExtra("Nombre", nombre);
        intent.putExtra("Edad", edad);
        contexto.startActivity(intent);
    }
}
