using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.IO;

using System.Windows.Forms;

namespace PersonajeFicheros
{
    class Album
    {
        private ArrayList album;
        private int indice;

        public Album()
        {
            album = new ArrayList();
            leerFichero();
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
            guardarFichero();
        }

        public Personaje recibir()
        {
            leerFichero();
            return (Personaje)album[indice];
        }

        public void indiceInicio()
        {
            indice = 0;
        }

        public void indiceFin()
        {
            indice = album.Count;
        }

        public void leerFichero()
        {
            //int i;
            string s;
            string[] cad;
            album.Clear();
            StreamReader r = new StreamReader(Application.StartupPath + "/Fichero.txt");

            while ((s = r.ReadLine()) != null)
            {
                /*s = s.Replace("|@|", "\n");
                cad = s.Split('\n');
                album.Add(new Personaje(cad[0], int.Parse(cad[1])));*/

                cad = s.Split(new string[] { "|@|" }, StringSplitOptions.None);                            
                album.Add(new Personaje(cad[0], int.Parse(cad[1])));
            }

            r.Close();
        }


        public void guardarFichero()
        {
            StreamWriter w = new StreamWriter(Application.StartupPath + "/Fichero.txt");

            foreach (Personaje p in album)
                w.WriteLine(p.linear());


            w.Close();
        }
    }
}
