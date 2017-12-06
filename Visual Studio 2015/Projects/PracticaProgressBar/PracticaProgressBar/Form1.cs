using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PracticaProgressBar
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
    

        private void progressBar_Click(object sender, EventArgs e)
        {
            ((ProgressBar)sender).Value = ((MouseEventArgs)e).X * ((ProgressBar)sender).Maximum / ((ProgressBar)sender).Width + 1;
        }
    }
}
