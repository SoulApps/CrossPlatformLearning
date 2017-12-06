package es.saladillo.alejandro.examen_alejandro;

import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import es.saladillo.alejandro.examen_alejandro.adapters.AdaptadorListView;
import es.saladillo.alejandro.examen_alejandro.bd.DAO;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListaFragment extends Fragment {

    private ListView lstLibros;
    private TextView lblSinopsis;
    private RelativeLayout rlPanel;
    private BottomSheetBehavior<RelativeLayout> bsb;

    private SoundPool mReproductor;
    private int mSonido;
    private boolean sonido;
    private AdaptadorListView mAdaptador;
    private DAO mDao;


    private static final float VELOCIDAD_NORMAL = 1f;
    private static final int PRIORIDAD_MAXIMA = 1;
    private static final float VOLUMEN_MAX = 1f;
    private static final int SIN_BUCLE = 0;
    private static final int CALIDAD_NORMAL = 0;
    private static final int PRIORIDAD_NORMAL = 1;
    private static final int MAX_STREAMS = 8;

    public ListaFragment() {
    }

    public static ListaFragment newInstance() {
        return  new ListaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initVistas(getView());
    }

    private void initVistas(View view) {
        lstLibros = (ListView) view.findViewById(R.id.lstLibros);
        rlPanel = (RelativeLayout) view.findViewById(R.id.rlPanel);
        lblSinopsis = (TextView) view.findViewById(R.id.lblSinopsis);
        if (rlPanel != null)
            bsb = BottomSheetBehavior.from(rlPanel);

        mDao = DAO.getInstance(getContext());
        mAdaptador = new AdaptadorListView(getContext());
        lstLibros.setAdapter(mAdaptador);
        cargarLibros();
        configSonidos();

        lstLibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*if (bsb.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bsb.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else if (bsb.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    lblSinopsis.setText(mAdaptador.getItem(i).getSinopsis());
                    bsb.setState(BottomSheetBehavior.STATE_EXPANDED);
                }*/
                if (sonido) {
                    mReproductor.play(mSonido, VOLUMEN_MAX, VOLUMEN_MAX, PRIORIDAD_MAXIMA,
                            SIN_BUCLE, VELOCIDAD_NORMAL);
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(getContext());
        sonido = preferencias.getBoolean("sonido", true);
    }

    public void cargarLibros() {
       mAdaptador.swapData(mDao.getAllLibros());
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
        mSonido = mReproductor.load(getContext(), R.raw.normal_hitclap2, PRIORIDAD_NORMAL);
        // Cuando se termine de cargar el sonido, se activa el botón
        // correspondiente.
        mReproductor.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {

            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                //cargarLibros();
            }
        });
    }

    @Override
    public void onDestroy() {
        // Se liberan los recursos del mReproductor.
        if (mReproductor != null) {
            mReproductor.release();
            mReproductor = null;
        }
        super.onDestroy();
    }
}
