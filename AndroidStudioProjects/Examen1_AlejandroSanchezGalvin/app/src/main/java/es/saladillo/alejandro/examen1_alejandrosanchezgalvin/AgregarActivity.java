package es.saladillo.alejandro.examen1_alejandrosanchezgalvin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class AgregarActivity extends AppCompatActivity {

    public static final int RC_AGREGAR = 1;

    private EditText txtNombrePersonaje;
    private EditText txtNombreActor;
    private EditText txtUrlPoster;
    private CheckBox chkPrincipal;
    private Spinner spnTemporada;
    private EditText txtDescripcion;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        initVistas();
    }

    private void initVistas() {
        txtNombrePersonaje = (EditText) findViewById(R.id.txtNombrePersonaje);
        txtNombreActor = (EditText) findViewById(R.id.txtNombreActor);
        txtUrlPoster = (EditText) findViewById(R.id.txtUrlPoster);
        chkPrincipal = (CheckBox) findViewById(R.id.chkPrincipal);
        spnTemporada = (Spinner) findViewById(R.id.spnTemporada);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        imagen = (ImageView) findViewById(R.id.imagen);

        txtNombreActor.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    guardarPersonaje();
                    return true;
                }
                else
                    return false;
            }
        });


        txtUrlPoster.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !TextUtils.isEmpty(txtUrlPoster.getText().toString())) {
                    Picasso.with(AgregarActivity.this).load(txtUrlPoster.getText().toString())
                            .placeholder(R.drawable.imagen_default)
                            .error(R.drawable.imagen_default)
                            .into(imagen);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu_activity_agregar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuAnhadir:
                guardarPersonaje();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void guardarPersonaje() {
        //Compruebo que se cumplen los requisitos.
        if (!TextUtils.isEmpty(txtNombrePersonaje.getText().toString()) && !TextUtils.isEmpty(txtNombreActor.getText().toString())) {
            Coleccion.addPersonaje(new Personaje(txtNombrePersonaje.getText().toString(),
                    txtNombreActor.getText().toString(),
                    txtUrlPoster.getText().toString(),
                    chkPrincipal.isChecked(),
                    Integer.parseInt(spnTemporada.getSelectedItem().toString().charAt(0) + ""),
                    txtDescripcion.getText().toString())); //Añado a la colección.

            setResult(RESULT_OK, new Intent());
            finish();
        }
        else
            Toast.makeText(this, "El nombre del personaje y del intérprete son obligatorios.", Toast.LENGTH_LONG).show();
    }

}
