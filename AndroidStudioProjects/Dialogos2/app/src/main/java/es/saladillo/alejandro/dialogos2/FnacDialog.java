package es.saladillo.alejandro.dialogos2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Alejandro on 13/01/2017.
 */

public class FnacDialog extends DialogFragment {

    private DatePickerDialog.OnDateSetListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        return new DatePickerDialog(this.getActivity(),
                mListener, calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (DatePickerDialog.OnDateSetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar FnacDialogListener");
        }
    }
}
