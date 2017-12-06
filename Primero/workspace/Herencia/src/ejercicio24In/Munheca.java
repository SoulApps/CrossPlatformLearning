package ejercicio24In;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Munheca extends Juguete implements Cloneable {
    private float valorEconomico;
    protected Bebe b;

    public Munheca(String nombre, String color, boolean dormido, float peso) throws NombreIncorrectoException {
        super(nombre, color);
        valorEconomico = 10;
        b = new Bebe(dormido, peso);
    }


    public float calcuarValorEconomico() {
        return valorEconomico;
    }


    public float getValorEconomico() {
        return valorEconomico;
    }

    public void setValorEconomico(float valorEconomico) {
        this.valorEconomico = valorEconomico;
    }


    public class Bebe implements Bebito, Cloneable {
        private boolean dormido;
        private float peso;

        public Bebe(boolean dormido, float peso) {
            this.dormido = dormido;
            this.peso = peso;
        }


        public void dormir() {
            if (!dormido)
                dormido = true;
        }

        public void despertar() {
            if (dormido)
                dormido = false;
        }

        public void comer(float litros) {
            if (!dormido)
                peso += litros * 0.25;
        }

        public Object clone() {
            Bebe b;

            try {
                b = (Bebe) super.clone();
            } catch (CloneNotSupportedException e) {
                b = null;
            }
            return b;
        }

        public boolean equals(Object o) {
            boolean igual = false;

            if (o instanceof Bebe)
                if (dormido == ((Bebe) o).dormido && peso == ((Bebe) o).peso)
                    igual = true;

            return igual;
        }

        public String toString() {
            return String.format("[Estado: %s] [Peso: %.2f]", dormido?"Dormido":"Despierto", peso);
        }
    }





    public Object clone() {
        Munheca m;

        m = (Munheca) super.clone();
        m.b = (Bebe) b.clone();

        return m;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Munheca)
            if (super.equals(o) && valorEconomico == ((Munheca) o).getValorEconomico() && b.equals(((Munheca) o).b))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Valor económico: %.2f] %s", super.toString(), calcuarValorEconomico(), b);
    }
}
