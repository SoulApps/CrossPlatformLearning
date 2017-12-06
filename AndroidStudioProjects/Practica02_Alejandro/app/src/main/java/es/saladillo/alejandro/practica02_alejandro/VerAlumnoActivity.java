package es.saladillo.alejandro.practica02_alejandro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.saladillo.alejandro.practica02_alejandro.adapters.AdaptadorViewPager;
import es.saladillo.alejandro.practica02_alejandro.dialogs.ElegirFotoDialog;
import es.saladillo.alejandro.practica02_alejandro.models.Alumno;

/**
 * Created by Alejandro on 26/02/2017.
 */

public class VerAlumnoActivity extends AppCompatActivity implements ElegirFotoDialog.ElegirFotoListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private FloatingActionButton fab;
    private TabLayout tab;
    private AdaptadorViewPager adaptadorViewPager;
    private Alumno mAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_alumno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            mAlumno = bundle.getParcelable("alumno");
        initVistas();
    }

    private void initVistas() {
        ButterKnife.bind(this);

        adaptadorViewPager = new AdaptadorViewPager(this.getSupportFragmentManager());
        adaptadorViewPager.add(DatosAlumnoFragment.newInstance(mAlumno));
        adaptadorViewPager.add(ListaTutoriasFragment.newInstance(mAlumno));

        if (viewPager != null) {
            viewPager.setAdapter(adaptadorViewPager);

            tab = (TabLayout) findViewById(R.id.tab);
            tab.setupWithViewPager(viewPager);

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    if (position == 0)
                        fab.setImageResource(R.drawable.ic_menu_camera);
                    else
                        fab.setImageResource(R.drawable.ic_add);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_menu_camera);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OnFabPressListener) adaptadorViewPager.getItem(viewPager.getCurrentItem())).onFabPress();
            }
        });
    }

    @Override
    public void onItemClick(int which) {
        ((DatosAlumnoFragment)  adaptadorViewPager.getItem(viewPager.getCurrentItem())).onItemClick(which);
    }
}
