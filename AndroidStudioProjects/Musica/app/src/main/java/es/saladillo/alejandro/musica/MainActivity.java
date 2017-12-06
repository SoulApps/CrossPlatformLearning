package es.saladillo.alejandro.musica;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final float VELOCIDAD_NORMAL = 1f;
    private static final int PRIORIDAD_MAXIMA = 1;
    private static final float VOLUMEN_MAX = 1f;
    private static final int SIN_BUCLE = 0;
    private static final int CALIDAD_NORMAL = 0;
    private static final int PRIORIDAD_NORMAL = 1;
    private static final int MAX_STREAMS = 8;

    private SoundPool mReproductor;
    private int mSonido;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
        configSonidos();
    }

    private void initVistas() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mReproductor.play(mSonido, VOLUMEN_MAX, VOLUMEN_MAX, PRIORIDAD_MAXIMA,
                        SIN_BUCLE, VELOCIDAD_NORMAL);
            }
        });
    }

    private void crearSoundPool() {
        // En API 21+ se usa el patrón Builder.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            mReproductor = new SoundPool.Builder()
                    .setMaxStreams(MAX_STREAMS)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            mReproductor = new SoundPool(MAX_STREAMS, AudioManager.STREAM_NOTIFICATION,
                    CALIDAD_NORMAL);
        }
    }

    // Configura el mReproductor de sonidos.
    private void configSonidos() {
        // Se crea el objeto SoundPool con un límite de 8 sonidos simultáneos y
        // calidad estándar.
        crearSoundPool();
        // Se cargan los ficheros de sonido (recibe el contexto, el recurso y la
        // prioridad estándar).
        mSonido = mReproductor.load(this, R.raw.normal_hitclap2, PRIORIDAD_NORMAL);
        // Cuando se termine de cargar el sonido, se activa el botón
        // correspondiente.
        mReproductor.setOnLoadCompleteListener(new OnLoadCompleteListener() {

            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                // Activo el botón correspondiente al sonido.
                if (sampleId == mSonido) {
                    button.setEnabled(true);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // Se liberan los recursos del mReproductor.
        if (mReproductor != null) {
            mReproductor.release();
            mReproductor = null;
        }
        super.onDestroy();
    }
}
