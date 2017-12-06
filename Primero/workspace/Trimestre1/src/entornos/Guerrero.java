package entornos;

/**
 * Created by Alejandro on 20/11/2015.
 */
public class Guerrero {

    private int vida, fuerza;
    private double destreza, campoVision, posX, posY, posZ;

    public Guerrero(int vida, int fuerza) {
        this.vida = vida;
        this.fuerza = fuerza;
    }

    public Guerrero(int vida, int fuerza, double destreza, double posX, double posY, double posZ) {
        this.vida = vida;
        this.fuerza = fuerza;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public double getDestreza() {
        return destreza;
    }

    public void setDestreza(double destreza) {
        this.destreza = destreza;
    }

    public double getCampoVision() {
        return campoVision;
    }

    public void setCampoVision(double campoVision) {
        this.campoVision = campoVision;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public void golpear(Guerrero enemigo) {
        enemigo.setVida(enemigo.getVida() - fuerza);
    }

    @Override
    public String toString() {
        return "Guerrero{" +
                "vida=" + vida +
                ", fuerza=" + fuerza +
                ", destreza=" + destreza +
                ", campoVision=" + campoVision +
                ", posX=" + posX +
                ", posY=" + posY +
                ", posZ=" + posZ +
                '}';
    }
}
