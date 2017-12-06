using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Examen1_Alejandro
{
    public partial class Notas : Form
    {
        private string nombre;

        public Notas(string nombre)
        {
            InitializeComponent();
            this.nombre = nombre;
        }

        private void Notas_Load(object sender, EventArgs e)
        {
            foreach (ToolStripMenuItem item in menuStrip.Items)           
                if (item.Name == "nombreDeUsuarioToolStripMenuItem")
                    item.Text = nombre;

            rellenarComboBox();
        }

        private void rellenarComboBox()
        {
            //Relleno el combobox.
            SqlDataReader datos;

            BaseDatos.abrirConexion();

            datos = BaseDatos.buscarDatos("SELECT DISTINCT fecha FROM Prueba ORDER BY 1 DESC;");            

            BaseDatos.cerrarConexion();

            comboFecha.SelectedItem = comboFecha.Items[0];
        }

        private void acercaDeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Acerca().ShowDialog();
        }
    }
}
