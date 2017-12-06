package es.saladillo.alejandro.servicio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_EXPORTADO = "Mi acción";

    private Button btnIniciar;
    private Intent intent;
    private BroadcastReceiver mReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        intent = new Intent(MainActivity.this, Servicio.class);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });

        mReceptor = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(MainActivity.this, "Archivo exportado", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Se crea el filtro para al receptor.
        IntentFilter filtro = new IntentFilter(ACTION_EXPORTADO);
        // Se registra el receptor.
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceptor, filtro);
    }

    @Override
    protected void onPause() {
        // Se quita el registro del receptor.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceptor);
        super.onPause();
    }
}
