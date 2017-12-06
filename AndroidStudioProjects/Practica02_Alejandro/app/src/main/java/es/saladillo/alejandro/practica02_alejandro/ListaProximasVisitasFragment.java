package es.saladillo.alejandro.practica02_alejandro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.saladillo.alejandro.practica02_alejandro.adapters.AdaptadorListaProximasVisitas;
import es.saladillo.alejandro.practica02_alejandro.bd.DAO;

/**
 * Created by Alejandro on 27/02/2017.
 */

public class ListaProximasVisitasFragment extends android.support.v4.app.Fragment {

    @BindView(R.id.lstVisitas)
    ListView lstVisitas;

    private static AdaptadorListaProximasVisitas adaptadorListaProximasVisitas;
    private static DAO mDao;

    public ListaProximasVisitasFragment() {
        super();
    }

    public static ListaProximasVisitasFragment newInstance() {
        return new ListaProximasVisitasFragment();
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
        adaptadorListaProximasVisitas = new AdaptadorListaProximasVisitas(getContext(), mDao.selectProximasVisitas());
        lstVisitas.setAdapter(adaptadorListaProximasVisitas);

        return view;
    }

    public static void actualizar() {
        adaptadorListaProximasVisitas.actualizar(mDao.selectProximasVisitas());
    }
}
