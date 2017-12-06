package es.saladillo.alejandro.practica02_alejandro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import es.saladillo.alejandro.practica02_alejandro.dialogs.AcercaDeDialog;
import es.saladillo.alejandro.practica02_alejandro.dialogs.ElegirFotoDialog;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ElegirFotoDialog.ElegirFotoListener {

    private Fragment mFragment;

    private View mView;
    private FloatingActionButton mFab;
    private Toolbar mToolbar;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = findViewById(R.id.hueco);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        cargarFragmentoInicial();

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OnFabPressListener) mFragment).onFabPress();
            }
        });
    }

    public void cargarFragmento(Fragment fragment, int fabImage, int navItemCheck, String titulo) {
        mFragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.hueco, mFragment).commit();
        getSupportActionBar().setTitle(titulo);
        if (fabImage != 0) {
            mFab.setImageResource(fabImage);
            mFab.setVisibility(View.VISIBLE);
        } else
            mFab.setVisibility(View.INVISIBLE);
        mNavigationView.setCheckedItem(navItemCheck);
    }

    private void cargarFragmentoInicial() {
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
        String inicio = preferencias.getString("Pantalla inicial", getString(R.string.pantalla_inicial_default));

        if (inicio.equals("Nuevo alumno"))
            cargarFragmento(DatosAlumnoFragment.newInstance(), R.drawable.ic_menu_camera, R.id.datos_alumno, "Nuevo alumno");
        else if (inicio.equals("Tutorías"))
            cargarFragmento(ListaAlumnosFragment.newInstance(), R.drawable.ic_add, R.id.tutorias, "Alumnos");
        else
            cargarFragmento(ListaProximasVisitasFragment.newInstance(), 0, R.id.proximas_visitas, "Próximas visitas");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.guardar) {
            ((OnGuardarClick) mFragment).guardar();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.datos_alumno) {
            cargarFragmento(DatosAlumnoFragment.newInstance(), R.drawable.ic_menu_camera, R.id.datos_alumno, "Nuevo alumno");
        } else if (id == R.id.tutorias) {
            cargarFragmento(ListaAlumnosFragment.newInstance(), R.drawable.ic_add, R.id.tutorias, "Alumnos");
        } else if (id == R.id.proximas_visitas) {
            cargarFragmento(ListaProximasVisitasFragment.newInstance(), 0, R.id.proximas_visitas, "Próximas visitas");
        } else if (id == R.id.configuracion) {
            startActivity(new Intent(this, PreferencesActivity.class));
        } else if (id == R.id.acerca_de) {
            new AcercaDeDialog().show(MainActivity.this.getSupportFragmentManager(), "Acerca de");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(int which) {
        ((DatosAlumnoFragment) mFragment).onItemClick(which);
    }
}
