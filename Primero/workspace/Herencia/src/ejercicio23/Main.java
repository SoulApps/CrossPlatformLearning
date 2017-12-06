package ejercicio23;

/**
 * Created by Alejandro on 22/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        final String RESET = "\u001B[0m";
        final String ROJO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final int TAMANO = 6;
        Planta p1, p2, p1clon;
        Insecto i1, i2, i1clon;
        SerVivo padres[] = new SerVivo[TAMANO];
        SerVivo crias[];

        //Plantas
        p1 = new Planta("Peral", true, Tipo.ARBOL, 2.2f);
        p2 = new Planta("Naranjo", true, Tipo.ARBOL, 2);
        p1clon = (Planta) p1.clone();
        System.out.println(p1.equals(p2)?String.format("La planta %s es igual a la planta %s", p1, p2):String.format("La planta %s no es igual a la planta %s", p1, p2));
        System.out.println(p1.equals(p1clon)?String.format("La planta %s es igual a la planta %s", p1, p1clon):String.format("La planta %s no es igual a la planta %s", p1, p1clon));
        p1clon.setTipoPlanta(Tipo.ARBUSTO);
        System.out.println(p1.equals(p1clon)?String.format("La planta %s es igual a la planta %s", p1, p1clon):String.format("La planta %s no es igual a la planta %s", p1, p1clon));
        System.out.println();

        //Insectos
        i1 = new Insecto("Verde Hoja", (short) 7, 214.666f);
        i2 = new Insecto("Rojo Fuego", (short) 13, 27);
        i1clon = (Insecto) i1.clone();
        System.out.println(i1.equals(i2)?String.format("El insecto %s es igual al insecto %s", i1, i2):String.format("El insecto %s no es igual al insecto %s", i1, i2));
        System.out.println(i1.equals(i1clon)?String.format("El insecto %s es igual al insecto %s", i1, i1clon):String.format("El insecto %s no es igual al insecto %s", i1, i1clon));
        i1clon.setColor("Negro Mierda");
        System.out.println(i1.equals(i1clon)?String.format("El insecto %s es igual al insecto %s", i1, i1clon):String.format("El insecto %s no es igual al insecto %s", i1, i1clon));
        System.out.println();


        //Plants vs Insects
        System.out.println(p1.equals(i1)?String.format("La planta %s es igual al insecto %s", p1, i1):String.format("La planta %s no es igual al insecto %s", p1, i1));
        System.out.println();

        //Comprobar plantas e insectos creados hasta ahora.
        System.out.printf("Se han creado %d insectos%n", Insecto.getInsectosCreados());
        System.out.printf("Se han creado %d plantas%n", Planta.getPlantasCreadas());
        System.out.println();


        //Reproduciendo
        //Introduciendo valores en el array
        padres[0] = p1;
        padres[1] = p2;
        padres[2] = i1;
        padres[3] = i2;
        padres[4] = p1clon;
        padres[5] = i1clon;
        //Mostrando el array padres con el color rojo
        System.out.println(ROJO);
        mostrarArray(padres);
        //Criando...
        crias = criar(padres);
        //Mostrando el array crias con el color verde
        System.out.println(VERDE);
        mostrarArray(crias);
        System.out.println(RESET);
    }

    public static SerVivo[] criar(SerVivo padre[]) {
        int i;
        SerVivo crias[] = new SerVivo[padre.length];

        for (i = 0; i < padre.length; i++) {
            if (padre[i] instanceof Insectable)
                padre[i].nutrir(i);
            else if (padre[i] instanceof Plantable) //El else if es para que me ignore los nulos
                padre[i].nutrir(i);
            crias[i] = (SerVivo) padre[i].clone();
        }

        return crias;
    }

    public static void mostrarArray(SerVivo array[]) {
        int i;
        for (i = 0; i < array.length; i++) {
            System.out.printf("%d.- %s%n", i, array[i]);
        }
    }
}
