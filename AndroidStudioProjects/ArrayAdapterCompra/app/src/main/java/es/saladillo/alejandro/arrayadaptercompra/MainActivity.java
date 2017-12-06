package es.saladillo.alejandro.arrayadaptercompra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lst;
    private Button btnAgregar;
    private EditText txtElemento;
    private Adaptador adaptador;
    private ArrayList<String> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    public void initVistas() {
        lst = (ListView) findViewById(R.id.lstCompra);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        txtElemento = (EditText) findViewById(R.id.txtElemento);

        datos = new ArrayList<>();

        lst.setEmptyView(findViewById(R.id.lblVacio));
        adaptador = new Adaptador(this, datos);
        lst.setAdapter(adaptador);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anhadir();
            }
        });

        txtElemento.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction (TextView v,int actionId, KeyEvent event){
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    anhadir();
                    handled = true;
                }
                return handled;
            }
        });

        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ((Adaptador) lst.getAdapter()).remove((String) lst.getItemAtPosition(position));
                return true;
            }
        });

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView < ? > lst, View v,int position, long id){
                Toast.makeText(lst.getContext(), "Has sleccionado " + lst.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void anhadir() {
        if (!txtElemento.getText().toString().equals("")) {
            ((Adaptador) lst.getAdapter()).add(txtElemento.getText().toString());
            lst.smoothScrollToPosition(adaptador.getCount());
        }
    }
}
