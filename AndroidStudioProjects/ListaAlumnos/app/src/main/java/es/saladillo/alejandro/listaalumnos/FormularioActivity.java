package es.saladillo.alejandro.listaalumnos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class FormularioActivity extends AppCompatActivity {

    private int foto;
    private EditText txtNombre;
    private EditText txtEdad;
    private CheckBox chkRepetidor;
    private ImageView imgFoto;
    private Button btnGuardar;
    private Alumno alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        initVistas();
    }

    private void initVistas() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        chkRepetidor = (CheckBox) findViewById(R.id.chkRepetidor);
        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (intent.hasExtra("alumno")) {
                    alumno = intent.getParcelableExtra("alumno");
                    txtNombre.setText(alumno.getNombre());
                    txtEdad.setText(String.valueOf(alumno.getEdad()));
                    chkRepetidor.setChecked(alumno.isRepetidor());
                    //imgFoto.setImageResource(extras.getInt("foto"));
                }
            }
        }


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(txtNombre.getText().toString()) && !TextUtils.isEmpty(txtEdad.getText().toString()))
                    guardar();
            }
        });

        /*imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foto == R.drawable.kappa) {
                    imgFoto.setImageResource(R.drawable.pogchamp);
                    foto = 1;
                }
                else {
                    imgFoto.setImageResource(R.drawable.kappa);
                    foto = 0;
                }
            }
        });*/
    }

    public static void startForResult(Activity actividad, int requestCode, Alumno alumno) {
        Intent intent = new Intent(actividad, FormularioActivity.class);
        intent.putExtra("alumno", alumno);
        actividad.startActivityForResult(intent, requestCode);
    }

    public static void startForResult(Activity actividad, int requestCode) {
        Intent intent = new Intent(actividad, FormularioActivity.class);
        actividad.startActivityForResult(intent, requestCode);
    }

    private void guardar() {
        //int imagen = foto == 1?R.drawable.pogchamp:R.drawable.kappa;
        if (alumno == null) {
            Intent resultado = new Intent();
            alumno = new Alumno(txtNombre.getText().toString(), Integer.parseInt(txtEdad.getText().toString()), chkRepetidor.isChecked(), 0);
            resultado.putExtra("alumno", alumno);
            setResult(Activity.RESULT_OK, resultado);
        }
        else {
            alumno.setNombre(txtNombre.getText().toString());
            alumno.setEdad(Integer.parseInt(txtEdad.getText().toString()));
            alumno.setRepetidor(chkRepetidor.isChecked());
            setResult(Activity.RESULT_OK);
        }
        finish();
    }

}
