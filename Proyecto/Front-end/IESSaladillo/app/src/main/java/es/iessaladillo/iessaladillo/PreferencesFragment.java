package es.iessaladillo.iessaladillo;

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
        setPreferencesFromResource(R.xml.configuracion_tic, key);
    }
}
