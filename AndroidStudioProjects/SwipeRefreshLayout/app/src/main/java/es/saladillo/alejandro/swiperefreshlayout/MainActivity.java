package es.saladillo.alejandro.swiperefreshlayout;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import es.saladillo.alejandro.swiperefreshlayout.events.AlumnoEvent;
import es.saladillo.alejandro.swiperefreshlayout.events.Servicio;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swlPanel;
    private TextView lblNombre;
    private TextView lblEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblEdad = (TextView) findViewById(R.id.lblEdad);
        swlPanel = (SwipeRefreshLayout) findViewById(R.id.swlPanel);
        swlPanel.setOnRefreshListener(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        // Se registra en el bus por defecto.
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        // Se desregistra del bus por defecto.
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAlumnoReceive(AlumnoEvent event) {
        lblNombre.setText(event.getAlumno().getNombre());
        lblEdad.setText(String.valueOf(event.getAlumno().getEdad()));
        swlPanel.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        swlPanel.setRefreshing(true);
        startService(new Intent(MainActivity.this, Servicio.class));
    }

}
