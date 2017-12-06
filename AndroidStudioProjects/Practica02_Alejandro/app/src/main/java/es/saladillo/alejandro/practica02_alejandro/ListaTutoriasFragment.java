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
import es.saladillo.alejandro.practica02_alejandro.adapters.AdaptadorListaTutorias;
import es.saladillo.alejandro.practica02_alejandro.bd.DAO;
import es.saladillo.alejandro.practica02_alejandro.models.Alumno;

/**
 * Created by Alejandro on 26/02/2017.
 */

public class ListaTutoriasFragment extends android.support.v4.app.Fragment implements OnFabPressListener {

    @BindView(R.id.lstVisitas)
    ListView lstVisitas;

    private static Alumno mAlumno;
    private static DAO mDao;

    private static AdaptadorListaTutorias adaptadorListaTutorias;

    public ListaTutoriasFragment() {
        super();
    }

    public static ListaTutoriasFragment newInstance(Alumno alumno) {
        mAlumno = alumno;
        return new ListaTutoriasFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMenuVisibility(true);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_visitas, container, false);

        ButterKnife.bind(this, view);
        mDao = DAO.getInstance(getContext());
        adaptadorListaTutorias = new AdaptadorListaTutorias(getContext(), mDao.selectVisitas(mAlumno));
        lstVisitas.setAdapter(adaptadorListaTutorias);
        lstVisitas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DatosVisitaActivity.class);
                intent.putExtra("alumno", mAlumno);
                intent.putExtra("visita", adaptadorListaTutorias.getItem(i));
                startActivity(intent);
            }
        });

        return view;
    }

    public static void actualizar() {
        adaptadorListaTutorias.actualizar(mDao.selectVisitas(mAlumno));
    }

    @Override
    public void onFabPress() {
        Intent intent = new Intent(getActivity(), DatosVisitaActivity.class);
        intent.putExtra("alumno", mAlumno);
        startActivity(intent);
    }
}
