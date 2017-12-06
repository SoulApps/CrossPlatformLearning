package es.saladillo.alejandro.gestorfragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SaludoFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NOMBRE = "nombre";

    private String mNombre;

    public SaludoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SaludoFragment newInstance(String nombre) {
        SaludoFragment fragment = new SaludoFragment();
        Bundle args = new Bundle();
        args.putString(MainFragment.ARG_NOMBRE, nombre);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initVistas();
    }

    private void initVistas() {
        View vista = getView();
        TextView lblSaludo = (TextView) vista.findViewById(R.id.lblSaludo);
        Bundle extras;
        if ((extras = getArguments()) != null) {
            extras = getArguments();
            lblSaludo.setText(extras.getString(ARG_NOMBRE));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saludo, container, false);
    }


}
