using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PracticaComboBox
{
    public partial class Form1 : Form
    {
        ComboBox comboBox2;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            comboBox2 = new ComboBox();
            Controls.Add(comboBox2);
            comboBox2.Location = new Point(100, 100);
            comboBox2.Enabled = false;        
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int i;
            comboBox1.Items.Clear();
            for (i = 0; i < new Random().Next(10); i++)
                comboBox1.Items.Add(i);
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            int i;
            comboBox2.Enabled = true;
            comboBox2.Items.Clear();
            for (i = 0; i < 10; i++)
                comboBox2.Items.Add(comboBox1.SelectedItem + i.ToString());
        }
    }
}
