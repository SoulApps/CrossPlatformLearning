package alejandroSanchezGalvinFicheros;

import java.util.ArrayList;

/**
 * Created by Alejandro on 25/10/2016.
 */
public class ListaEmpleados {

    private ArrayList<Empleado> lista;

    public ListaEmpleados() {
        lista = new ArrayList<Empleado>();
    }

    public void addEmpleado(Empleado e) {
        lista.add(e);
    }

    public ArrayList<Empleado> getAgenda() {
        return lista;
    }
}
