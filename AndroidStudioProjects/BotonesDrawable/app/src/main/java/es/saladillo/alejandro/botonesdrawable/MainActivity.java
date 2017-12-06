package es.saladillo.alejandro.botonesdrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boton;
    private Button habilitar;
    private Button deshabilitar;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        boton = (Button) findViewById(R.id.button1);
        habilitar = (Button) findViewById(R.id.button2);
        deshabilitar = (Button) findViewById(R.id.button3);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton.setBackgroundResource(R.drawable.boton_pulsado);
                boton.setBackgroundResource(android.R.drawable.btn_default);
            }
        });

        habilitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton.setEnabled(true);
                boton.setBackgroundResource(R.drawable.boton_habilitado);
            }
        });

        deshabilitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton.setBackgroundResource(R.drawable.boton_deshabilitado);
                boton.setEnabled(false);
            }
        });
    }
}
