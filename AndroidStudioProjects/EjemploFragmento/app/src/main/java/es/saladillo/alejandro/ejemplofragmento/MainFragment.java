package es.saladillo.alejandro.ejemplofragmento;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public static final String EXTRA_NOMBRE = "nombre";
    private Button btnSaludar, btnInsultar;
    private View vista;
    EditText txtNombre;
    private Listener listener;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (Listener) activity;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public interface Listener {
        void insultar(String nombre, Context context);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initVistas();
    }

    private void initVistas() {
        vista = getView();

        txtNombre = (EditText) vista.findViewById(R.id.txtNombre);
        btnSaludar = (Button) vista.findViewById(R.id.btnSaludar);
        btnInsultar = (Button) vista.findViewById(R.id.btnInsultar);
        Bundle params = getArguments();
        txtNombre.setText(params.getString(EXTRA_NOMBRE));

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saludar(txtNombre.getText().toString(), MainFragment.this.getContext());
            }
        });

        btnInsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((MainActivity) getActivity()).insultar(txtNombre.getText().toString(), MainFragment.this.getContext());
                listener.insultar(txtNombre.getText().toString(), MainFragment.this.getContext());
            }
        });
    }

    public static MainFragment newInstance(String nombre) {
        MainFragment frg = new MainFragment();
        Bundle params = new Bundle();
        params.putString(EXTRA_NOMBRE, nombre);
        frg.setArguments(params);

        return frg;
    }


    public static void saludar(String nombre, Context context) {
        Toast.makeText(context, "Hola " + nombre, Toast.LENGTH_LONG).show();
    }
}
