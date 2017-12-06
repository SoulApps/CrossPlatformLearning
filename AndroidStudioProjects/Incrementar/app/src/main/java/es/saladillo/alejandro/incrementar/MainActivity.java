package es.saladillo.alejandro.incrementar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String STATE_CONTADOR = "STATE_CONTADOR";
    private final int DEFAULT_CONTADOR = 0;
    private TextView textView;
    private Button button;
    private int numero;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
            numero = savedInstanceState.getInt(STATE_CONTADOR, DEFAULT_CONTADOR);
        initVistas();
    }

    private void initVistas() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        textView.setText(String.valueOf(numero));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(++numero));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_CONTADOR, numero);
    }
}
