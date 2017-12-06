package es.iessaladillo.iessaladillo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import es.iessaladillo.iessaladillo.models.Hardware;
import es.iessaladillo.iessaladillo.models.Material;
import es.iessaladillo.iessaladillo.util.GlobalValues;

public class MaterialesActivity extends AppCompatActivity {

    private Fragment mFragment;
    private Hardware mHardware;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiales);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OnFabClickInterface) mFragment).onFabClick();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null)
            mHardware = getIntent().getParcelableExtra(GlobalValues.ARG_HARDWARE);

        //Compruebo que el fragmento ya exista.
        if (getSupportFragmentManager().findFragmentByTag(GlobalValues.ID_MATERIALES_FRAGMENT) == null) {
            mFragment = MaterialesFragment.newInstance(mHardware);
            getSupportFragmentManager()
                    .beginTransaction().add(R.id.flHueco, mFragment, GlobalValues.ID_MATERIALES_FRAGMENT)
                    .addToBackStack(null)
                    .commit();
        }
    }

    //Comunicación del fragmento con el diálogo para añadir un material.
    public void onMaterialAnhadido(Material material) {
        ((MaterialesFragment) mFragment).onMaterialAnhadido(material);
    }

    @Override
    public boolean onSupportNavigateUp() {
        mHardware = ((MaterialesFragment) mFragment).getHardware();
        finish();
        return true;
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(GlobalValues.ARG_HARDWARE_VUELTA, mHardware);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
