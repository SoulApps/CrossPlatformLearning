package es.saladillo.alejandro.okhttp;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Alejandro on 07/02/2017.
 */

public class App extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
