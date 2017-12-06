package es.saladillo.alejandro.practica02_alejandro;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.saladillo.alejandro.practica02_alejandro.bd.DAO;
import es.saladillo.alejandro.practica02_alejandro.dialogs.ElegirFotoDialog;
import es.saladillo.alejandro.practica02_alejandro.models.Alumno;

public class DatosAlumnoFragment extends android.support.v4.app.Fragment implements OnGuardarClick, OnFabPressListener, ElegirFotoDialog.ElegirFotoListener {

    private static final int RC_CAPTURAR_FOTO = 0;
    private static final int RC_SELECCIONAR_FOTO = 1;
    private static final int RP_ALMACEN_EXTERNO = 1;
    private static final String PREF_PATH_FOTO = "prefPathFoto";

    private String sPathFotoOriginal; // path en el que se guarda la foto capturada.
    private String sNombreArchivo; // Nombre para guardar en privado la foto escalada.

    private MostradorFotoAsyncTask mostrarFoto;

    private static Alumno mAlumnoActual;

    @BindView(R.id.txtNombreAlumno)
    TextView txtNombreAlumno;
    @BindView(R.id.txtTelefono)
    TextView txtTelefono;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtNombreEmpresa)
    TextView txtNombreEmpresa;
    @BindView(R.id.txtNombreTutor)
    TextView txtNombreTutor;
    @BindView(R.id.txtHorario)
    TextView txtHorario;
    @BindView(R.id.txtDireccion)
    TextView txtDireccion;
    @BindView(R.id.imgAlumno)
    ImageView imgAlumno;

    public DatosAlumnoFragment() {
        // Required empty public constructor
    }


    public static DatosAlumnoFragment newInstance() {
        mAlumnoActual = null;
        return new DatosAlumnoFragment();
    }

    //Rellena los datos del alumno seleccionado en la lista.
    public static DatosAlumnoFragment newInstance(Alumno alumno) {
        mAlumnoActual = alumno;
        return new DatosAlumnoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_datos_alumno, container, false);
        ButterKnife.bind(this, view);
        mostrarFoto = new MostradorFotoAsyncTask(getContext(), imgAlumno, sNombreArchivo);
        if (mAlumnoActual != null)
            cargarAlumno();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.guardar) {
            guardar();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void guardar() {
        if (txtNombreAlumno.getText().toString().equals("")){
            Toast.makeText(getContext(), "Error introduce el nombre del alumno", Toast.LENGTH_LONG).show();
        } else {
            DAO dao = DAO.getInstance(getContext());
            Alumno alumno = new Alumno(txtNombreAlumno.getText().toString(),
                    txtTelefono.getText().toString(),
                    txtEmail.getText().toString(),
                    txtNombreEmpresa.getText().toString(),
                    txtNombreTutor.getText().toString(),
                    txtHorario.getText().toString(),
                    txtDireccion.getText().toString(),
                    sPathFotoOriginal
            );
            if (mAlumnoActual == null) {
                dao.createAlumno(alumno);
            } else {
                alumno.setId(mAlumnoActual.getId());
                dao.updateAlumno(alumno);
            }

            //Muestro el fragmento con la lista de alumnos si es nuevo.
            if (mAlumnoActual == null)
                ((MainActivity) getActivity()).cargarFragmento(ListaAlumnosFragment.newInstance(), R.drawable.ic_add, R.id.tutorias, "Alumnos");

            //Oculto el teclado
            // Check if no view has focus:
            View view = getActivity().getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    private void cargarAlumno() {
        txtNombreAlumno.setText(mAlumnoActual.getNombre());
        txtTelefono.setText(mAlumnoActual.getTelefono());
        txtEmail.setText(mAlumnoActual.getEmail());
        txtNombreEmpresa.setText(mAlumnoActual.getEmpresa());
        txtNombreTutor.setText(mAlumnoActual.getTutor());
        txtHorario.setText(mAlumnoActual.getHorario());
        txtDireccion.setText(mAlumnoActual.getDireccion());
        if (mAlumnoActual.getImagen() != null)
            new MostradorFotoAsyncTask(getContext(), imgAlumno, mAlumnoActual.getNombre() + ".jpg").execute(mAlumnoActual.getImagen());
        else
            imgAlumno.setImageResource(R.drawable.default_alumno_image);
    }

    @Override
    public void onFabPress() {
        if (!puedeEscribirEnAlmacenamientoExterno())
            solicitarPermisoEscrituraAlmacenamientoExterno();
        else
            new ElegirFotoDialog().show(getActivity().getSupportFragmentManager(), "Elegir foto");
    }

    @Override
    public void onItemClick(int which) {
        if (which == 0)
            seleccionarFoto("foto.jpg");
        else
            capturarFoto("foto.jpg");
    }

    //Foto
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == RP_ALMACEN_EXTERNO) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                new ElegirFotoDialog().show(getActivity().getSupportFragmentManager(), "Elegir foto");
            } else {
                // Comprobamos si el usuario ha marcado No volver a preguntar.
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // Aún tenemos esperanza. Informamos.
                    Toast.makeText(getContext(),
                            "No se pudo realizar esa acción", Toast.LENGTH_LONG)
                            .show();
                } else {
                    // El usuario ha indicado que No se le vuelva a preguntar.
                    Toast.makeText(getContext(),
                            "Acción no disponible", Toast.LENGTH_LONG)
                            .show();
                }
            }
        }
    }


    private boolean tienePermiso(String permissionName) {
        return ContextCompat.checkSelfPermission(getContext(), permissionName) ==
                PackageManager.PERMISSION_GRANTED;
    }

    private boolean puedeEscribirEnAlmacenamientoExterno() {
        return tienePermiso(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private void solicitarPermisoEscrituraAlmacenamientoExterno() {
        // Comprobamos si hay que mostrar un diálogo informativo.
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            mostrarDialogoInformativoPermiso();
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    RP_ALMACEN_EXTERNO);
        }
    }

    private void mostrarDialogoInformativoPermiso() {
        new AlertDialog.Builder(getContext())
                .setMessage("Se necesita permiso para realizar esa acción")
                .setTitle("Permiso requerido")
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        RP_ALMACEN_EXTERNO);
                            }
                        })
                .show();
    }

    public void seleccionarFoto(String nombreArchivoPrivado) {
        // Se guarda el nombre para uso posterior.
        sNombreArchivo = nombreArchivoPrivado;
        // Se seleccionará un imagen de la galería.
        // (el segundo parámetro es el Data, que corresponde a la Uri de la galería.)
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.setType("image/*");
        startActivityForResult(i, RC_SELECCIONAR_FOTO);
    }

    public void capturarFoto(String nombreArchivoPrivado) {
        // Se guarda el nombre para uso posterior.
        sNombreArchivo = nombreArchivoPrivado;
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Si hay alguna actividad que sepa realizar la acción.
        if (i.resolveActivity(getActivity().getPackageManager()) != null) {
            // Se crea el archivo para la foto en el directorio público (true).
            // Se obtiene la fecha y hora actual.
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(
                    new Date());
            String nombre = "IMG_" + timestamp + "_" + ".jpg";
            File fotoFile = mostrarFoto.crearArchivoFoto(nombre, true);
            if (fotoFile != null) {
                sPathFotoOriginal = fotoFile.getAbsolutePath();
                i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(fotoFile));
                startActivityForResult(i, RC_CAPTURAR_FOTO);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == getActivity().RESULT_OK) {
            switch (requestCode) {
                case RC_CAPTURAR_FOTO:
                    // Se agrega la foto a la Galería
                    mostrarFoto.agregarFotoAGaleria(sPathFotoOriginal);
                    // Se escala la foto, se almacena en archivo propio y se muestra en ImageView.
                    cargarImagenEscalada(sPathFotoOriginal);
                    break;
                case RC_SELECCIONAR_FOTO:
                    // Se obtiene el path real a partir de la uri retornada por la galería.
                    Uri uriGaleria = intent.getData();
                    sPathFotoOriginal = mostrarFoto.getRealPath(uriGaleria);
                    // Se escala la foto, se almacena en archivo propio y se muestra en ImageView.
                    if (!TextUtils.isEmpty(sPathFotoOriginal)) {
                        cargarImagenEscalada(sPathFotoOriginal);
                    }
                    break;
            }
        }
    }

    // Escala y muestra la imagen en el visor.
    private void cargarImagenEscalada(String pathFoto) {
        // Se utiliza una tarea asíncrona, para escalar, guardar en archivo propio y mostrar
        // la foto en el ImageView.
        mostrarFoto.execute(pathFoto);
    }

}
