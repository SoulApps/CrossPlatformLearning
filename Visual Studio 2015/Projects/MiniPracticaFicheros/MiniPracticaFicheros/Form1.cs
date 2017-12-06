using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace MiniPracticaFicheros
{
    public partial class Form1 : Form
    {
        StreamReader r;
        StreamWriter w;
        String s;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {                   
            leer();
        }

        private void button1_Click(object sender, EventArgs e)
        {        
            escribir(textBox1.Text);
            textBox1.Text = "";          
        }


        private void leer()
        {
            r = new StreamReader(Application.StartupPath + "/Razas.txt", Encoding.Default);

            while ((s = r.ReadLine()) != null)
                comboBox1.Items.Add(s);

            r.Close();
        }

        private void escribir(string s)
        {
            w = new StreamWriter(Application.StartupPath + "/Razas.txt", true);
            comboBox1.Items.Add(s);
            w.WriteLine(s);
            w.Close();
        }
    }
}
