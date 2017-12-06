package examenAnhoPasado;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 09/05/2016.
 */
public class Empleado implements Cloneable, Comparable<Empleado> {
    private Clave clave;
    private String nombre;
    private Date fechaAlta;
    private Date fechaBaja;
    private static int jefes = 0;
    private static int encargados = 0;
    private static int empleados = 0;

    public Empleado(String nombre, EnumCategoria categoria, Date fechaAlta, Date fechaBaja) {
        this.nombre = nombre;
        clave = asignarClave(categoria);
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }


    public Clave getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }



    public Clave asignarClave(EnumCategoria categoria) {
        int numero;

        if (categoria == EnumCategoria.JEFE)
            numero = ++jefes;
        else if (categoria == EnumCategoria.ENCARGADO)
            numero = ++encargados;
        else
            numero = ++empleados;

        return new Clave(categoria, numero++);
    }


    public int diasTrabajados() {
        final int DIA = 1000 * 60 * 60 * 24;
        Date fechaAux;

        if (fechaBaja == null)
            fechaAux = new Date();
        else
            fechaAux = fechaBaja;

        return (int) (((fechaAux.getTime() - fechaAlta.getTime())) / DIA);
    }


    public int compareTo(Empleado o) {
        int comp = o.diasTrabajados() - diasTrabajados();

        if (comp == 0)
            comp = clave.toString().compareTo(o.clave.toString());

        return comp;
    }

    public Object clone() {
        Empleado emp;

        try {
            emp = (Empleado) super.clone();
            emp.clave = (Clave) clave.clone();
            emp.fechaAlta = (Date) fechaAlta.clone();
            if (fechaBaja != null)
                emp.fechaBaja = (Date) fechaBaja.clone();
        } catch (CloneNotSupportedException e) {
            emp = null;
        }

        return emp;
    }

    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-15s Nombre: %-15s Clave: %-15s Fecha alta: %-15s Fecha baja: %-15s Días trabajados: %-15d", clave.getCategoria(), nombre, clave, formato.format(fechaAlta), (fechaBaja == null)?"no tiene":formato.format(fechaBaja), diasTrabajados());
    }
}
