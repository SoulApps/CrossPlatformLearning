package ejercicio10;

import ejercicio08.Agenda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandro on 25/10/2016.
 */
public class ListaPersonas {

    private ArrayList<Agenda> lista;

    public ListaPersonas() {
        lista = new ArrayList<Agenda>();
    }

    public void addPersona(Agenda a) {
        lista.add(a);
    }

    public ArrayList<Agenda> getAgenda() {
        return lista;
    }
}
