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

public class SeleccionMultipleDialog extends DialogFragment {

    private SeleccionMultipleListener mListener;
    private boolean mChecked[];

    public interface SeleccionMultipleListener {
        void onAceptar(boolean[] checked);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());

        mChecked = new boolean[]{true, false, false};

        b.setTitle("Equipos favoritos");
        b.setMultiChoiceItems(R.array.equipos, mChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                mChecked[which] = isChecked;
            }
        });
        b.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                mListener.onAceptar(mChecked);
            }
        });

        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (SeleccionMultipleListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar SeleccionMultipleListener");
        }
    }
}
