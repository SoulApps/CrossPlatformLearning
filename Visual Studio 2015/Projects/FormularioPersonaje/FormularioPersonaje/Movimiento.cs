using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormularioPersonaje
{
    //Clase que representará los movimientos de los pokémon.

    class Movimiento
    {
        private string nombre;
        private int potencia;
        private int precision;

        public Movimiento(int potencia, int precision)
        {         
            this.potencia = potencia;
            this.precision = precision;
        }

        public void setNombre(string nombre)
        {
            this.nombre = nombre;
        }

        public string getNombre()
        {
            return nombre;
        }

        public string toString()
        {
            return nombre + ": Potencia: " + potencia + " | Precisión: " + precision;
        }
    }
}
