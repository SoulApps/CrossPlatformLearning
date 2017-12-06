package es.saladillo.alejandro.practica02_alejandro.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Alejandro on 26/02/2017.
 */

public class AcercaDeDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        b.setTitle("Acerca de");
        b.setMessage("Hecho por Alejandro Sánchez Galvín");
        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Se cierra el diálogo
                AcercaDeDialog.this.dismiss();
            }
        });
        return b.create();
    }
}
