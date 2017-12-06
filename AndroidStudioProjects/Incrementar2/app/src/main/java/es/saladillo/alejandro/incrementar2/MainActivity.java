package es.saladillo.alejandro.incrementar2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private Estado estado;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        estado = (Estado) getLastCustomNonConfigurationInstance();
        if (estado == null)
            estado = new Estado();
        initVistas();
    }

    private void initVistas() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        textView.setText(String.valueOf(estado.numero));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(++estado.numero));
            }
        });
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return estado;
    }



    private class Estado {
        int numero;

        public Estado() {
            numero = 0;
        }
    }
}
