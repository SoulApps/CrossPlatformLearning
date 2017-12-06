using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PracticaBotonera
{
    class Album
    {
        private Personaje[] album;
        private int indice;

        public Album()
        {
            album = new Personaje[1];
            indice = 0;
        }

        public void redim()
        {
            Array.Resize(ref album, album.Length + 1);
        }

        public int getIndice()
        {
            return indice;
        }  

        public int longitud()
        {
            return album.Length;
        }

        public void indicePatras()
        {
            indice--;
        }

        public void indicePalante()
        {
            indice++;
        }

        public void agregar(Personaje p)
        {
            redim();
            album[indice] = p;            
        }

        public Personaje recibir()
        {
            return album[indice];
        }

        public void indiceInicio()
        {
            indice = 0;
        }

        public void indiceFin()
        {
            indice = album.Length - 1;
        }
    }
}
