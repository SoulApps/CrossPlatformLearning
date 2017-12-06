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
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void Login_Load(object sender, EventArgs e)
        {
            rellenarComboBoxUsuario();
        }

        //Rellena el combobox de usuarios.
        private void rellenarComboBoxUsuario()
        {
            //Relleno el combobox.
            SqlDataReader datos;

            BaseDatos.abrirConexion();

            datos = BaseDatos.buscarDatos("SELECT nombre FROM Usuario;");

            while (datos.Read())
                comboNombre.Items.Add(datos[0]);

            BaseDatos.cerrarConexion();
        }

        private void btnEntrar_Click(object sender, EventArgs e)
        {
            iniciarSesion();
        }

        private void iniciarSesion()
        {
            int datos;
            bool esProfesor = false;

            BaseDatos.abrirConexion();
            datos = BaseDatos.contarFilas("SELECT COUNT(*) FROM Usuario WHERE nombre = '" + comboNombre.SelectedItem.ToString() + "' AND contra = '" + txtContrasenha.Text + "';");           

            if (datos == 1)
            {
                SqlDataReader reader = BaseDatos.buscarDatos("SELECT tipo FROM Usuario WHERE nombre = '" + comboNombre.SelectedItem.ToString() + "';");
                reader.Read();

                //Compruebo si es un profesor.
                
                if (reader[0].ToString() == "p")
                    esProfesor = true;

                new Sesion(comboNombre.Text, esProfesor).Show();
                Hide();
            }

            BaseDatos.cerrarConexion();
        }

        //Entrar con enter.
        private void txtContrasenha_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((int)e.KeyChar == (int)Keys.Enter)
                iniciarSesion();
        }

       
        //Cuando gana el foco se borra el texto.
        private void txtContrasenha_Enter(object sender, EventArgs e)
        {
            txtContrasenha.Text = "";
        }
    }
}
