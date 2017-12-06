using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace PracticaBotonera2
{
    class Album
    {
        private ArrayList album;        
        private int indice;     
      
        public Album()
        {
            album = new ArrayList();
            indice = 0;
        }
      
        public int getIndice()
        {
            return indice;
        }

        public int longitud()
        {
            return album.Count;
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
            album.Add(p);
        }

        public Personaje recibir()
        {
            return (Personaje) album[indice];
        }

        public void indiceInicio()
        {
            indice = 0;
        }

        public void indiceFin()
        {
            indice = album.Count;
        }
    }
}
