/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandro_examen;

/**
 *
 * @author Alejandro
 */
public class EstadisticaPropuesta {
    private String titulo;
    private int numVotos;

    public EstadisticaPropuesta(String titulo, int numVotos) {
        this.titulo = titulo;
        this.numVotos = numVotos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }
}
