package es.saladillo.alejandro.broadcastreceiverbateria;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mReceptor;
    private TextView lblNivel;
    private ProgressBar pbNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        lblNivel = (TextView) findViewById(R.id.lblNivel);
        pbNivel = (ProgressBar) findViewById(R.id.pbNivel);

        mReceptor = new BatteryReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filtro = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mReceptor, filtro);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceptor);
    }

    private class BatteryReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // Se obtienen los datos relevantes.
            int estado = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean estaCargando =
                    estado == BatteryManager.BATTERY_STATUS_CHARGING ||
                            estado == BatteryManager.BATTERY_STATUS_FULL;
            int enchufado = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean cargaPorUsb = enchufado == BatteryManager.BATTERY_PLUGGED_USB;
            boolean cargaPorEnchufe = enchufado == BatteryManager.BATTERY_PLUGGED_AC;
            int nivel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int escala = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float porcentaje = nivel / (float) escala;
            // Se actualizan los datos en la actividad.
            StringBuilder sb = new StringBuilder();
            if (estaCargando) {
                sb.append(getString(R.string.cargando)).append(" ");
                if (cargaPorUsb) {
                    sb.append(getString(R.string.por_usb)).append(" ");
                } else if (cargaPorEnchufe) {
                    sb.append(getString(R.string.conectado)).append(" ");
                }
            } else {
                sb.append(getString(R.string.porcentaje)).append(" ");
            }
            sb.append("(").append(nivel).append("%)");
            lblNivel.setText(sb.toString());
            pbNivel.setProgress(nivel);
        }
    }
}
