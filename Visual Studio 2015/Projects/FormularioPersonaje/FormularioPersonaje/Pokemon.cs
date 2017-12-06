using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormularioPersonaje
{
    //Enum que especifica el tipo de pokémon.
    enum Tipos
    {
        PLANTA, FUEGO, AGUA
    }

    class Pokemon
    {
        private string nombre;
        private Tipos tipo;
        private Movimiento[] movimientos;

        public Pokemon(string nombre, Tipos tipo)
        {
            this.nombre = nombre;
            this.tipo = tipo;

            //Creación del array de movimientos.
            movimientos = new Movimiento[10];
            movimientos[0] = new Movimiento(35, 100);
            movimientos[1] = new Movimiento(40, 95);
            movimientos[2] = new Movimiento(45, 90);
            movimientos[3] = new Movimiento(50, 85);
            movimientos[4] = new Movimiento(55, 80);
            movimientos[5] = new Movimiento(60, 75);
            movimientos[6] = new Movimiento(65, 70);
            movimientos[7] = new Movimiento(70, 65);
            movimientos[8] = new Movimiento(75, 60);
            movimientos[9] = new Movimiento(80, 55);


            //Definición de los diferentes movimientos según el tipo.

            if (tipo == Tipos.PLANTA)
            {
                movimientos[0].setNombre("Latigo Cepa");
                movimientos[1].setNombre("Hoja afilada");
                movimientos[2].setNombre("Recurrente");
                movimientos[3].setNombre("Absorber");
                movimientos[4].setNombre("Megaagotar");
                movimientos[5].setNombre("Gigadrenado");
                movimientos[6].setNombre("Mazazo");
                movimientos[7].setNombre("Latigazo");
                movimientos[8].setNombre("Rayo solar");
                movimientos[9].setNombre("Planta feroz");
            }
            else if (tipo == Tipos.FUEGO)
            {
                movimientos[0].setNombre("Ascuas");
                movimientos[1].setNombre("Giro fuego");
                movimientos[2].setNombre("Pirotecnia");
                movimientos[3].setNombre("Giro fuego");
                movimientos[4].setNombre("Lanzallamas");
                movimientos[5].setNombre("Envite ígneo");
                movimientos[6].setNombre("Onda ígnea");
                movimientos[7].setNombre("Sofoco");
                movimientos[8].setNombre("Llamarada");
                movimientos[9].setNombre("Anillo ígneo");
            }
            else
            {
                movimientos[0].setNombre("Burbuja");
                movimientos[1].setNombre("Pistola agua");
                movimientos[2].setNombre("Rayo burbuja");
                movimientos[3].setNombre("Salmuera");
                movimientos[4].setNombre("Cascada");
                movimientos[5].setNombre("Surf");
                movimientos[6].setNombre("Hidropulso");
                movimientos[7].setNombre("Acua cola");
                movimientos[8].setNombre("Hidrobomba");
                movimientos[9].setNombre("Hidrocañón");
            }
        }

        public Movimiento[] getMovimientos()
        {
            return movimientos;
        }

        public string getNombre()
        {
            return nombre;
        }

        public Tipos getTipo()
        {
            return tipo;
        }
    }
}
