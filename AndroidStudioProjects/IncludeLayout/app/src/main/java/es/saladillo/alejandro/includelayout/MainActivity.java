package es.saladillo.alejandro.includelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View dabeef;
    private View omar;

    private TextView nombreOmar;
    private TextView nombreDabeef;

    private ImageView imgOmar;
    private ImageView imgDabeef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        dabeef = findViewById(R.id.dabeef);
        omar = findViewById(R.id.omar);

        nombreDabeef = (TextView) dabeef.findViewById(R.id.txtNombre);
        nombreOmar = (TextView) omar.findViewById(R.id.txtNombre);

        imgDabeef = (ImageView) dabeef.findViewById(R.id.imgPersona);
        imgOmar = (ImageView) omar.findViewById(R.id.imgPersona);

        nombreDabeef.setText("Dabeef");
        nombreOmar.setText("Omar");

        imgDabeef.setImageResource(R.drawable.dabeef);
        imgOmar.setImageResource(R.drawable.omar);
    }
}
