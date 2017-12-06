using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PracticaProgressBar3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        private void progressBar_Click(object sender, EventArgs e)
        {
            int tocar = ((MouseEventArgs)e).X * ((ProgressBar)sender).Maximum / ((ProgressBar)sender).Width + 1;
            if (tocar <= (((ProgressBar)sender).Value))
            {
                if (((ProgressBar)sender).Value - 10 >= ((ProgressBar)sender).Minimum)
                    ((ProgressBar)sender).Value -= 10;
            }
            else
            {
                if (((ProgressBar)sender).Value + 10 <= ((ProgressBar)sender).Maximum)
                    ((ProgressBar)sender).Value += 10;
            }
        }
    }
}
