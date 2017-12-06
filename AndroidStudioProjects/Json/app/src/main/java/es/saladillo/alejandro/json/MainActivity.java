package es.saladillo.alejandro.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import es.saladillo.alejandro.json.events.GetEvent;
import es.saladillo.alejandro.json.events.GetService;
import es.saladillo.alejandro.json.util.HttpManager;

public class MainActivity extends AppCompatActivity {

    private ListView lstAlumnos;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        adaptador = new Adaptador(this);
        lstAlumnos.setAdapter(adaptador);
        startService(new Intent(this, GetService.class));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetReceive(GetEvent event) {
        adaptador.setAlumnos(event.getResultado());
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
}
