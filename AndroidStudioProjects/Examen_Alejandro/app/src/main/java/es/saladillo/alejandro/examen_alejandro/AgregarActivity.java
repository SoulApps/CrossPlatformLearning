package es.saladillo.alejandro.examen_alejandro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;
import es.saladillo.alejandro.examen_alejandro.bd.DAO;
import es.saladillo.alejandro.examen_alejandro.models.Libro;

public class AgregarActivity extends AppCompatActivity implements EstaSeguroDialog.EstaSeguroListener {

    public static int RC_AGREGAR = 1;

    private boolean confirmar;

    @BindView(R.id.inputTitulo)
    TextInputLayout inputTitulo;
    @BindView(R.id.inputAutor)
    TextInputLayout inputAutor;
    @BindView(R.id.inputPublicacion)
    TextInputLayout inputPublicacion;

    @BindView(R.id.txtTitulo)
    TextInputEditText txtTitulo;
    @BindView(R.id.txtAutor)
    TextInputEditText txtAutor;
    @BindView(R.id.txtPublicacion)
    TextInputEditText txtPublicacion;
    @BindView(R.id.txtPortada)
    TextInputEditText txtPortada;
    @BindView(R.id.txtSinopsis)
    TextInputEditText txtSinopsis;
    @BindView(R.id.imgPortada)
    ImageView imgPortada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        ButterKnife.bind(this);

        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
        confirmar = preferencias.getBoolean("confirmar", true);
    }

    private void guardar() {
        boolean error = false;
        if (TextUtils.isEmpty(txtTitulo.getText())) {
            inputTitulo.setError(getString(R.string.campo_obligatorio));
            error = true;
        } else
            inputTitulo.setError(null);

        if (TextUtils.isEmpty(txtAutor.getText())) {
            inputAutor.setError(getString(R.string.campo_obligatorio));
            error = true;
        } else
            inputAutor.setError(null);

        if (TextUtils.isEmpty(txtPublicacion.getText())) {
            inputPublicacion.setError(getString(R.string.campo_obligatorio));
            error = true;
        } else
            inputPublicacion.setError(null);

        if (!error) {
            if (confirmar) {
                new EstaSeguroDialog().show(this.getSupportFragmentManager(), "¿Quieres guardar?");
            }
            else
                insertar();
        }
    }

    private void insertar() {
        DAO.getInstance(this).createLibro(new Libro(
                txtTitulo.getText().toString(),
                txtAutor.getText().toString(),
                Integer.parseInt(txtPublicacion.getText().toString()),
                txtPortada.getText().toString(),
                txtSinopsis.getText().toString()
        ));
        setResult(RESULT_OK, new Intent());
        finish();
    }

    @OnFocusChange(R.id.txtPortada)
    public void cargarFoto() {
        if (!txtPortada.isFocused() && !TextUtils.isEmpty(txtPortada.getText().toString())) {
            Picasso.with(AgregarActivity.this).load(txtPortada.getText().toString())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(imgPortada);
        }
    }

    @Override
    public void onSi() {
        insertar();
    }

    @Override
    public void onNo() {

    }
}
