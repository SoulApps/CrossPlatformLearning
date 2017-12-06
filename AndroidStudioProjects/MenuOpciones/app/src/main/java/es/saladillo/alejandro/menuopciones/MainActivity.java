package es.saladillo.alejandro.menuopciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuUno:
                Toast.makeText(this, "Has pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuDos:
                Toast.makeText(this, "Has pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnuTres:
                Toast.makeText(this, "Has pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
