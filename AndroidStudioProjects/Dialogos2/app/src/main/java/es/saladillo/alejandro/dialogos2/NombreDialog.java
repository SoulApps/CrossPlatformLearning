package es.saladillo.alejandro.dialogos2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;

/**
 * Created by Alejandro on 13/01/2017.
 */

public class NombreDialog extends DialogFragment {

    private NombreDialogListener mListener;

    private EditText txtIntroNombre;

    public interface NombreDialogListener {
        void onAceptar(String nombre);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(this.getActivity());

        b.setTitle("Nombre");
        txtIntroNombre = (EditText) LayoutInflater.from(getActivity()).inflate(R.layout.intro_nombre, null);
        b.setView(txtIntroNombre);

        b.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                mListener.onAceptar(txtIntroNombre.getText().toString());
            }
        });

        return b.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (NombreDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar NombreDialogListener");
        }
    }
}
