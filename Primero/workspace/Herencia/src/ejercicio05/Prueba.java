package ejercicio05;

/**
 * Created by Alejandro on 04/02/2016.
 */
class Prueba {
    protected String nombre;
    protected int id;

    public String getIdent() {
        return nombre;
    }

    /*public int getIdent() {
        return id;
    }*/
}

//Porque hay dos métodos con el mismo nombre y mismos argumentos y eso no se puede dar aunque los tipos sean diferentes
// porque al llamarlos no se diferencian (p.getIdent()).
