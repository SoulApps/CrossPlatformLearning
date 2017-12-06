package es.saladillo.alejandro.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.saladillo.alejandro.sqlite.db.DAO;
import es.saladillo.alejandro.sqlite.db.models.Alumno;

public class AgregarActivity extends AppCompatActivity {

    public static final int RC_AGREGAR = 1;

    private EditText txtNombre, txtEdad;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        initVistas();
    }

    private void initVistas() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              DAO dao = DAO.getInstance(AgregarActivity.this);
                                              dao.createAlumno(new Alumno(txtNombre.getText().toString(), Integer.parseInt(txtEdad.getText().toString())));
                                              setResult(RESULT_OK, new Intent());
                                              finish();
                                          }
                                      }

        );
    }
}
