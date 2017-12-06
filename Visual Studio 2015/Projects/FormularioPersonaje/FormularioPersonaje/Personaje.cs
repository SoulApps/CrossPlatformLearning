using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormularioPersonaje
{
    class Personaje
    {
        private string nombre;
        private Boolean genero;
        private int pokemon;
        private int[] estadisticas;
        private int[] valoresIndividuales;
        private int[] movimientos;
        private int[] objetos;
        private int tiradasDisponibles;


        public Personaje(string nombre, Boolean genero, int pokemon, int[] estadisticas, int[] valoresIndividuales, int[] movimientos, int[] objetos, int tiradasDisponibles)
        {
            int i;

            this.nombre = nombre;
            this.genero = genero;
            this.pokemon = pokemon;

            this.estadisticas = new int[estadisticas.Length];
            for (i = 0; i < estadisticas.Length; i++)
                this.estadisticas[i] = estadisticas[i];

            this.valoresIndividuales = new int[valoresIndividuales.Length];
            for (i = 0; i < valoresIndividuales.Length; i++)
                this.valoresIndividuales[i] = valoresIndividuales[i];

            this.movimientos = new int[movimientos.Length];
            for (i = 0; i < movimientos.Length; i++)
                this.movimientos[i] = movimientos[i];

            this.objetos = new int[objetos.Length];
            for (i = 0; i < objetos.Length; i++)
                this.objetos[i] = objetos[i];

            this.tiradasDisponibles = tiradasDisponibles;
        }

        //Método que cambia los valores de este personaje por los del personaje que se pasa por argumentos.
        public void setPersonaje(Personaje p)
        {
            int i;
            nombre = p.nombre;
            genero = p.genero;
            pokemon = p.pokemon;

            estadisticas = new int[p.estadisticas.Length];
            for (i = 0; i < p.estadisticas.Length; i++)
                estadisticas[i] = p.estadisticas[i];

            valoresIndividuales = new int[p.valoresIndividuales.Length];
            for (i = 0; i < p.valoresIndividuales.Length; i++)
                valoresIndividuales[i] = p.valoresIndividuales[i];

            movimientos = new int[p.movimientos.Length];
            for (i = 0; i < p.movimientos.Length; i++)
                movimientos[i] = p.movimientos[i];

            objetos = new int[p.objetos.Length];
            for (i = 0; i < p.objetos.Length; i++)
                objetos[i] = p.objetos[i];

            tiradasDisponibles = p.tiradasDisponibles;
        }

        public string getNombre()
        {
            return nombre;
        }

        public Boolean getGenero()
        {
            return genero;
        }

        public int getPokemon()
        {
            return pokemon;
        }

        public int[] getEstadisticas()
        {
            return estadisticas;
        }

        public int[] getValoresIndividuales()
        {
            return valoresIndividuales;
        }

        public int[] getMovimientos()
        {
            return movimientos;
        }

        public int[] getObjetos()
        {
            return objetos;
        }

        public int getTiradasDisponibles()
        {
            return tiradasDisponibles;
        }

        
        /*Método que formatea los datos del personaje a una cadena para que se escriba en un fichero.
         * Si el dato es un array, tendrá un separador distinto.
         */ 
        public string toLine()
        {
            string s = nombre + "|@|" + genero + "|@|" + pokemon + "|@|";
            int i;

            for (i = 0; i < estadisticas.Length; i++)
            {
                s += estadisticas[i];
                if (i < estadisticas.Length - 1)
                    s += "%@%";
            }

            s += "|@|";

            for (i = 0; i < valoresIndividuales.Length; i++)
            {
                s += valoresIndividuales[i];
                if (i < valoresIndividuales.Length - 1)
                    s += "ç@ç";
            }

            s += "|@|";
            for (i = 0; i < movimientos.Length; i++)
            {
                s += movimientos[i];
                if (i < movimientos.Length - 1)
                    s += "`@´";
            }

            s += "|@|";
            for (i = 0; i < objetos.Length; i++)
            {
                s += objetos[i];
                if (i < objetos.Length - 1)
                    s += "&@&";
            }

            s += "|@|" + tiradasDisponibles;

            return s;          
        }     
    }
}
