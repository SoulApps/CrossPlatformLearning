package examenAnhoPasado;

/**
 * Created by Alejandro on 09/05/2016.
 */
public enum EnumCategoria {
    JEFE('J'), ENCARGADO('E'), EMPLEADO('D');

    private char codigo;

    EnumCategoria(char codigo) {
        this.codigo = codigo;
    }

    public char getCodigo() {
        return codigo;
    }
}
