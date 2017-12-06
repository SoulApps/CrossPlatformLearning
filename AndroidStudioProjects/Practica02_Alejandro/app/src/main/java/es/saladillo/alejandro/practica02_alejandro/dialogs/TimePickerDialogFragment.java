package es.saladillo.alejandro.practica02_alejandro.dialogs;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Alejandro on 27/02/2017.
 */

public class TimePickerDialogFragment extends DialogFragment {

    // Variables.
    private TimePickerDialog.OnTimeSetListener listener;

    // Al crear el diálogo. Retorna el diálogo configurado.
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        return new TimePickerDialog(this.getActivity(),
                listener, calendario.get(Calendar.HOUR),
                calendario.get(Calendar.MINUTE), true);
    }

    // Al enlazar el fragmento con la actividad.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Establece la actividad como listener de los eventos del diálogo.
        try {
            listener = (TimePickerDialog.OnTimeSetListener) context;
        } catch (ClassCastException e) {
            // La actividad no implementa la interfaz, se lanza excepción.
            throw new ClassCastException(context.toString()
                    + " debe implementar TimePickerDialogFragment.OnTimeSetListener");
        }
    }

}
