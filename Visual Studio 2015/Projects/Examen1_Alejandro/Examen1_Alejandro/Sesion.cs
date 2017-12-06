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
    public partial class Sesion : Form
    {
        private string nombre;
        private bool esProfesor;

        public Sesion(string nombre, bool esProfesor)
        {
            InitializeComponent();
            this.nombre = nombre;
            this.esProfesor = esProfesor;
        }

        private void Sesion_Load(object sender, EventArgs e)
        {
            rellenarComboBoxFecha();

            //Gestino el menú strip.
            foreach (ToolStripMenuItem item in menuStrip.Items)
            {
                if (item.Name == "nombreDeUsuarioToolStripMenuItem")
                    item.Text = nombre;

                if (!esProfesor && item.Name == "vernotasToolStripMenuItem")
                    item.Visible = false;
            }
        }

        //Relleno el combobox de fechas.
        private void rellenarComboBoxFecha()
        {
            //Relleno el combobox.
            SqlDataReader datos;
            int i = 0;

            BaseDatos.abrirConexion();
           
            datos = BaseDatos.buscarDatos("SELECT DISTINCT fecha FROM Prueba ORDER BY 1 DESC;");

            while (datos.Read() && i == 0)
            {
                comboFecha.Items.Add(datos[0]);
                if (!esProfesor) //Si no es profesor solo mostrará una línea.
                    i++;
            }

            BaseDatos.cerrarConexion();

            comboFecha.SelectedItem = comboFecha.Items[0];
        }


        //Menú strip.
        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }





        private void lstPruebas_SelectedIndexChanged(object sender, EventArgs e)
        {
            new Calificacion(comboFecha.SelectedItem.ToString(), nombre, lstPruebas.SelectedItem.ToString(), esProfesor).ShowDialog();
        }

        private void comboFecha_SelectedIndexChanged(object sender, EventArgs e)
        {
            SqlDataReader datos;

            BaseDatos.abrirConexion();

            lstPruebas.Items.Clear();         

            datos = BaseDatos.buscarDatos("SELECT DISTINCT nombre FROM Prueba, evaluacion e WHERE alumno = nombre AND alumno != '" + nombre + "' AND e.fecha = '" + comboFecha.SelectedItem.ToString() + "';");
            while (datos.Read())
                lstPruebas.Items.Add(datos[0]);
                

            BaseDatos.cerrarConexion();
        }

        private void vernotasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Notas(nombre).Show();
        }

        private void acercaDeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Acerca().ShowDialog();
        }
    }
}
