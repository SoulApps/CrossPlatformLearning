package es.saladillo.alejandro.practica02_alejandro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.saladillo.alejandro.practica02_alejandro.adapters.AdaptadorListaAlumnos;
import es.saladillo.alejandro.practica02_alejandro.bd.DAO;

/**
 * Created by Alejandro on 25/02/2017.
 */

public class ListaAlumnosFragment extends android.support.v4.app.Fragment implements OnFabPressListener {

    @BindView(R.id.lstAlumnos)
    ListView lstAlumnos;

    private AdaptadorListaAlumnos adaptadorListaAlumnos;

    public ListaAlumnosFragment() {
        super();
    }

    public static ListaAlumnosFragment newInstance() {
        return new ListaAlumnosFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMenuVisibility(false);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_alumnos, container, false);
        ButterKnife.bind(this, view);
        adaptadorListaAlumnos = new AdaptadorListaAlumnos(getContext(), DAO.getInstance(getContext()).getAllAlumnos());
        lstAlumnos.setAdapter(adaptadorListaAlumnos);
        lstAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), VerAlumnoActivity.class);
                intent.putExtra("alumno", adaptadorListaAlumnos.getItem(i));
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onFabPress() {
        ((MainActivity) getActivity()).cargarFragmento(DatosAlumnoFragment.newInstance(), R.drawable.ic_menu_camera, R.id.datos_alumno, "Alumnos");
    }
}
