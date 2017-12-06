using System;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;
using System.IO;

namespace PersonaCSharp
{
    public partial class Form1 : Form
    {
        Persona p;
        ArrayList lista;
        

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {           
            lista = new ArrayList();

            timer1.Interval = 1000;
            timer1.Start();
            timer2.Interval = 5000;
            timer2.Start();

            //this.Cursor = new Cursor(Application.StartupPath + @"\Pogchamp.cur");
            //this.Cursor = new Cursor(Properties.Resources.Pogchamp);
            
            using (var memoryStream = new MemoryStream(Properties.Resources.Pogchamp))
            {
                this.Cursor = new Cursor(memoryStream);
            }

        }

        private void onClick(object sender, EventArgs e)
        {
            p.morir();        
        }
       

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {          
            foreach (Persona p in lista)
                p.huir(this.Size, e.Location);                 
        }

        private void timer1_Tick(object sender, EventArgs e)
        {            
            foreach (Persona p in lista)
                p.crecer();          
        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            lista.Add(new Persona().nacer(this, "Kappa"));           
        }
    }
}
