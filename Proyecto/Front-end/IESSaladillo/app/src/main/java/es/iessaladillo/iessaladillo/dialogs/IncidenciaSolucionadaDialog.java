package es.iessaladillo.iessaladillo.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Alejandro on 15/05/2017.
 */

public class IncidenciaSolucionadaDialog extends DialogFragment {

    private IncidenciaSolucionadaListener mListener;

    public interface IncidenciaSolucionadaListener {
        void onIncidenciaSolucionada();
        void onIncidenciaNoSolucionada();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        b.setTitle("¿Se ha solucionado la incidencia?");
        b.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onIncidenciaSolucionada();
            }
        });

        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onIncidenciaNoSolucionada();
            }
        });

        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (IncidenciaSolucionadaListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar IncidenciaSolucionadaListener");
        }
    }
}
