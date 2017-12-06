/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Alejandro
 */
public class Horario {

    private String horaTramo;
    private String horaLunes;
    private String horaMartes;
    private String horaMiercoles;
    private String horaJueves;
    private String horaViernes;

    public Horario(String horaTramo, String horaLunes, String horaMartes, String horaMiercoles, String horaJueves, String horaViernes) {
        this.horaTramo = horaTramo;
        this.horaLunes = horaLunes;
        this.horaMartes = horaMartes;
        this.horaMiercoles = horaMiercoles;
        this.horaJueves = horaJueves;
        this.horaViernes = horaViernes;
    }

    public String getHoraTramo() {
        return horaTramo;
    }

    public void setHoraTramo(String horaTramo) {
        this.horaTramo = horaTramo;
    }

    public String getHoraLunes() {
        return horaLunes;
    }

    public void setHoraLunes(String horaLunes) {
        this.horaLunes = horaLunes;
    }

    public String getHoraMartes() {
        return horaMartes;
    }

    public void setHoraMartes(String horaMartes) {
        this.horaMartes = horaMartes;
    }

    public String getHoraMiercoles() {
        return horaMiercoles;
    }

    public void setHoraMiercoles(String horaMiercoles) {
        this.horaMiercoles = horaMiercoles;
    }

    public String getHoraJueves() {
        return horaJueves;
    }

    public void setHoraJueves(String horaJueves) {
        this.horaJueves = horaJueves;
    }

    public String getHoraViernes() {
        return horaViernes;
    }

    public void setHoraViernes(String horaViernes) {
        this.horaViernes = horaViernes;
    }   
}
