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
    public partial class Calificacion : Form
    {
        private string fecha;
        private string nombreUsuario;
        private string nombreAlumno;
        private bool esProfesor;

        private Image imagen;
        private string tag;

        public Calificacion(string fecha, string nombreUsuario, string nombreAlumno, bool esProfesor)
        {
            InitializeComponent();
            this.fecha = fecha;
            this.nombreUsuario = nombreUsuario;
            this.nombreAlumno = nombreAlumno;
            this.esProfesor = esProfesor;
        }

        private void Calificacion_Load(object sender, EventArgs e)
        {
            System.IO.StreamReader f = new System.IO.StreamReader("parametros.txt");
            string[] parametros;
            string s;
            int para;
            SqlDataReader datos;

          


            lblAlumno.Text = nombreAlumno;

            //Gestiono el menú strip.
            foreach (ToolStripMenuItem item in menuStrip.Items)
            {
                if (item.Name == "nombreDeUsuarioToolStripMenuItem")
                    item.Text = nombreUsuario;

                if (!esProfesor && item.Name == "vernotasToolStripMenuItem")
                    item.Visible = false;
            }


            //Escribo los parámetros.
            if ((s = f.ReadLine()) != null)
            {
                parametros = s.Split('#');
                para = parametros.Length;

                param1.Text = parametros[0];
                param2.Text = parametros[1];
                param3.Text = parametros[2];
                param4.Text = parametros[3];
                param5.Text = parametros[4];
            }

            //Leo y escribo las puntuaciones.
            BaseDatos.abrirConexion();
            datos = BaseDatos.buscarDatos("SELECT p1, p2, p3, p4, p5 FROM evaluacion WHERE alumno = '" + nombreAlumno + "' AND fecha = '" + fecha + "' AND usuario = '" + nombreUsuario + "';");
            if (datos.Read())
            {
                p1.BackgroundImage = Image.FromFile(datos[0].ToString() == "" ? "0.png" : datos[0].ToString() + ".png");
                p2.BackgroundImage = Image.FromFile(datos[1].ToString() == "" ? "0.png" : datos[1].ToString() + ".png");
                p3.BackgroundImage = Image.FromFile(datos[2].ToString() == "" ? "0.png" : datos[2].ToString() + ".png");
                p4.BackgroundImage = Image.FromFile(datos[3].ToString() == "" ? "0.png" : datos[3].ToString() + ".png");
                p5.BackgroundImage = Image.FromFile(datos[4].ToString() == "" ? "0.png" : datos[4].ToString() + ".png");
            }

            BaseDatos.cerrarConexion();
        }

        //Menú strip.
        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void estrellasParam_DragDrop(object sender, DragEventArgs e)
        {
            int i;
            ((Panel)sender).BackgroundImage = imagen;

            //Insert
            BaseDatos.abrirConexion();

            //Si ese profesor no le ha corregido antes le creo su fila.
            i = BaseDatos.contarFilas("SELECT COUNT(*) FROM evaluacion WHERE fecha = '" + fecha + "' AND alumno = '" + nombreAlumno + "' AND usuario = '" + nombreUsuario + "';");
            if (i == 0)
                BaseDatos.insertar("INSERT INTO evaluacion(fecha, usuario, alumno) VALUES ('" + fecha + "', '" + nombreUsuario + "', '" + nombreAlumno + "');");

            BaseDatos.insertar("UPDATE evaluacion SET " + ((Panel)sender).Name + " = '" + int.Parse(tag) + "' WHERE fecha = '" + fecha + "' AND usuario = '" + nombreUsuario + "' AND alumno = '" + nombreAlumno + "';");

            BaseDatos.cerrarConexion();
        }

        private void estrellas_MouseDown(object sender, MouseEventArgs e)
        {
            imagen = ((Panel)sender).BackgroundImage;
            tag = ((Panel)sender).Tag.ToString();
            DoDragDrop(imagen, DragDropEffects.All);
        }

        private void estrellas_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = DragDropEffects.All;            
        }

        private void vernotasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Notas(nombreUsuario).Show();
        }

        private void acercaDeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Acerca().ShowDialog();
        }
    }
}
