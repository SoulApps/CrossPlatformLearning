package es.saladillo.alejandro.intentexplicito3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int RC_OTRA = 1;
    private Button btnCambiar;
    private TextView lblNombre;
    private TextView lblEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        btnCambiar = (Button) findViewById(R.id.btnCambiar);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblEdad = (TextView) findViewById(R.id.lblEdad);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                String s;
                Alumno alumno;

                if (!lblNombre.getText().toString().equals("-"))
                    s = lblNombre.getText().toString();
                else
                    s = "";

                if (!lblEdad.getText().toString().equals("-"))
                    i = Integer.parseInt(lblEdad.getText().toString());
                else
                    i = -1;

                alumno = new Alumno(s, i);
                OtraActivity.startForResult(MainActivity.this, RC_OTRA, alumno);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_OTRA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                if (data.hasExtra("alumno")) {
                    Alumno alumno = data.getParcelableExtra("alumno");
                    lblNombre.setText(alumno.getNombre());
                    lblEdad.setText(String.valueOf(alumno.getEdad()));
                }
            }
        }
    }
}
