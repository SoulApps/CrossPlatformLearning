package es.saladillo.alejandro.okhttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import es.saladillo.alejandro.okhttp.events.GetEvent;
import es.saladillo.alejandro.okhttp.events.GetService;
import es.saladillo.alejandro.okhttp.events.PostEvent;
import es.saladillo.alejandro.okhttp.events.PostService;

public class MainActivity extends AppCompatActivity {

    public static final String ARG_NOMBRE = "NOMBRE";

    private EditText txtNombre;
    private Button btnBuscar;
    private Button btnEco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnEco = (Button) findViewById(R.id.btnEco);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GetService.class);
                intent.putExtra(ARG_NOMBRE, txtNombre.getText().toString());
                startService(intent);
            }
        });

        btnEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PostService.class);
                intent.putExtra(ARG_NOMBRE, txtNombre.getText().toString());
                startService(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetReceive(GetEvent event) {
        Toast.makeText(this, event.getResultado(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPostReceive(PostEvent event) {
        Toast.makeText(this, event.getResultado(), Toast.LENGTH_SHORT).show();
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
