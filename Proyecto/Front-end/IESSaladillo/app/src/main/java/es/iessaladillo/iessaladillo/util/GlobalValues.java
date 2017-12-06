package es.iessaladillo.iessaladillo.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

import es.iessaladillo.iessaladillo.models.Profesor;

/**
 * Created by Alejandro on 18/04/2017.
 */

public class GlobalValues {
    public static final int RC_SIGN_IN = 1;

    public static final int RC_SOLUCIONAR_INCIDENCIA = 2;
    public static final int RC_ACTUALIZAR_INVENTARIO = 3;
    public static final int RC_MATERIAL = 4;

    public static final String KEY_FAB_VISIBLE = "key_fab_visible";
    public static final String ARG_DIA = "arg_dia";

    public static final String ARG_INCIDENCIA = "arg_incidencia";
    public static final String ARG_INVENTARIO = "arg_inventario";
    public static final String ARG_HARDWARE = "arg_hardware";
    public static final String ARG_HARDWARE_VUELTA = "arg_material_vuelta";

    public static final String ID_DIA_RESERVA_FRAGMENT = "id_dia_reserva_fragment";
    public static final String ID_MATERIALES_FRAGMENT = "id_materiales_fragment";

    public static final short MAX_LONGITUD_COD_BARRAS = 30;
    public static final short MAX_LONGITUD_DESCRIPCION = 500;

    public static final SimpleDateFormat FORMATO_FECHA_INCIDENCIA = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());

    public static Profesor profesor;
}
