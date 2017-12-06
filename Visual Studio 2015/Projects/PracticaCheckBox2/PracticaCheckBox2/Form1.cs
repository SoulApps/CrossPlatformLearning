using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PracticaCheckBox2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void checkBox_CheckedChanged(object sender, EventArgs e)
        {
            if (((CheckBox)sender).Checked)
            {
                foreach (Object control in this.Controls)
                {
                    if (control is CheckBox)                    
                        if (((Control)control).Location.X <= ((Control)sender).Location.X)
                            ((CheckBox)control).Checked = true;                                       
                }
            }
            else
            {
                foreach (Object control in this.Controls)
                {
                    if (control is CheckBox)
                    {
                        if (((Control)control).Location.X >= ((Control)sender).Location.X)
                            ((CheckBox)control).Checked = false;
                    }
                }
            }
        }
    }
}
