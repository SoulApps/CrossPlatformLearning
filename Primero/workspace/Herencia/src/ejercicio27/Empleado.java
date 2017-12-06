package ejercicio27;

import java.util.Arrays;

/**
 * Created by Alejandro on 24/02/2016.
 */
public abstract class Empleado implements Cloneable {
    public final double SUELDO_BASE = 1200;
    public final int NUMVENTAS = 5;
    protected String nombre;
    protected double sueldo;
    protected int horasTrabajadas;
    Venta ventas[];

    public Empleado(String nombre) {
        this.nombre = nombre;
        calcularSueldo();
        horasTrabajadas = 0;
        ventas = new Venta[NUMVENTAS];
    }


    protected abstract void calcularSueldo();

    public void incrementarHorasTrabajadas(int horas) {
        horasTrabajadas += horas;
    }

    public void ventaRealizada(int numVenta, double importe) {
        int i = 0;
        boolean salir = false;

        while (i < ventas.length && !salir) {
            if (ventas[i] == null) {
                ventas[i] = new Venta(numVenta, importe);
                salir = true;
            }
            else
                i++;
        }
    }

    public void aumentoProductividad() {
        double sumaImportes = 0;
        int i;

        for (i = 0; i < ventas.length; i++) {
            if (ventas[i] != null)
                sumaImportes += ventas[i].getImporte();
        }

        sueldo *= sumaImportes / 100;
    }



    protected Object clone() {
        Empleado emp;
        int i;

        try {
            emp = (Empleado) super.clone();
            emp.ventas = ventas.clone();
            for (i = 0; i < ventas.length; i++)
                if (ventas[i] != null)
                    emp.ventas[i] = (Venta) ventas[i].clone();
        } catch (CloneNotSupportedException e) {
            emp = null;
        }

        return emp;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Empleado)
            if (nombre.equals(((Empleado) o).nombre) && sueldo == ((Empleado) o).sueldo && Arrays.equals(ventas, ((Empleado) o).ventas))
                igual = true;

        return igual;
    }

    public String toString() {
        int i;
        String stringVentas = "";
        for (i = 0; i < ventas.length; i++)
            if (ventas[i] != null)
                stringVentas += ventas[i].toString() + " ";
        return String.format("[Nombre: %s] [Sueldo: %f] [Horas trabajadas: %d] %n %5s", nombre, sueldo, horasTrabajadas, stringVentas);
        //return String.format("[Nombre: %s] [Sueldo: %f] [Horas trabajadas: %d] %n %5s", nombre, sueldo, horasTrabajadas, Arrays.toString(ventas)); //El Arrays.toString también muestra los nulos.
    }
}
