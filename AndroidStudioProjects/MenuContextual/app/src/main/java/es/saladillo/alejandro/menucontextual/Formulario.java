package es.saladillo.alejandro.menucontextual;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    private static final String EXTRA_POSITION = "EXTRA_POSITION";
    private static final String EXTRA_ALUMNO = "EXTRA_ALUMNO";
    TextView lblNombre2,lblEdad2;
    EditText txtNombre,txtEdad;
    CheckBox chxRepetidor;
    Button btnGuardar;
    Intent intent;
    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        initVistas();
        intent=getIntent();


        if(intent.hasExtra(EXTRA_POSITION)&&intent.hasExtra(EXTRA_ALUMNO)){
            Alumno alumno=intent.getParcelableExtra(EXTRA_ALUMNO);
            extras=intent.getExtras();

            txtNombre.setText(alumno.nombre);
            txtEdad.setText(String.valueOf(alumno.edad));
            chxRepetidor.setChecked(alumno.repetidor);
        }



    }

    public void initVistas(){
        lblNombre2= (TextView) findViewById(R.id.lblNombre2);
        lblEdad2= (TextView) findViewById(R.id.lblEdad2);
        txtNombre= (EditText) findViewById(R.id.txtNombre);
        txtEdad= (EditText) findViewById(R.id.txtEdad);
        btnGuardar= (Button) findViewById(R.id.btnGuardar);
        chxRepetidor= (CheckBox) findViewById(R.id.chxRepetidor);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alumnoValido()){
                     guardarAlumno();
                    enviarResultado();
                }
                else
                    Toast.makeText(Formulario.this,"No estan los campos rellenos",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Para que el botón de arriba vaya hacia atrás.
    /*@Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }*/

    private void enviarResultado() {
        Intent intent=new Intent();
        setResult(RESULT_OK,intent);

        finish();
    }

    private boolean alumnoValido() {
        return !TextUtils.isEmpty(txtNombre.getText().toString()) && !TextUtils.isEmpty(txtEdad.getText().toString());
    }

    public void guardarAlumno(){
        Alumno alumno=new Alumno(R.drawable.avatar,
                txtNombre.getText().toString(),
                Integer.parseInt(txtEdad.getText().toString()),
                chxRepetidor.isChecked());

        if(!this.intent.hasExtra(EXTRA_POSITION)){
            BaseDatos.agregarAlumno(alumno);
        }
        else if(this.intent.hasExtra(EXTRA_POSITION)){
            int c=(int)extras.get(EXTRA_POSITION);
            BaseDatos.modificarAlumno(alumno,c);
        }
    }
    public static void startForResult(Activity actividad, int code){
        Intent intent=new Intent();
        intent.setAction("android.intentexplicito.action.ATACAR");
        actividad.startActivityForResult(intent,code);
    }
    public static void startForResult(Activity actividad, int code,int position,Alumno alumno){
        Intent intent=new Intent();
        intent.putExtra(EXTRA_POSITION,position);
        intent.putExtra(EXTRA_ALUMNO,alumno);
        intent.setAction("android.intentexplicito.action.ATACAR");
        actividad.startActivityForResult(intent,code);
    }
}
