package es.saladillo.alejandro.viewpager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String PAR_NUM_PAGINA = "pag";
    private ViewPager viewPager;
    private FloatingActionButton fab;
    private TabLayout tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initVistas();
    }

    private void initVistas() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        final Adaptador adaptador = new Adaptador(getSupportFragmentManager());
        adaptador.add(PaginaFragmentUno.newInstance());
        adaptador.add(PaginaFragmentDos.newInstance());
        adaptador.add(PaginaFragmentTres.newInstance());

        if (viewPager != null) {
            viewPager.setAdapter(adaptador);

            tab = (TabLayout) findViewById(R.id.tab);
            tab.setupWithViewPager(viewPager);
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OnFabPressedListener) adaptador.getItem(viewPager.getCurrentItem())).onFabPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
