using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.IO;

using System.Windows.Forms;

namespace FormularioPersonaje
{

    //Clase que actuará como album de personajes.
    class Album
    {
        private ArrayList album;
        private int indice;

        public Album()
        {
            indice = 0;
            album = new ArrayList();          
        }

        //Métodos de utilidad.
        public int getIndice()
        {
            return indice;
        }

        public int longitud()
        {
            return album.Count;
        }

        public void indiceAtras()
        {
            indice--;
        }

        public void indiceSiguiente()
        {
            indice++;
        }

        public void agregar(Personaje p)
        {
            album.Add(p);
        }



        //Cambia el personaje apuntando por el índice por el que se pasa por argumentos.
        public void cambiar(Personaje p)
        {
            Personaje antiguo = recibir();
            if (antiguo != null)
                antiguo.setPersonaje(p);
        }

        //Obtiene el personaje apuntado atualmente por el índice.
        public Personaje recibir()
        {
            if (longitud() != 0 && indice != album.Count)
                return (Personaje) album[indice];
            return null;        
        }
      
        //Lee del fichero que se pasa por argumentos y agrega su contenido al ArrayList.
        public void leerFichero(string fichero)
        {
            string s;
            int i;
            string[] cad, aux;
            int[] estadisticas = new int[6], valoresIndividuales = new int[6], movimientos = new int[4], objetos = new int[2];
            //StreamReader r = new StreamReader(Application.StartupPath + "/Fichero.txt");
            StreamReader r = new StreamReader(fichero);
            album.Clear(); //Limpia el ArrayList antes de escribir.

            /*En este bucle se va leyendo el fichero que se pasa por argumentos línea a línea y con un split se van obteniendo los
             * valores de los personajes que se guardarán en variables auxiliares antes de agregarse a la lista.
             */
            while ((s = r.ReadLine()) != null)
            {                            
                cad = s.Split(new string[] { "|@|" }, StringSplitOptions.None);

                aux = cad[3].Split(new string[] { "%@%" }, StringSplitOptions.None);
                for (i = 0; i < aux.Length; i++)
                    estadisticas[i] = int.Parse(aux[i]);

                aux = cad[4].Split(new string[] { "ç@ç" }, StringSplitOptions.None);
                for (i = 0; i < aux.Length; i++)
                    valoresIndividuales[i] = int.Parse(aux[i]);

                aux = cad[5].Split(new string[] { "`@´" }, StringSplitOptions.None);
                for(i = 0; i < aux.Length; i++)
                    movimientos[i] = int.Parse(aux[i]);

                aux = cad[6].Split(new string[] { "&@&" }, StringSplitOptions.None);
                for (i = 0; i < aux.Length; i++)
                    objetos[i] = int.Parse(aux[i]);

                //Se añade el personaje con los valores de las variables auxiliares.
                album.Add(new Personaje(cad[0], Boolean.Parse(cad[1]), int.Parse(cad[2]), estadisticas, valoresIndividuales, movimientos, objetos, int.Parse(cad[7])));
            }
            r.Close();
        }

        //Lee el fichero por defecto que se encuentra en la carpeta de usuario.
        public void leerFichero()
        {
            //Comprueba si se está ejecutando desde Visual Studio para elegir el archivo.
            if (Application.StartupPath.Split('\\')[Application.StartupPath.Split('\\').Length - 1] == "Debug")
                leerFichero(Application.StartupPath + @"\..\..\fichero.txt");
            else
                leerFichero(Application.LocalUserAppDataPath + @"fichero.txt");
        }

        //Lee el fichero por defecto que se encuentra en la carpeta de usuario.
        public void guardarFichero()
        {
            if (Application.StartupPath.Split('\\')[Application.StartupPath.Split('\\').Length - 1] == "Debug")
                guardarFichero(Application.StartupPath + @"\..\..\fichero.txt");
            else
            guardarFichero(Application.LocalUserAppDataPath + @"fichero.txt");     
        }

        //Guarda los datos del ArrayList en el fichero que se pasa por argumentos.
        public void guardarFichero(string fichero)
        {
            StreamWriter w = new StreamWriter(fichero);

            foreach (Personaje p in album)
                w.WriteLine(p.toLine());

            w.Close();
        }

        //Elimina el personaje actual.
        public void eliminar()
        {
            //Se comprueba si el album está vacío.
            if (album.Count != 0)
            {
                //Si está vacío, lo borra y el índice se va a la posición 0.
                album.Remove(album[indice]);
                indice = 0;
            }
            else //Si no, se borra todo el album.
                album.Clear();
        }
    }
}
