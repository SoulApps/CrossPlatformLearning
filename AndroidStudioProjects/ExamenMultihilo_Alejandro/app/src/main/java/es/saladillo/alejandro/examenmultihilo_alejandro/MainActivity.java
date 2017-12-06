package es.saladillo.alejandro.examenmultihilo_alejandro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;
import es.saladillo.alejandro.examenmultihilo_alejandro.events.ErrorEvent;
import es.saladillo.alejandro.examenmultihilo_alejandro.events.PeticionService;
import es.saladillo.alejandro.examenmultihilo_alejandro.events.ResultadoEvent;

public class MainActivity extends AppCompatActivity {

    public static final String ARG_MONEDA = "moneda";
    public static final String ARG_CANTIDAD = "cantidad";
    public static final String ARG_DIVISAS = "divisas";
    public static final String LIBRA = "GBP";
    public static final String EURO = "EUR";
    public static final String DOLAR = "USD";
    public static final String YEN = "JPY";

    private String moneda;

    @BindView(R.id.cbMoneda)
    Spinner cbMoneda;
    @BindView(R.id.txtCantidad)
    EditText txtCantidad;
    @BindView(R.id.lblResultado)
    TextView lblResultado;
    @BindView(R.id.btnCalcular)
    Button btnCalcular;
    @BindView(R.id.imgMoneda)
    ImageView imgMoneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCalcular)
    public void calcular() {
        lblResultado.setText("");
        Intent intent = new Intent(MainActivity.this, PeticionService.class);
        intent.putExtra(ARG_MONEDA, moneda);
        intent.putExtra(ARG_CANTIDAD, Float.parseFloat(txtCantidad.getText().toString()));
        intent.putExtra(ARG_DIVISAS, "EUR,GBP,USD,JPY");
        startService(intent);
    }

    @OnTextChanged(R.id.txtCantidad)
    public void textoCambiado() {
        if (txtCantidad.getText().toString().equals(""))
            txtCantidad.setText("0");
    }

    @OnItemSelected(R.id.cbMoneda)
    public void monedaCambiada() {
        String valor = (String) cbMoneda.getSelectedItem();
        lblResultado.setText("");
        if (valor.equals("Euro")) {
            imgMoneda.setImageResource(R.drawable.euro);
            moneda = EURO;
        } else if (valor.equals("Libra")) {
            imgMoneda.setImageResource(R.drawable.libra);
            moneda = LIBRA;
        } else if (valor.equals("Dólar")) {
            imgMoneda.setImageResource(R.drawable.dolar);
            moneda = DOLAR;
        } else if (valor.equals("Yen")) {
            imgMoneda.setImageResource(R.drawable.yen);
            moneda = YEN;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAlumnoReceive(ResultadoEvent event) {
        lblResultado.setText(event.getResultado().toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAlumnoReceive(ErrorEvent event) {
        Toast.makeText(this, event.getError(), Toast.LENGTH_SHORT).show();
        lblResultado.setText(event.getError());
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
