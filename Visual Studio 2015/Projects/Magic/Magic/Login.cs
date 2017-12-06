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

namespace Magic
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void Login_Load(object sender, EventArgs e)
        {

        }

        private void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            iniciarSesion();
        }

        //Iniciar sesión al pulsar enter en la contraseña.
        private void txtContrasenha_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (txtUsuario.Text.Length >= 3 && txtContrasenha.Text.Length >= 3)
                if ((int)e.KeyChar == (int)Keys.Enter)
                    iniciarSesion();
        }

        //Intenta iniciar sesión.
        private void iniciarSesion()
        {
            int datos;

            BaseDatos.abrirConexion();
            datos = BaseDatos.contarFilas("SELECT COUNT(*) FROM USUARIO WHERE nombre_usuario = '" + txtUsuario.Text + "' AND contrasenha = '" + txtContrasenha.Text + "';");
            BaseDatos.cerrarConexion();

            //Si existe, se muestra el formulario de la sesión y se esconde y resetea este.
            if (datos == 1)
            {
                new Sesion(this, txtUsuario.Text).Show();
                txtUsuario.Text = txtContrasenha.Text = "";
                lblError.Visible = false;
                txtUsuario.Focus();
                Hide();
            }
            //Si no, muesta un mensaje de error.
            else
                lblError.Visible = true;

        }

        //Muestra el formulario de registrarse y esconde este.
        private void btnRegistrarse_Click(object sender, EventArgs e)
        {
            new Registro(this).Show();
            Hide();
        }
    }
}
