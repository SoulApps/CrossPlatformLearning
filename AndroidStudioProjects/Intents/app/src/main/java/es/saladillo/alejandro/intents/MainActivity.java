package es.saladillo.alejandro.intents;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static es.saladillo.alejandro.intents.R.id.btnUrl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        // La actividad responderá al pulsar sobre cualquier botón.
        findViewById(btnUrl).setOnClickListener(this);
        findViewById(R.id.btnBuscar).setOnClickListener(this);
        findViewById(R.id.btnLlamar).setOnClickListener(this);
        findViewById(R.id.btnMarcar).setOnClickListener(this);
        findViewById(R.id.btnVerMapa).setOnClickListener(this);
        findViewById(R.id.btnBuscarMapa).setOnClickListener(this);
        findViewById(R.id.btnLista).setOnClickListener(this);
        findViewById(R.id.btnEnviar).setOnClickListener(this);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case btnUrl:
                // Acción--> VER. Uri--> URL.
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.genbeta.com"));
                if (estaDisponible(this, intent)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No hay aplicación disponible",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnBuscar:
                // Acción--> BUSCAR EN INTERNET. Extra -> Término de consulta.
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "IES Saladillo");
                if (estaDisponible(this, intent)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No hay aplicación disponible",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnLlamar:
                // Acción--> LLAMAR. Uri--> tel:num.
                intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:(+34)123456789"));
                if (estaDisponible(this, intent)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No hay aplicación disponible",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnMarcar:
                // Acción--> MARCAR. Uri--> tel:num.
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+34)12345789"));
                if (estaDisponible(this, intent)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No hay aplicación disponible", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            case R.id.btnVerMapa:
                // Acción--> VER. Uri--> geo:latitud,longitud?z=zoom.
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:36.1121,-5.44347?z=19"));
                if (estaDisponible(this, intent)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No hay aplicación disponible",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnBuscarMapa:
                // Acción--> VER. Uri--> geo:latitud,longitud?q=consulta.
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=duque de rivas, Algeciras"));
                if (estaDisponible(this, intent)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No hay aplicación disponible",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnLista:
                // Acción--> VER. Uri--> Accederá al proveedor de contenidos de la
                // aplicación de contactos.
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                if (estaDisponible(this, intent)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No hay aplicación disponible",
                            Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnEnviar:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"
                    + "123456789"));
                intent = intent.putExtra("MENSAJE", txtMensaje.getText().toString());
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this, "No hay aplicación disponible",
                            Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    //Comprueba que haya aplicaciones disponibles
    private boolean estaDisponible(Context ctx, Intent intent) {
        final PackageManager gestorPaquetes = ctx.getPackageManager();
        List<ResolveInfo> listaApps = gestorPaquetes.queryIntentActivities(
                intent, PackageManager.MATCH_DEFAULT_ONLY);
        return listaApps.size() > 0;
    }
}
