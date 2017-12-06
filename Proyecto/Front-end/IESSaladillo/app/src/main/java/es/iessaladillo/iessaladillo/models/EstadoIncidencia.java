package es.iessaladillo.iessaladillo.models;

import android.support.annotation.ColorRes;

import es.iessaladillo.iessaladillo.R;

/**
 * Created by Alejandro on 10/05/2017.
 */

public enum EstadoIncidencia {
    SOLUCIONADO(R.color.colorSolucionado), REVISADO(R.color.colorRevisado), NUEVO(R.color.colorNuevo);

    private int color;

    EstadoIncidencia(@ColorRes int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
