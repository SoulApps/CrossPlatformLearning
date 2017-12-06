package com.example.alejandro.pr_001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.button5)
    Button button5;

    @OnClick(R.id.button5)
    public void click() {
        mostrarMensajeToast();
    }


    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
        ButterKnife.bind(this);
    }

    private void initVistas() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button1.setOnClickListener(this);

        button2.setOnClickListener(new GestorOnClick());


        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mostrarMensajeToast();
            }
        });

        button4.setOnClickListener(v -> mostrarMensajeToast());

    }

    private class GestorOnClick implements View.OnClickListener {
        public void onClick(View v) {
            mostrarMensajeToast();
        }
    }

    private void mostrarMensajeToast() {
        Toast.makeText(MainActivity.this, R.string.mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        mostrarMensajeToast();
    }
}
