package es.saladillo.alejandro.intentexplicito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnMostrar;
    private EditText txtNombre;
    private EditText txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtraActivity.start(MainActivity.this, txtNombre.getText().toString(), Integer.parseInt(txtEdad.getText().toString()));
            }
        });
    }
}
