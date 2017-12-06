package es.iessaladillo.iessaladillo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import es.iessaladillo.iessaladillo.models.Tipo;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        GoogleApiClient.OnConnectionFailedListener {

    //Guarda el útlimo fragmento mostrado en esta actividad,
    //por lo que si se abre otra, al volver a MainActivity,
    //se mostrará el fragmento correspondiente.
    private static Fragment mFragment;

    private FloatingActionButton fab;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OnFabClickInterface) mFragment).onFabClick();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        actualizarDatosProfesorNavView();

        //Elijo que fragmento cargar según el tipo de profesor y la configuración si es TIC.
        if (GlobalValues.profesor.getTipo() == Tipo.NORMAL || GlobalValues.profesor.getTipo() == Tipo.DIRECCION) {
            mNavigationView.inflateMenu(R.menu.menu_normal);
            if (mFragment == null || mFragment instanceof CalendarioReservaFragment) {
                cargarFragmento(CalendarioReservaFragment.newInstance(), getString(R.string.reservar), -1, R.id.nav_reservar);
                mNavigationView.setCheckedItem(R.id.nav_reservar);
            } else {
                cargarFragmento(ReportarIncidenciaFragment.newInstance(), getString(R.string.reportar_incidencia), R.drawable.ic_done, R.id.nav_reportar);
                mNavigationView.setCheckedItem(R.id.nav_reportar);
            }
        } else if (GlobalValues.profesor.getTipo() == Tipo.TIC) {
            mNavigationView.inflateMenu(R.menu.menu_tic);
            SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
            String inicio = preferencias.getString("Pantalla inicial", getString(R.string.pantalla_inicial_default));

            //Cargo la pantalla por defecto que hayan elegido o el último fragmento.
            if (inicio.equals(getString(R.string.reservar)) && mFragment == null || mFragment instanceof CalendarioReservaFragment)
                cargarFragmento(CalendarioReservaFragment.newInstance(), getString(R.string.reservar), -1, R.id.nav_reservar);
            else if (inicio.equals(getString(R.string.reportar_incidencia)) && mFragment == null || mFragment instanceof ReportarIncidenciaFragment)
                cargarFragmento(ReportarIncidenciaFragment.newInstance(), getString(R.string.reportar_incidencia), R.drawable.ic_done, R.id.nav_reportar);
            else if (inicio.equals(getString(R.string.ver_incidencias)) && mFragment == null || mFragment instanceof ListaIncidenciasFragment)
                cargarFragmento(ListaIncidenciasFragment.newInstance(), getString(R.string.ver_incidencias), -1, R.id.nav_incidencias);
            else if (inicio.equals(getString(R.string.inventario)) && mFragment == null || mFragment instanceof InventarioFragment)
                cargarFragmento(InventarioFragment.newInstance(), getString(R.string.inventario), R.drawable.ic_add, R.id.nav_inventario);
        }
    }

    private void actualizarDatosProfesorNavView() {
        View view = mNavigationView.getHeaderView(0);
        TextView lblNombre = (TextView) view.findViewById(R.id.lblNombre);
        TextView lblEmail = (TextView) view.findViewById(R.id.lblEmail);
        ImageView imgFoto = (ImageView) view.findViewById(R.id.imgFoto);

        lblNombre.setText(String.format("%s %s", GlobalValues.profesor.getNombre(),
                GlobalValues.profesor.getApellido1()));

        lblEmail.setText(GlobalValues.profesor.getEmail());


        //Creación placeholder.

        //Se crea un color aleatorio.
        ColorGenerator colorGenerator = ColorGenerator.MATERIAL;

        //Se crea el placeholder por si no hay imagen o falla.
        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .width((int) getResources().getDimension(R.dimen.tamanho_foto))
                .height((int) getResources().getDimension(R.dimen.tamanho_foto))
                .endConfig()
                .buildRound(String.valueOf(GlobalValues.profesor.getNombre().charAt(0)), colorGenerator.getRandomColor());

        //Fin creación placeholder.


        //Si el usuario tiene una imagen, la carga; si no, o si falla, pone un placeholder.
        if (GlobalValues.profesor.getFoto() != null) {
            Picasso.with(this).load(GlobalValues.profesor.getFoto())
                    .placeholder(drawable)
                    .into(imgFoto, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {

                        }
                    });
        } else {
            //Carga el placeholder.
            imgFoto.setImageDrawable(drawable);
        }
    }

    @Override
    //Guarda la visibilidad del fab en el cambio de orientación.
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(GlobalValues.KEY_FAB_VISIBLE, fab.getVisibility() == View.VISIBLE);
    }

    @Override
    //Recupera la visibilidad del fab en el cambio de orientación.
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        boolean fabVisible = savedInstanceState.getBoolean(GlobalValues.KEY_FAB_VISIBLE);
        if (!fabVisible)
            fab.setVisibility(View.INVISIBLE);
        //No hace falta un else ya que por defecto es visible.
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_reservar) {
            cargarFragmento(CalendarioReservaFragment.newInstance(),
                    getString(R.string.reservar), -1, R.id.nav_reservar);
        } else if (id == R.id.nav_reportar) {
            cargarFragmento(ReportarIncidenciaFragment.newInstance(),
                    getString(R.string.reportar_incidencia), R.drawable.ic_done, R.id.nav_reportar);
        } else if (id == R.id.nav_incidencias) {
            cargarFragmento(ListaIncidenciasFragment.newInstance(),
                    getString(R.string.ver_incidencias), -1, R.id.nav_incidencias);
        } else if (id == R.id.nav_inventario) {
            cargarFragmento(InventarioFragment.newInstance(),
                    getString(R.string.inventario), R.drawable.ic_add, R.id.nav_inventario);
        } else if (id == R.id.nav_ajustes) {
            startActivity(new Intent(this, PreferencesActivity.class));
        } else if (id == R.id.nav_cerrar_sesion) {
            signOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void cargarFragmento(Fragment fragment, String titulo,
                                 @DrawableRes int imagenFab,
                                 @IdRes int navItemCheck) {
        //Compruebo que el fragmento ya exista.
        if (getSupportFragmentManager().findFragmentByTag(titulo) == null) {

            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(titulo);

            mFragment = fragment;

            if (imagenFab != -1) {
                fab.setImageResource(imagenFab);
                fab.setVisibility(View.VISIBLE);
            } else {
                fab.setVisibility(View.INVISIBLE);
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flHueco, fragment, titulo)
                    .commit();

            mNavigationView.setCheckedItem(navItemCheck);
        }
    }

    private void signOut() {
        //Backend
        Api.getApiInterface().logout(GlobalValues.profesor.getCodProf(), GlobalValues.profesor.getToken())
                .enqueue(new retrofit2.Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });


        //Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        final GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        googleApiClient.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
            @Override
            public void onConnected(@Nullable Bundle bundle) {
                if (googleApiClient.isConnected()) {
                    Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                        @Override
                        public void onResult(@NonNull Status status) {
                            if (status.isSuccess()) {
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
            }

            @Override
            public void onConnectionSuspended(int i) {

            }
        });
    }

    public void setFabEnabled(boolean enabled) {
        fab.setEnabled(enabled);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, R.string.error_internet, Toast.LENGTH_SHORT).show();
    }
}
