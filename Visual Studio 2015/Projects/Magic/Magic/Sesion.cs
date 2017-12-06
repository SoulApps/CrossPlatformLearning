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
using System.Collections;

namespace Magic
{
    public partial class Sesion : Form
    {
        private Form login;
        private string usuario;
        private string tipo = "TODO";
        private string cartaAux;

        public Sesion(Form login, string usuario)
        {
            this.login = login;
            this.usuario = usuario;
            InitializeComponent();            
        }

        private void Sesion_Load(object sender, EventArgs e)
        {
            //Pongo un fondo aleatorio.
            int n = new Random().Next(6);
            BackgroundImage = Image.FromFile(@"img\fondo" + n + ".jpg");

            //Muestro las cartas.
            actualizarListViews();
        }

        //Abre el login al cerrar.
        private void Sesion_FormClosed(object sender, FormClosedEventArgs e)
        {
            login.Show();
        }

        //Actualizo los listviews de las cartas.
        private void actualizarListViews()
        {
            SqlDataReader datos;

            int i = 0;

            
            lstTienda.Items.Clear();
            listaCartasTienda.Images.Clear();

            BaseDatos.abrirConexion();
            lstTienda.LargeImageList = listaCartasTienda;
            if (tipo == "TODO")
                datos = BaseDatos.buscarDatos("SELECT imagen FROM CARTA WHERE id_carta NOT IN(SELECT id_carta FROM COLECCION WHERE nombre_usuario = '" + usuario + "');");
            else 
                datos = BaseDatos.buscarDatos("SELECT imagen FROM CARTA WHERE id_carta NOT IN(SELECT id_carta FROM COLECCION WHERE nombre_usuario = '" + usuario + "') AND tipo_carta = '" + tipo + "';");

            while (datos.Read())
            {
                ListViewItem item = new ListViewItem();
                listaCartasTienda.Images.Add(Image.FromFile(@"img\" + datos[0]));
                item.ImageIndex = i;
                item.Tag = datos[0];
                lstTienda.Items.Add(item);
                i++;
            }
            BaseDatos.cerrarConexion();


            i = 0;
            lstMisCartas.Items.Clear();
            listaMisCartas.Images.Clear();

            BaseDatos.abrirConexion();
            lstMisCartas.LargeImageList = listaMisCartas;
            if (tipo == "TODO")
                datos = BaseDatos.buscarDatos("SELECT imagen FROM CARTA WHERE id_carta IN(SELECT id_carta FROM COLECCION WHERE nombre_usuario = '" + usuario + "')");
            else
                datos = BaseDatos.buscarDatos("SELECT imagen FROM CARTA WHERE id_carta IN(SELECT id_carta FROM COLECCION WHERE nombre_usuario = '" + usuario + "') AND tipo_carta = '" + tipo + "';");

            while (datos.Read())
            {
                ListViewItem item = new ListViewItem();
                listaMisCartas.Images.Add(Image.FromFile(@"img\" + datos[0]));
                item.ImageIndex = i;
                item.Tag = datos[0];
                lstMisCartas.Items.Add(item);
                i++;
            }

            BaseDatos.cerrarConexion();
        }

        //Cambia la selección del otro listview.
        private void listViewTienda_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstTienda.SelectedItems.Count > 0)
            {
                cartaAux = lstTienda.SelectedItems[0].Tag.ToString();
                foreach (ListViewItem i in lstMisCartas.Items)
                    i.Selected = false;
            }     
        }

        //Cambia la selección del otro listview.
        private void listViewMisCartas_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstMisCartas.SelectedItems.Count > 0)
            {
                cartaAux = lstMisCartas.SelectedItems[0].Tag.ToString();
                foreach (ListViewItem i in lstTienda.Items)
                    i.Selected = false;
            }
        }

        //Cambia el tipo del filtro de las cartas que se quieren ver.
        private void tipoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            tipo = ((ToolStripMenuItem)sender).Text;
            actualizarListViews();
        }


        //Drag 'n' Drop.

        private void listView_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = DragDropEffects.All;
        }

        private void listView_DragDrop(object sender, DragEventArgs e)
        {
            BaseDatos.abrirConexion();

            cartaAux = cartaAux.Split('.')[0];
            //Insert o delete correspondiente según el listview.
            if (((ListView)sender).Name == lstMisCartas.Name)
                BaseDatos.insertar("INSERT INTO COLECCION VALUES('" + usuario + "', '" + cartaAux + "')");
            else
                BaseDatos.insertar("DELETE FROM COLECCION WHERE nombre_usuario = '" + usuario + "' AND id_carta = '" + cartaAux + "'");
         
            BaseDatos.cerrarConexion();

            actualizarListViews();
        }

        private void listView_ItemDrag(object sender, ItemDragEventArgs e)
        {        
            cartaAux = ((ListView)sender).SelectedItems[0].Tag.ToString();
            DoDragDrop(((ListView)sender).SelectedItems[0], DragDropEffects.All);
        }


        //Opción de cerrar del menú.
        private void cerrarSesiónToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }

        //Menú contextual de las cartas.
        private void listView_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                if (((ListView) sender).FocusedItem.Bounds.Contains(e.Location) == true)
                {
                    menuContextualCarta.Show(Cursor.Position);
                }
            }
        }

        //Opción de ver la carta del menú contextual de las cartas.
        private void verCartaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Carta(cartaAux).Show();
        }     
    }
}
