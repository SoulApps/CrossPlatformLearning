package es.saladillo.alejandro.firebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference alumnos;
    private RecyclerView lstAlumnos;
    private ArrayList<Alumno> datos;
    //private Adaptador mAdaptador;
    private FirebaseRecyclerAdapter mAdaptador;

    //Para FirebaseUI.
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lblNombre;
        private final TextView lblEdad;

        public ViewHolder(View view) {
            super(view);
            lblNombre = (TextView) itemView.findViewById(R.id.lblNombre);
            lblEdad = (TextView) itemView.findViewById(R.id.lblEdad);
        }

        public void bind(Alumno a) {
            lblNombre.setText(a.getNombre());
            lblEdad.setText(String.valueOf(a.getEdad()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstAlumnos = (RecyclerView) findViewById(R.id.lstAlumnos);
        lstAlumnos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lstAlumnos.setItemAnimator(new DefaultItemAnimator());
        datos = new ArrayList<>();

        connectDB();

        /*mAdaptador = new Adaptador(datos);
        lstAlumnos.setAdapter(mAdaptador);*/

        mAdaptador = new FirebaseRecyclerAdapter<Alumno, ViewHolder>(Alumno.class, R.layout.fila, ViewHolder.class, alumnos) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Alumno model, int position) {
                viewHolder.bind(model);
            }
        };
        lstAlumnos.setAdapter(mAdaptador);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarAlumno();
            }
        });


        alumnos.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                datos.add(dataSnapshot.getValue(Alumno.class));
                mAdaptador.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                /* Parece que no hace falta para recoger los datos al iniciar.
                datos.add(dataSnapshot.getValue(Alumno.class));
                mAdaptador.notifyDataSetChanged();
                 */
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void connectDB() {
        database = FirebaseDatabase.getInstance();
        alumnos = database.getReference("alumnos");
    }

    private void agregarAlumno() {
        DatabaseReference alumnoNuevo = alumnos.push();
        String clave = alumnoNuevo.getKey();
        Alumno alumno = new Alumno(clave, "Baldomero", 18);
        alumnoNuevo.setValue(alumno);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
