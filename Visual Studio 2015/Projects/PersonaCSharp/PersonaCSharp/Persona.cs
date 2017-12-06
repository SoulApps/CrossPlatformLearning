using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
using System.Windows.Forms;

namespace PersonaCSharp
{
    public class Persona
    {
        public Point posicion;
        public int velCorrer;
        public int velAndar;
        public string nombre;
        public int edad;
        public int tamanho;
        public int miedo;
        public int panico;
        public Button boton;
        public Image imagen;

        public Persona()
        {
            boton = new Button();
            velCorrer = 3;
            velAndar = 1;
            edad = 1;
            miedo = 5;
            panico = 3;
            //imagen = Image.FromFile(Application.StartupPath + @"\Kappa.png");
            imagen = Properties.Resources.Kappa;
            boton.BackgroundImage = imagen;
            boton.Click += new EventHandler(onClick);
        }

        private void onClick(object sender, EventArgs e)
        {
            morir();
        }
     

        public void huir(Size form, Point e)
        {
            int contador = 0;

            if ((contador % panico == 0 && Math.Pow(Math.Pow(posicion.X + tamanho / 2 - e.X, 2) + Math.Pow(posicion.Y + tamanho / 2 - e.Y, 2), 0.5) < 100))
            {
                if (e.X <= (posicion.X + tamanho / 2 + 20) && posicion.X + 1 < (form.Width - tamanho))
                    posicion = new Point(posicion.X + 3, posicion.Y);


                if (e.Y <= (posicion.Y + tamanho / 2 + 20) && posicion.Y + 1 < (form.Height - tamanho))
                    posicion = new Point(posicion.X, posicion.Y + 3);


                if (e.X >= (posicion.X + tamanho / 2 - 20) && posicion.X - 1 > 0)
                    posicion = new Point(posicion.X - 3, posicion.Y);

                if (e.Y >= (posicion.Y + tamanho / 2 - 20) && posicion.Y - 1 > 0)
                    posicion = new Point(posicion.X, posicion.Y - 3);
            }

            if ((contador % miedo == 0 && Math.Pow(Math.Pow(posicion.X + tamanho / 2 - e.X, 2) + Math.Pow(posicion.Y + tamanho / 2 - e.Y, 2), 0.5) < 100))
            {
                if (e.X <= (posicion.X + tamanho / 2 + 10) && posicion.X + 1 < (form.Width - tamanho))
                    posicion = new Point(posicion.X + 1, posicion.Y);


                if (e.Y <= (posicion.Y + tamanho / 2 + 10) && posicion.Y + 1 < (form.Height - tamanho))
                    posicion = new Point(posicion.X, posicion.Y + 1);


                if (e.X >= (posicion.X + tamanho / 2 - 10) && posicion.X - 1 > 0)
                    posicion = new Point(posicion.X - 1, posicion.Y);

                if (e.Y >= (posicion.Y + tamanho / 2 - 10) && posicion.Y - 1 > 0)
                    posicion = new Point(posicion.X, posicion.Y - 1);
            }
            contador++;

            boton.Location = posicion;
        }

        public void crecer()
        {
            if (edad < 10)
            {
                edad++;
                tamanho += 5;
                boton.Width = tamanho;
                boton.Height = tamanho;
                boton.BackgroundImageLayout = ImageLayout.Stretch;
            }
            else
                morir();                
        }

        public void morir()
        {
            boton.Dispose();
        }

        public Persona nacer(Form f, string nombre)
        {
            this.nombre = nombre;
            tamanho = new Random().Next(100);
            posicion = new Point(new Random().Next(f.Width - tamanho), new Random().Next(f.Height - tamanho));           
            boton.Location = posicion;
            boton.Width = tamanho;
            boton.Height = tamanho;
            boton.BackgroundImageLayout = ImageLayout.Stretch;
            f.Controls.Add(boton);

            return this;
        }

    }
}

