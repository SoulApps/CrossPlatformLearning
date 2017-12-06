package es.saladillo.alejandro.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Alejandro on 27/01/2017.
 */
public class PaginaFragmentTres extends android.support.v4.app.Fragment implements OnFabPressedListener {

    public static PaginaFragmentTres newInstance() {
        return new PaginaFragmentTres();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pagina_fragment_3, container, false);
    }

    @Override
    public void onFabPressed() {
        Toast.makeText(getActivity(), "Soy el fragmento 3", Toast.LENGTH_SHORT).show();
    }
}
