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
    public partial class Carta : Form
    {
        private string nombre;
        private string tipo;
        private string img;
        private SqlDataReader datos;

        public Carta(string img)
        {
            this.img = img;
            InitializeComponent();

            //Recojo los datos de la carta que se quiere ver.
            BaseDatos.abrirConexion();
            datos = BaseDatos.buscarDatos("SELECT id_carta, tipo_carta FROM CARTA WHERE imagen = '" + img + "';");

            while (datos.Read())
            {
                nombre = datos[0].ToString();
                tipo = datos[1].ToString();
            }
                            
            BaseDatos.cerrarConexion();
        }

        private void Carta_Load(object sender, EventArgs e)
        {
            //Muestra los datos de la carta.
            lblNombre.Text = nombre;
            imgCarta.Image = Image.FromFile(@"img\" + img);
            imgTipo.Image = Image.FromFile(@"img\" + tipo + ".png");
        }
    }
}
