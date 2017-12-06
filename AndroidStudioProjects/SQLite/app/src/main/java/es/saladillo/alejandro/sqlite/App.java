package es.saladillo.alejandro.sqlite;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Alejandro on 03/02/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
