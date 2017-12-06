package es.saladillo.alejandro.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import es.saladillo.alejandro.eventbus.events.AlumnoEvent;
import es.saladillo.alejandro.eventbus.events.Servicio;

public class MainActivity extends AppCompatActivity {

    private TextView lblNombre;
    private TextView lblEdad;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();


    }

    private void initVistas() {
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblEdad = (TextView) findViewById(R.id.lblEdad);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this, Servicio.class));
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        // Se registra en el bus por defecto.
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAlumnoReceive(AlumnoEvent event) {
        lblNombre.setText(event.getAlumno().getNombre());
        lblEdad.setText(String.valueOf(event.getAlumno().getEdad()));
    }

    @Override
    public void onStop() {
        // Se desregistra del bus por defecto.
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
