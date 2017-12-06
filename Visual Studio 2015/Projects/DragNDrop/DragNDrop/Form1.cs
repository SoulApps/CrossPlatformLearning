using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DragNDrop
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();



            listView1.Items.Add(new ListViewItem("aa"));
        }

        private void textBox1_MouseDown(object sender, MouseEventArgs e)
        {
            DoDragDrop(((TextBox)sender).Text, DragDropEffects.All);
        }


        private void textBox2_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = DragDropEffects.All;
        }

        private void textBox2_DragDrop(object sender, DragEventArgs e)
        {
            //textBox2.Text = textBox1.Text;
            textBox2.Text = (string) e.Data.GetData(DataFormats.Text);
        }


        //Igual que arriba
        private void listBox1_DragDrop(object sender, DragEventArgs e)
        {
            e.Effect = DragDropEffects.All;
        }

        private void listBox1_DragEnter(object sender, DragEventArgs e)
        {
            ((ListBox)sender).Items.Add((string)e.Data.GetData(DataFormats.Text));
        }

    

    
       


        private void listBox1_SelectedValueChanged(object sender, EventArgs e)
        {
            DoDragDrop(((ListBox)sender).Text, DragDropEffects.All);
        }






        private void listView1_DragDrop(object sender, DragEventArgs e)
        {          
            ((ListView)sender).Items.Add((string)e.Data.GetData(DataFormats.Text));      
        }

        private void listView1_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = DragDropEffects.All;
        }

        private void listView1_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e)
        {
            DoDragDrop(e.Item.Text, DragDropEffects.All);
        }

        private void archivoToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
    }
}
