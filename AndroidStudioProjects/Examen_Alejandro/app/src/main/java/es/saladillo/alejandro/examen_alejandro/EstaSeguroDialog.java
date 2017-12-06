package es.saladillo.alejandro.examen_alejandro;

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

public class EstaSeguroDialog extends DialogFragment {

    private EstaSeguroListener mListener;

    public interface EstaSeguroListener {
        void onSi();
        void onNo();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        b.setTitle("Equipos favoritos");
        b.setMessage("¿Está seguro?");
        b.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onSi();
            }
        });

        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onNo();
            }
        });

        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (EstaSeguroListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar EstaSeguroListener");
        }
    }
}
