package es.saladillo.alejandro.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Alejandro on 27/01/2017.
 */
public class PaginaFragmentUno extends Fragment implements OnFabPressedListener {
    public static PaginaFragmentUno newInstance() {
        return new PaginaFragmentUno();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pagina_fragment_1, container, false);
    }

    @Override
    public void onFabPressed() {
        Toast.makeText(getActivity(), "Soy el fragmento 1", Toast.LENGTH_SHORT).show();
    }
}
