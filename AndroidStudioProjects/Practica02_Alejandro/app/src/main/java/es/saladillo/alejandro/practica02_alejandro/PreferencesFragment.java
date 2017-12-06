package es.saladillo.alejandro.practica02_alejandro;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by Alejandro on 24/01/2017.
 */

public class PreferencesFragment extends PreferenceFragmentCompat {

    public static PreferencesFragment newInstance() {
        return new PreferencesFragment();
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String key) {
        // Se construye el fragmento de preferencias a partir de la
        // especificación XML de preferencias.
        //this.addPreferencesFromResource(R.xml.preferencias);
        setPreferencesFromResource(R.xml.preferences, key);
    }
}
