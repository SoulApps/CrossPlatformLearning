package es.saladillo.alejandro.practica02_alejandro.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import es.saladillo.alejandro.practica02_alejandro.R;

/**
 * Created by Alejandro on 28/02/2017.
 */

public class ElegirFotoDialog extends DialogFragment {

    private ElegirFotoListener mListener;

    public interface ElegirFotoListener {
        void onItemClick(int which);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());
        b.setTitle("Elegir foto usando");
        b.setItems(R.array.foto, new DialogInterface.OnClickListener() {
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
            mListener = (ElegirFotoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar ElegirFotoListener");
        }
    }
}
