package ejercicio25In;

/**
 * Created by Alejandro on 23/02/2016.
 */
public class VehiculoMotor extends Vehiculo implements Arrancable {
    protected Motor motor;
    protected int marcha;
    protected boolean arrancado;


    public VehiculoMotor(String matricula, Marca marca, int cilindrada, int caballos) {
        super(matricula, marca);
        motor = new Motor(cilindrada, caballos);
        marcha = 0;
        arrancado = false;
    }


    public class Motor implements Cloneable {
        private int cilindrada;
        private int caballos;

        public Motor(int cilindrada, int caballos) {
            this.cilindrada = cilindrada;
            this.caballos = caballos;
        }


        public Object clone() {
            Motor m;

            try {
                m = (Motor) super.clone();
            } catch (CloneNotSupportedException e) {
                m = null;
            }

            return m;
        }

        public boolean equals(Object o) {
            boolean igual = false;

            if (o instanceof Motor)
                if (cilindrada == ((Motor) o).cilindrada && caballos == ((Motor) o).caballos)
                    igual = true;

            return igual;
        }

        public String toString() {
            return String.format("[Cilindrada: %d] [Caballos: %d]", cilindrada, caballos);
        }
    }


    public void arrancar() {
        if (!arrancado)
            arrancado = true;
    }

    public void parar() {
        if (arrancado)
            arrancado = false;
    }

    public void subirMarcha() {
        if (arrancado) {
            if (marcha < 6 && marcha >= 0)
                marcha++;
            else {
                puntoMuerto();
                marcha++;
            }
        }
    }

    public void bajarMarcha() {
        if (arrancado) {
            if (marcha > 1)
                marcha--;
        }
    }

    public void puntoMuerto() {
        if (arrancado)
            marcha = 0;
    }

    public void marchaAtras() {
        if (arrancado) {
            puntoMuerto();
            marcha = -1;
        }
    }


    public Object clone() {
        VehiculoMotor vm;

        vm = (VehiculoMotor) super.clone();
        vm.motor = (Motor) motor.clone();

        return vm;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof VehiculoMotor)
            if (super.equals(o) && motor.equals(((VehiculoMotor) o).motor) && arrancado == ((VehiculoMotor) o).arrancado && marcha == ((VehiculoMotor) o).marcha)
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s %s [Estado: %s] [Marcha: %d]", super.toString(), motor, arrancado?"Arrancado":"Apagado", marcha);
    }
}
