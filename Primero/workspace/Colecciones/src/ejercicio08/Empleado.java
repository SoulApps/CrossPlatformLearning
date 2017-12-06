package ejercicio08;

import java.util.ArrayList;

/**
 * Created by Alejandro on 24/02/2016.
 */
public class Empleado implements Cloneable {
    public final double SUELDO_BASE = 1200;
    protected String nombre;
    protected double sueldo;
    protected int horasTrabajadas;
    ArrayList<Venta> ventas;

    public Empleado(String nombre) {
        this.nombre = nombre;
        calcularSueldo();
        horasTrabajadas = 0;
        ventas = new ArrayList<>();
    }


    protected void calcularSueldo() {
        sueldo = SUELDO_BASE;
    }

    public void incrementarHorasTrabajadas(int horas) {
        horasTrabajadas += horas;
    }

    public void ventaRealizada(int numVenta, double importe) {
        ventas.add(new Venta(numVenta, importe));
    }

    public void aumentoProductividad() {
        double sumaImportes = 0;

        for (Venta v:ventas)
            sumaImportes += v.getImporte();

        sueldo *= sumaImportes / 100;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
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

        try {
            emp = (Empleado) super.clone();
            emp.ventas = (ArrayList<Venta>) ventas.clone();
        } catch (CloneNotSupportedException e) {
            emp = null;
        }

        return emp;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Empleado)
            if (nombre.equals(((Empleado) o).nombre) && sueldo == ((Empleado) o).sueldo && ventas.equals(((Empleado) o).ventas))
                igual = true;

        return igual;
    }

    public String toString() {
        int i;
        String stringVentas = "";
        for (Venta v:ventas)
            stringVentas += v.toString() + " ";
        return String.format("[Nombre: %s] [Sueldo: %.2f] [Horas trabajadas: %d] %n %5s%n", nombre, sueldo, horasTrabajadas, stringVentas);
        //return String.format("[Nombre: %s] [Sueldo: %f] [Horas trabajadas: %d] %n %5s", nombre, sueldo, horasTrabajadas, Arrays.toString(ventas)); //El Arrays.toString también muestra los nulos.
    }
}
