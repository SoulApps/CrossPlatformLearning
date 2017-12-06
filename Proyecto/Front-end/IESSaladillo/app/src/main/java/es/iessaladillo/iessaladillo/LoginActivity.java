package es.iessaladillo.iessaladillo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.iessaladillo.iessaladillo.models.Profesor;
import es.iessaladillo.iessaladillo.util.Api;
import es.iessaladillo.iessaladillo.util.GlobalValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity
        implements GoogleApiClient.OnConnectionFailedListener {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btnReintentar)
    Button btnReintentar;

    private boolean googleOk;
    private String email;
    private Uri foto;

    private GoogleSignInOptions gso;
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        googleOk = false;

        if (gso == null) {
            gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
        }

        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build();
        }

        login();
    }

    private void iniciarSesionGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, GlobalValues.RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GlobalValues.RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            foto = acct.getPhotoUrl();
            email = acct.getEmail();
            googleOk = true;
            iniciarSesionBackend();
        } else {
            Toast.makeText(LoginActivity.this, R.string.error_google, Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.INVISIBLE);
            btnReintentar.setVisibility(View.VISIBLE);
        }
    }


    private void iniciarSesionBackend() {
        progressBar.setVisibility(View.VISIBLE);
        btnReintentar.setVisibility(View.INVISIBLE);

        Call<ArrayList<Profesor>> peticion = Api.getApiInterface()
                .login(email);
        peticion.enqueue(new Callback<ArrayList<Profesor>>() {
            @Override
            public void onResponse(Call<ArrayList<Profesor>> call, Response<ArrayList<Profesor>> response) {
                // Si la respuesta es correcta.
                if (response != null && response.isSuccessful()) {
                    if (!response.body().isEmpty()) {
                        GlobalValues.profesor = response.body().get(0);
                        GlobalValues.profesor.setFoto(foto);
                        //Se abre MainActivity y se cierra LoginActivity.
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, R.string.error_usuario, Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                        signOutGoogle();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Profesor>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, R.string.error_internet, Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
                btnReintentar.setVisibility(View.VISIBLE);
            }
        });
    }

    @OnClick(R.id.btnReintentar)
    void login() {
        if (googleOk)
            iniciarSesionBackend();
        else
            iniciarSesionGoogle();
    }

    private void signOutGoogle() {
        googleApiClient.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
            @Override
            public void onConnected(@Nullable Bundle bundle) {
                if (googleApiClient.isConnected()) {
                    Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                        @Override
                        public void onResult(@NonNull Status status) {
                            if (status.isSuccess()) {
                                googleOk = false;
                                login();
                            } else {
                                Toast.makeText(LoginActivity.this, R.string.error_internet, Toast.LENGTH_SHORT).show();
                                btnReintentar.setVisibility(View.VISIBLE);
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

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, R.string.error_internet, Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
        btnReintentar.setVisibility(View.VISIBLE);
    }
}

