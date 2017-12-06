package ejercicio24;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Munheca extends Juguete implements Cloneable {
    private float valorEconomico;
    protected Bebe b;
    Date fecha;

    public Munheca(String nombre, String color, boolean dormido, float peso, String fecha) throws NombreIncorrectoException {
        super(nombre, color);
        valorEconomico = 10;
        setFecha(fecha);
        b = new Bebe(dormido, peso);

    }


    public float calcuarValorEconomico() {
        return valorEconomico;
    }


    public void setFecha(String fechaCompra) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaFormat = null;
        Date valido1 = null, valido2 = null;

        try {
            fechaFormat = formato.parse(fechaCompra);
            valido1 = formato.parse("20/01/2014");
            valido2 = formato.parse("01/02/2014");
        } catch (ParseException e) {

        }

        try {
            if (fechaFormat.equals(valido1) || fechaFormat.equals(valido2))
                fecha = fechaFormat;
            else
                throw new FechaIncorrectaException("Fecha incorrecta");
        } catch (FechaIncorrectaException e) {
            System.out.println(e.getMessage());
        }
    }


    public float getValorEconomico() {
        return valorEconomico;
    }

    public void setValorEconomico(float valorEconomico) {
        this.valorEconomico = valorEconomico;
    }


    public Object clone() {
        Munheca m;

        m = (Munheca) super.clone();
        m.fecha = (Date) fecha.clone();
        m.b = (Bebe) b.clone();

        return m;
    }

    public boolean equals(Object o) {
        boolean igual = false;

        if (o instanceof Munheca)
            if (super.equals(o) && valorEconomico == ((Munheca) o).getValorEconomico() && b.equals(((Munheca) o).b) && fecha.equals(((Munheca) o).fecha))
                igual = true;

        return igual;
    }

    public String toString() {
        return String.format("%s [Valor económico: %.2f] %s", super.toString(), calcuarValorEconomico(), b);
    }
}
