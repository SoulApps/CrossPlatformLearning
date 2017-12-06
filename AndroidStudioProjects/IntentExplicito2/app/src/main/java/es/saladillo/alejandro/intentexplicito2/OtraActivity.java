package es.saladillo.alejandro.intentexplicito2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OtraActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtEdad;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra);
        initVistas();
    }

    private void initVistas() {
        int i;
        String s;

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (intent.hasExtra("nombre")) {
                    s = extras.getString("nombre");
                    if (s != null)
                        if (!s.equals("-") && !s.equals(" ") && !s.equals(""))
                            txtNombre.setText(s);
                }
                if (intent.hasExtra("edad")) {
                    i = extras.getInt("edad");
                    if (i != -1)
                        txtEdad.setText(String.valueOf(i));
                }
            }
        }


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static void startForResult(Activity actividad, int requestCode, String nombre, int edad) {
        Intent intent = new Intent(actividad, OtraActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("edad", edad);
        actividad.startActivityForResult(intent, requestCode);
    }


    @Override
    public void finish() {
        Intent resultado = new Intent();
        resultado.putExtra("nombre", txtNombre.getText().toString());
        resultado.putExtra("edad", txtEdad.getText().toString());
        setResult(Activity.RESULT_OK, resultado);
        super.finish();
    }
}
