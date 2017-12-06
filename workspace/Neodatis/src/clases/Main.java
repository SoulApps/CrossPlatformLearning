package clases;

import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Alejandro on 16/02/2017.
 */
public class Main {
    final static SimpleDateFormat FORMATO = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        ODB odb = ODBFactory.open("bd.neo");

        //Inserciones.
        /*try {
            //Objetos de prueba.
            Articulos articulo1 = new Articulos(1, "Arti 1", 30, 25f);
            Articulos articulo2 = new Articulos(2, "Arti 2", 10, 30f);
            Articulos articulo3 = new Articulos(3, "Arti 3", 5, 100f);

            Clientes cliente1 = new Clientes(1, "JoJo", "Algeciras");
            Clientes cliente2 = new Clientes(2, "Dio", "Algeciras");
            Clientes cliente3 = new Clientes(3, "Dabeef", "Shira city");

            Ventas venta1 = new Ventas(1, articulo3, cliente1, 3, FORMATO.parse("21-2-2017"));
            Ventas venta2 = new Ventas(2, articulo1, cliente1, 5, FORMATO.parse("21-2-2017"));
            Ventas venta3 = new Ventas(3, articulo3, cliente2, 2, FORMATO.parse("22-2-2017"));

            //Insert
            odb.store(articulo1);
            odb.store(articulo2);
            odb.store(articulo3);

            odb.store(cliente1);
            odb.store(cliente2);
            odb.store(cliente3);

            odb.store(venta1);
            odb.store(venta2);
            odb.store(venta3);

            odb.commit();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        System.out.println("----------------------------------------------------------------------------------------------------Apartado 1----------------------------------------------------------------------------------------------------");
        metodoA(odb);
        System.out.println("----------------------------------------------------------------------------------------------------Apartado 2----------------------------------------------------------------------------------------------------");
        metodoB(odb);
        System.out.println("----------------------------------------------------------------------------------------------------Apartado 3----------------------------------------------------------------------------------------------------");
        metodoC(odb);
        System.out.println("----------------------------------------------------------------------------------------------------Apartado 4----------------------------------------------------------------------------------------------------");
        metodoD(odb);

        odb.close();
    }

    private static void metodoA(ODB odb) {
        Ventas v;
        IQuery query = new CriteriaQuery(Ventas.class);
        Objects<Ventas> o = odb.getObjects(query);
        System.out.printf("%-10s %-10s %-15s %-10s %-10s %-15s %-10s %-10s%n", "CODVENTA", "CODARTI", "DENOMINACIÓN", "NUMCLI", "NOMBRE", "FECHA", "UNIVEN", "IMPORTE");
        System.out.println("--------------------------------------------------------------------------------------------------");
        while (o.hasNext()) {
            v = o.next();
            System.out.printf("%-10d %-10d %-15s %-10d %-10s %-15s %-10d %-10.2f%n", v.codventa, v.codarti.codarti, v.codarti.denom, v.numcli.numcli,v.numcli.nombre, FORMATO.format(v.fecha), v.univen, v.codarti.pvp * v.univen);
        }
    }

    private static void metodoB(ODB odb) {
        BigDecimal sum;
        BigInteger count;
        ObjectValues objectValuesArticulos, objectValuesGroupBy;
        Values articulos = odb.getValues(new ValuesCriteriaQuery(Ventas.class).field("codarti.codarti").field("codarti.denom").field("codarti.stock").field("codarti.pvp").groupBy("codarti"));
        Values groupby = odb.getValues(new ValuesCriteriaQuery(Ventas.class).sum("univen").count("codarti.codventa").groupBy("codarti.codarti"));

        System.out.printf("%-10s %-15s %-10s %-10s %-15s %-15s %-10s%n", "CODARTI", "DENOMINACIÓN", "STOCK", "PVP", "SUMA_UNIVEN", "SUMA_IMPORTE", "NUM_VENTAS");
        System.out.println("--------------------------------------------------------------------------------------------------");
        while (groupby.hasNext()) {
            objectValuesArticulos = articulos.next();
            objectValuesGroupBy = groupby.next();
            sum = (BigDecimal) objectValuesGroupBy.getByIndex(0);
            count = (BigInteger) objectValuesGroupBy.getByIndex(1);
            System.out.printf("%-10d %-15s %-10d %-10.2f %-15.2f %-15.2f %-10d%n", objectValuesArticulos.getByIndex(0), objectValuesArticulos.getByIndex(1), objectValuesArticulos.getByIndex(2), objectValuesArticulos.getByIndex(3), sum, (Float) objectValuesArticulos.getByIndex(3) * sum.floatValue(), count);
        }
    }

    private static void metodoC(ODB odb) {
        BigDecimal sum;
        BigInteger count;
        ObjectValues objectValuesClientes, objectValuesGroupBy;
        Values articulos = odb.getValues(new ValuesCriteriaQuery(Clientes.class).field("numcli").field("nombre").field("pobla"));
        Values groupby = odb.getValues(new ValuesCriteriaQuery(Ventas.class).sum("codarti.pvp").count("codventa").groupBy("numcli"));

        System.out.printf("%-10s %-10s %-12s %-17s %-10s%n", "NUMCLI", "NOMBRE", "POBLACIÓN", "TOTAL_IMPORTE", "NUM_VENTAS");
        System.out.println("---------------------------------------------------------------------");

        while (groupby.hasNext()) {
            objectValuesClientes = articulos.next();
            objectValuesGroupBy = groupby.next();
            sum = (BigDecimal) objectValuesGroupBy.getByIndex(0);
            count = (BigInteger) objectValuesGroupBy.getByIndex(1);
            System.out.printf("%-10d %-10s %-12s %-17.2f %-10d%n", objectValuesClientes.getByIndex(0), objectValuesClientes.getByIndex(1), objectValuesClientes.getByIndex(2), sum.floatValue(), count);
        }
    }

    private static void metodoD(ODB odb) {
        ArrayList<String> clientes = new ArrayList<String>();
        float mayor = 0, f1, f2;
        String r1 = "", r3 = "", r4 = "";
        Values v;
        ObjectValues ov;

        //1
        v = odb.getValues(new ValuesCriteriaQuery(Ventas.class).field("codarti.denom").count("codarti.codarti").groupBy("codarti.denom"));
        while (v.hasNext()) {
            ov = v.next();
            if (((BigInteger) ov.getByIndex(1)).intValue() >= mayor) {
                mayor = ((BigInteger) ov.getByIndex(1)).intValue();
                r1 = (String) ov.getByIndex(0);
            }
        }
        System.out.printf("El artículo más vendido es: %s%n", r1);


        //2
        v = odb.getValues(new ValuesCriteriaQuery(Ventas.class).field("codarti.denom").avg("univen").groupBy("codarti.denom"));
        while (v.hasNext()) {
            ov = v.next();
            System.out.printf("Media de %s: %.2f%n", ov.getByIndex(0), ((BigDecimal)ov.getByIndex(1)).floatValue());
        }


        //3
        v = odb.getValues(new ValuesCriteriaQuery(Ventas.class).field("numcli.nombre"));
        mayor = 0;
        while (v.hasNext()) {
            ov = v.next();
            clientes.add((String) ov.getByIndex(0));
        }

        for (String cliente: clientes) {
            v = odb.getValues(new ValuesCriteriaQuery(Ventas.class, Where.equal("numcli.nombre", cliente)).field("codarti.pvp").sum("univen").groupBy("numcli.numcli").groupBy("codarti.pvp"));
            while (v.hasNext()) {
                ov = v.next();
                f1 = (Float) ov.getByIndex(0);
                f2 = ((BigDecimal) ov.getByIndex(1)).floatValue();
                if (f1 * f2 >= mayor) {
                    mayor = f1 * f2;
                    r3 = cliente;
                }
            }
        }
        System.out.printf("El cliente que más gasta es: %s%n", r3);


        //4
        clientes.clear();
        mayor = 0;
        v = odb.getValues(new ValuesCriteriaQuery(Clientes.class).field("nombre"));
        while (v.hasNext()) {
            ov = v.next();
            clientes.add((String) ov.getByIndex(0));
        }

        for (String cliente: clientes) {
            v = odb.getValues(new ValuesCriteriaQuery(Ventas.class, Where.equal("numcli.nombre", cliente)).count("numcli.numcli").groupBy("numcli.nombre"));
            while (v.hasNext()) {
                ov = v.next();
                if (((BigInteger) ov.getByIndex(0)).intValue() >= mayor) {
                    mayor = ((BigInteger) ov.getByIndex(0)).intValue();
                    r4 = cliente;
                }
            }
        }
        System.out.printf("El cliente con más ventas es: %s%n", r4);
    }
}
