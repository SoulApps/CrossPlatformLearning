package es.saladillo.alejandro.practica02_alejandro.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Alejandro on 27/02/2017.
 */

public class DatePickerDialogFragment extends DialogFragment {
    // Variables.
    private DatePickerDialog.OnDateSetListener mListener;

    // Al crear el diálogo. Retorna el diálogo configurado.
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        return new DatePickerDialog(this.getActivity(),
                mListener, calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH));
    }

    // Cuando se enlaza el fragmento con la actividad.

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Establece la actividad como listener de los eventos del diálogo.
        try {
            mListener = (DatePickerDialog.OnDateSetListener) context;
        } catch (ClassCastException e) {
            // La actividad no implementa la interfaz, se lanza excepción.
            throw new ClassCastException(context.toString()
                    + " debe implementar DatePickerDialog.OnDateSetListener");
        }
    }
}
