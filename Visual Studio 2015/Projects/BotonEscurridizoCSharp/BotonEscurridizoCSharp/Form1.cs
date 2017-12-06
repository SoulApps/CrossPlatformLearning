using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BotonEscurridizoCSharp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        

        private void button1_Click(object sender, EventArgs e)
        {
            //Punto aleatorio
            Random rnd = new Random();
            button1.Location = new Point(rnd.Next(1, this.Width - button1.Width), rnd.Next(1, this.Height - button1.Height));


            //Punto fijo
            button1.Location = new Point(100, 100);
             
        }

        private void button1_MouseHover(object sender, EventArgs e)
        {
            //Mover al pasar por encima
            Random rnd = new Random();
            button1.Location = new Point(rnd.Next(1, this.Width - button1.Width), rnd.Next(1, this.Height - button1.Height));
        }

        private void button1_MouseMove(object sender, MouseEventArgs e)
        {
            //Hacer que huya
            if (e.X <= button1.Width / 2 && button1.Location.X + 1 < (this.Width - button1.Width))
                button1.Location = new Point(button1.Location.X + 1, button1.Location.Y);

            if (e.Y <= button1.Height / 2 && button1.Location.Y + 1 < (this.Height - button1.Height))
                button1.Location = new Point(button1.Location.X, button1.Location.Y + 1);

            if (e.X >= button1.Width / 2 && button1.Location.X - 1 > 0)
                button1.Location = new Point(button1.Location.X - 1, button1.Location.Y);

            if (e.Y >= button1.Height / 2 && button1.Location.Y - 1 > 0)
                button1.Location = new Point(button1.Location.X, button1.Location.Y - 1);

            
        }

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            //Hacer que corra
            int contador = 0;

            if ((contador % 3 == 0 && Math.Pow(Math.Pow(button1.Location.X + button1.Width / 2 - e.X, 2) + Math.Pow(button1.Location.Y + button1.Height / 2 - e.Y, 2), 0.5) < 100))
            {
                if (e.X <= (button1.Location.X + button1.Width / 2 + 20) && button1.Location.X + 1 < (this.Width - button1.Width))
                    button1.Location = new Point(button1.Location.X + 3, button1.Location.Y);


                if (e.Y <= (button1.Location.Y + button1.Height / 2 + 20) && button1.Location.Y + 1 < (this.Height - button1.Height))
                    button1.Location = new Point(button1.Location.X, button1.Location.Y + 3);


                if (e.X >= (button1.Location.X + button1.Width / 2 - 20) && button1.Location.X - 1 > 0)
                    button1.Location = new Point(button1.Location.X - 3, button1.Location.Y);

                if (e.Y >= (button1.Location.Y + button1.Height / 2 - 20) && button1.Location.Y - 1 > 0)
                    button1.Location = new Point(button1.Location.X, button1.Location.Y - 3);
            }

            if ((contador % 5 == 0 && Math.Pow(Math.Pow(button1.Location.X + button1.Width / 2 - e.X, 2) + Math.Pow(button1.Location.Y + button1.Height / 2 - e.Y, 2), 0.5) < 100))
            {
                if (e.X <= (button1.Location.X + button1.Width / 2 + 10) && button1.Location.X + 1 < (this.Width - button1.Width))
                    button1.Location = new Point(button1.Location.X + 1, button1.Location.Y);


                if (e.Y <= (button1.Location.Y + button1.Height / 2 + 10) && button1.Location.Y + 1 < (this.Height - button1.Height))
                    button1.Location = new Point(button1.Location.X, button1.Location.Y + 1);


                if (e.X >= (button1.Location.X + button1.Width / 2 - 10) && button1.Location.X - 1 > 0)
                    button1.Location = new Point(button1.Location.X - 1, button1.Location.Y);

                if (e.Y >= (button1.Location.Y + button1.Height / 2 - 10) && button1.Location.Y - 1 > 0)
                    button1.Location = new Point(button1.Location.X, button1.Location.Y - 1);
            }
            contador++;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.Cursor = Cursors.Hand;
            button1.Text = "Persona";
            button1.Width = new Random().Next(1, 100);
            button1.Height = new Random().Next(1, 100);
            button1.Image = Image.FromFile(Application.StartupPath + @"\Pogchamp.jpg");
            this.Cursor = new Cursor(Application.StartupPath + @"\Kappa.cur");

        }
    }


}
