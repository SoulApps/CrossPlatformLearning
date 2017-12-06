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
    public partial class Registro : Form
    {
        private Form login;
        public Registro(Form login)
        {
            this.login = login;
            InitializeComponent();
        }

        private void Registro_Load(object sender, EventArgs e)
        {

        }

        //Intenta registrar.
        private void btnRegistrarse_Click(object sender, EventArgs e)
        {
            int datos;

            BaseDatos.abrirConexion();
            datos = BaseDatos.contarFilas("SELECT COUNT(*) FROM USUARIO WHERE nombre_usuario = '" + txtUsuario.Text + "';");

            //Comprueba que el usuario tenga al menos 3 caracteres.
            if (txtUsuario.Text.Length >= 3)
            {
                //Comprueba que no existe. 
                if (datos == 0)
                {
                    //Comprueba que las contraseñas son idénticas.
                    if (txtContrasenha.Text == txtRepetirContrasenha.Text)
                    {
                        //Comprueba que la contraseña tenga al menos 3 caracteres.
                        if (txtContrasenha.Text.Length >= 3)
                        {
                            //Crea el usuario y muestra la sesión.
                            BaseDatos.insertar("INSERT INTO USUARIO VALUES(" + "'" + txtUsuario.Text + "', '" + txtContrasenha.Text + "');");
                            new Sesion(login, txtUsuario.Text).Show();
                            Close();
                        }
                        else
                        {
                            lblError.Text = "CONTRASEÑA DEBE\nTENER 3CARACTERES\nCOMO MÍNIMO";
                            lblError.Visible = true;
                        }

                    }
                    else
                    {
                        lblError.Text = "¡ERROR! CONTRASEÑAS\nNO COINCIDEN";
                        lblError.Visible = true;
                    }
                }
                else
                {
                    lblError.Text = "¡ERROR! USUARIO\nYA EXISTENTE";
                    lblError.Visible = true;
                }
            }
            else
            {
                lblError.Text = "USUARIO DEBE TENER\n3 CARACTERES COMO\nMÍNIMO";
                lblError.Visible = true;
            }

            BaseDatos.cerrarConexion();
        }

        //Muestra el formulario de iniciar sesión.
        private void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            Close();
            login.Show();
        }
    }
}
