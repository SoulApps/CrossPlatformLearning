package ejercicio23;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Planta implements Cloneable, Plantable {
    private static int plantasCreadas = 0;

    private String especie;
    private boolean esPerenne;
    private Tipo tipoPlanta;
    private float longitud;


    public Planta(String especie, boolean esPerenne, Tipo tipoPlanta, float longitud) {
        this.especie = especie;
        this.esPerenne = esPerenne;
        this.tipoPlanta = tipoPlanta;
        this.longitud = longitud;
        plantasCreadas++;
    }


    public static int getPlantasCreadas() {
        return plantasCreadas;
    }


    public void nutrir(float litros) {
        longitud += litros * 2;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isEsPerenne() {
        return esPerenne;
    }

    public void setEsPerenne(boolean esPerenne) {
        this.esPerenne = esPerenne;
    }

    public Tipo getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(Tipo tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }



    public Object clone() {
        Planta p;

        try {
            p = (Planta) super.clone();
        } catch (CloneNotSupportedException e) {
            p = null;
        }

        return p;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Planta)
            if (especie.equals(((Planta) o).especie) && esPerenne == esPerenne && tipoPlanta.equals(((Planta) o).tipoPlanta))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("[Especie: %s] [Hoja: %s] [Tamaño: %s] [Longitud: %f]", especie, esPerenne?"Perenne":"Caduca", tipoPlanta, longitud);
    }
}
