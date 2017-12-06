package es.saladillo.alejandro.downloadmanager;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private long mIdDescarga;
    private DownloadManager mGestor;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVistas();
    }

    private void initVistas() {
        mGestor = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadManager.Request solicitud = new DownloadManager.Request(Uri.parse("https://www.youtube.com/audiolibrary_download?vid=fafb35a907cd6e73"));
                solicitud.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                solicitud.setAllowedOverRoaming(false);
                solicitud.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Les Toreadors.mp3");
                // solicitud.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Les Toreadors.mp3");
                solicitud.setTitle("Les Toreadors");
                solicitud.setDescription("Les Toreadors from Carmen (by Bizet)");
                solicitud.allowScanningByMediaScanner();
                solicitud.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                // Se encola la solicitud.
                mIdDescarga = mGestor.enqueue(solicitud);
            }
        });
    }
}
