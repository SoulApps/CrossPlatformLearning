using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PracticaBotonera2
{
    class Personaje
    {
        private string nombre;
        private int edad;

        public Personaje(string nombre, int edad)
        {
            this.nombre = nombre;
            this.edad = edad;
        }

        public string getNombre()
        {
            return nombre;
        }

        public int getEdad()
        {
            return edad;
        }

        public void setNombre(string nombre)
        {
            this.nombre = nombre;
        }

        public void setEdad(int edad)
        {
            this.edad = edad;
        }
    }
}
