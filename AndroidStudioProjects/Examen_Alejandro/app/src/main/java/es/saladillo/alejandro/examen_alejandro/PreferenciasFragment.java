package es.saladillo.alejandro.examen_alejandro;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by Alejandro on 24/01/2017.
 */

public class PreferenciasFragment extends PreferenceFragmentCompat {

    public static PreferenciasFragment newInstance() {
        return new PreferenciasFragment();
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String key) {
        // Se construye el fragmento de preferencias a partir de la
        // especificación XML de preferencias.
        //this.addPreferencesFromResource(R.xml.preferencias);
        setPreferencesFromResource(R.xml.preferencias, key);
    }
}
