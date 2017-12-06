package es.saladillo.alejandro.selecciondirectadialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Alejandro on 10/01/2017.
 */

public class SeleccionSimpleDialog extends DialogFragment {

    private SeleccionSimpleListener mListener;
    private int mIndiceSeleccionado = 0;

    public interface SeleccionSimpleListener {
        void onAceptar(int which);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        b.setTitle("Equipos favoritos");
        b.setSingleChoiceItems(R.array.equipos, mIndiceSeleccionado,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mIndiceSeleccionado = which;
            }
        });
        b.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                mListener.onAceptar(mIndiceSeleccionado);
            }
        });

        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (SeleccionSimpleListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar SeleccionSimpleListener");
        }
    }
}
