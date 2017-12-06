package ejercicio02;

import util.Funciones;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Funciones.abrirConexion();
        Funciones.insert("INSERT INTO ofertaeducativa VALUES('FPB', 'FP Básica Informática y comunicaciones', ' La formación profesional básica de informática y comunicaciones tiene una duración de 2000 horas repartidas entre dos cursos académicos incluyendo 240 horas de Formación en centros de trabajo (FCT) en empresas del Sector', 'FPB', null);");
        Funciones.cerrarConexion();
    }
}
