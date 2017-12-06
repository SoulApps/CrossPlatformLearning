package ejercicio06;

import teclado.Teclado;

/**
 * Created by Alejandro on 14/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        final String FIN = "fin";
        final int MODELOS = 5;
        boolean salir = false;
        int i = 0;
        String modelo = "";
        Vehiculo vehiculos[] = new Vehiculo[MODELOS];

        while (!salir && i < MODELOS) {
            modelo = Teclado.next("Introduce el modelo para el vehículo " + (i + 1));
            if (!modelo.toLowerCase().equals(FIN)) {
                vehiculos[i] = new Vehiculo(modelo);
                vehiculos[i].setPotencia(Teclado.nextDouble("¿Cuánta potencia tiene este vehículo?"));
                vehiculos[i].setcRuedas(Teclado.nextBoolean("¿Tiene tracción a las 4 ruedas?", "Sí", "No"));
                i++;
            }
            else
                salir = true;
        }

        for (i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null)
                System.out.printf("Vehículo %d: %s%n", i + 1, vehiculos[i]);
        }
        System.out.println("¡Adiós!");
        Teclado.pichita();
    }
}
