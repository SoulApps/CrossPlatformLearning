package ejercicio07;

/**
 * Created by Alejandro on 14/01/2016.
 */
public class Dimensiones {
    private float x;
    private float y;
    private float z;

    Dimensiones() {
        x = 0;
        y = 0;
        z = 0;
    }
    Dimensiones(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Getters y setters
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }
    public void setZ(float z) {
        this.z = z;
    }

    //Métodos
    public float alturaMaximaParaApilar(float alturaMaxima) {
        return alturaMaxima < y?0:alturaMaxima - y; //Devuelve 0 si va a devolver un negativo.
    }

    public float sumarDimensionesX(Dimensiones dimensiones) {
        return x + dimensiones.x;
    }

    public float sumarDimensionesY(Dimensiones dimensiones) {
        return y + dimensiones.y;
    }

    public float sumarDimensionesZ(Dimensiones dimensiones) {
        return z + dimensiones.z;
    }

    public boolean esPosibleApilarPaquetes(Dimensiones dimensionesOtroPaquete, float alturaMaximaParaApilar) {
      return sumarDimensionesY(dimensionesOtroPaquete) <= alturaMaximaParaApilar;
    }

    public void voltearDimensionX() {
        float auxiliar;
        auxiliar = y;
        y = z;
        z = auxiliar;
    }

    public void voltearDimensionY() {
        float auxiliar;
        auxiliar = x;
        x = z;
        z = auxiliar;
    }

    public void voltearDimensionZ() {
        float auxiliar;
        auxiliar = x;
        x = y;
        y = auxiliar;
    }

    public String apilarPaquetes(Dimensiones dimesionesOtroPaquete, float alturaMaximaParaApilar) {
        int i, j;
        String resultado = "";

        //Volteo la caja actual cuando la i llegue a 1(x) y a 2(z)
        for (i = 0; i < 3; i++) {
            if (i == 1)
                voltearDimensionX();
            if (i == 2)
                voltearDimensionZ();

            //Volteo la otra caja cuando la i llegue a 1(x) y a 2(z)
            for (j = 0; j < 3; j++) {
                if (j == 1) {
                    dimesionesOtroPaquete.voltearDimensionX();
                }
                if (j == 2) {
                    dimesionesOtroPaquete.voltearDimensionZ();
                }

                //Compruebo que se pueden apilar los paquetes.
                if (esPosibleApilarPaquetes(dimesionesOtroPaquete, alturaMaximaParaApilar))
                    resultado += String.format("[Caja 1: %s] [Caja 2: %s]%n", this, dimesionesOtroPaquete);

            }
            //Vuelvo a la posición original.
            if (i == 1) {
                voltearDimensionX();
            }
            if (i == 2) {
                voltearDimensionZ();
            }
        }

        return resultado;
    }


    public String toString() {
        return String.format("Dimensiones; x = %.2f ; y = %.2f ; z = %.2f", getX(), getY(), getZ());
    }
}
