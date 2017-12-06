using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;

namespace DragNDropListView
{
    public partial class Form1 : Form
    {
        private bool drag;
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_MouseDown(object sender, MouseEventArgs e)
        {
            DoDragDrop(((TextBox)sender).Text, DragDropEffects.All);
        }

        private void listView_DragEnter(object sender, DragEventArgs e)
        {
                if (e.Data.GetDataPresent(DataFormats.Text))
                    e.Effect = DragDropEffects.Copy;
                else
                    e.Effect = DragDropEffects.None;
            
        }

        private void listView_DragDrop(object sender, DragEventArgs e)
        {
            string typestring = "Type";
            string s = e.Data.GetData(typestring.GetType()).ToString();
            string orig_string = s;
            s = s.Substring(s.IndexOf(":") + 1).Trim();
            s = s.Substring(1, s.Length - 2);

            this.listView2.Items.Add(s);

            IEnumerator enumerator = listView1.Items.GetEnumerator();
            int whichIdx = -1;
            int idx = 0;
            while (enumerator.MoveNext())
            {
                string s2 = enumerator.Current.ToString();
                if (s2.Equals(orig_string))
                {
                    whichIdx = idx;
                    break;
                }
                idx++;
            }
            this.listView1.Items.RemoveAt(whichIdx);
        }

        private void listView_ItemDrag(object sender, ItemDragEventArgs e)
        {
            string s = e.Item.ToString();
            DoDragDrop(s, DragDropEffects.Copy | DragDropEffects.Move);
        }
    }
}
