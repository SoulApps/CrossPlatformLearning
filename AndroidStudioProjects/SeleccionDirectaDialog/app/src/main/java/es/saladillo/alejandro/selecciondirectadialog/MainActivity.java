package es.saladillo.alejandro.selecciondirectadialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeleccionDirectaDialog.SeleccionDirectaListener, EstaSeguroDialog.EstaSeguroListener, SeleccionSimpleDialog.SeleccionSimpleListener, SeleccionMultipleDialog.SeleccionMultipleListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        Button btnElegir = (Button) findViewById(R.id.btnElegir);
        Button btnBorrar = (Button) findViewById(R.id.btnBorrar);
        Button btnSimple = (Button) findViewById(R.id.btnSimple);
        Button btnMulti = (Button) findViewById(R.id.btnMulti);

        btnElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SeleccionDirectaDialog().show(MainActivity.this.getSupportFragmentManager(), "Selección directa");
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EstaSeguroDialog().show(MainActivity.this.getSupportFragmentManager(), "Está seguro");
            }
        });

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SeleccionSimpleDialog().show(MainActivity.this.getSupportFragmentManager(), "Selección simple");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SeleccionMultipleDialog().show(MainActivity.this.getSupportFragmentManager(), "Selección multi");
            }
        });
    }

    @Override
    public void onSi() {
        Toast.makeText(this, "Sí", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNo() {
        Toast.makeText(this, "No", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(int which) {
        Toast.makeText(this, getResources().getStringArray(R.array.equipos)[which], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAceptar(int which) {
        Toast.makeText(this, getResources().getStringArray(R.array.equipos)[which], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAceptar(boolean[] checked) {

    }
}
