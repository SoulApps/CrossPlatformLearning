using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PracticaRadioButton2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        private void radioButton_Click(object sender, EventArgs e)
        {
            foreach (GroupBox control in this.Controls)
            {
                foreach (RadioButton r in control.Controls)
                    if (control.Location.X < ((RadioButton)sender).Parent.Location.X)
                        r.Checked = true;
            }


            foreach (GroupBox control in this.Controls)
            {
                foreach (RadioButton r in control.Controls)
                    if (control.Location.X > ((RadioButton)sender).Parent.Location.X)                      
                            r.Checked = false;
            }
        }
    }
}
