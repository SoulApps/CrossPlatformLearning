package es.saladillo.alejandro.selecciondirectadialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Alejandro on 10/01/2017.
 */

public class SeleccionDirectaDialog extends DialogFragment {

    private SeleccionDirectaListener mListener;

    public interface SeleccionDirectaListener {
        void onItemClick(int which);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        b.setTitle("Equipos favoritos");
        b.setItems(R.array.equipos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onItemClick(which);
            }
        });

        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (SeleccionDirectaListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar SeleccionDirectaListener");
        }
    }
}
