package ejercicio27In;

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


    public class Venta implements Cloneable {
        private int numVenta;
        private double importe;

        public Venta(int numVenta, double importe) {
            this.numVenta = numVenta;
            this.importe = importe;
        }


        public int getNumVenta() {
            return numVenta;
        }

        public void setNumVenta(int numVenta) {
            this.numVenta = numVenta;
        }

        public double getImporte() {
            return importe;
        }

        public void setImporte(double importe) {
            this.importe = importe;
        }

        public Object clone() {
            Venta v;

            try{
                v = (Venta) super.clone();
            } catch (CloneNotSupportedException e) {
                v = null;
            }

            return v;
        }

        public boolean equals(Object o) {
            boolean igual = false;

            if (o instanceof Venta)
                if (numVenta == ((Venta) o).numVenta && importe == ((Venta) o).importe)
                    igual = true;

            return igual;
        }

        public String toString() {
            return String.format("[Número de venta: %d] [Importe: %.2f]", numVenta, importe);
        }
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
