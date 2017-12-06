using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PersonajeFicheros
{
    public partial class Form1 : Form
    {
        Album album;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            album = new Album();
            label3.Text = album.getIndice().ToString();
            label4.Text = album.longitud().ToString();

            if (album.recibir() != null)
            {
                txtNombre.Text = album.recibir().getNombre();
                txtEdad.Text = album.recibir().getEdad().ToString();
                btnPalante.Enabled = true;
                btnAgregar.Enabled = false;
                btnGuardar.Enabled = true;
            }
        }

        private void btnAgregar_Click(object sender, EventArgs e)
        {
            if (!txtNombre.Text.ToString().Equals("") && !txtEdad.Text.ToString().Equals(""))
            {
                album.agregar(new Personaje(txtNombre.Text.ToString(), int.Parse(txtEdad.Text.ToString())));
                album.indicePalante();
                label4.Text = album.longitud().ToString();
                label3.Text = album.getIndice().ToString();
                btnPatras.Enabled = true;
                btnInicio.Enabled = true;
                txtNombre.Text = "";
                txtEdad.Text = "";
            }
        }

        private void btnPatras_Click(object sender, EventArgs e)
        {
            Personaje p;

            if (album.getIndice() > 0)
            {
                album.indicePatras();
                p = album.recibir();
                btnPalante.Enabled = true;
                btnFin.Enabled = true;
                if (p != null)
                {
                    btnGuardar.Enabled = true;
                    btnAgregar.Enabled = false;
                    txtNombre.Text = p.getNombre();
                    txtEdad.Text = p.getEdad().ToString();

                    if (album.getIndice() == 0)
                    {
                        btnPatras.Enabled = false;
                        btnInicio.Enabled = false;
                    }

                }
                else
                {
                    btnGuardar.Enabled = false;
                    btnAgregar.Enabled = true;
                    txtNombre.Text = "";
                    txtEdad.Text = "";
                }
            }
            else
            {
                btnInicio.Enabled = false;
                btnPatras.Enabled = false;
                txtNombre.Text = "";
                txtEdad.Text = "";
            }
            label3.Text = album.getIndice().ToString();
        }

        private void btnPalante_Click(object sender, EventArgs e)
        {
            Personaje p;
            album.indicePalante();

            if (album.getIndice() <= (album.longitud() - 1))
            {
                p = album.recibir();
                btnPatras.Enabled = true;
                btnInicio.Enabled = true;
                if (p != null)
                {
                    btnGuardar.Enabled = true;
                    btnAgregar.Enabled = false;
                    txtNombre.Text = p.getNombre();
                    txtEdad.Text = p.getEdad().ToString();

                }

                else
                {
                    btnAgregar.Enabled = true;
                    btnGuardar.Enabled = false;
                    txtNombre.Text = "";
                    txtEdad.Text = "";
                }
            }

            else
            {
                btnGuardar.Enabled = false;
                btnAgregar.Enabled = true;
                btnPatras.Enabled = true;
                btnFin.Enabled = false;
                btnPalante.Enabled = false;
                txtNombre.Text = "";
                txtEdad.Text = "";
            }

            if (album.getIndice() == album.longitud() - 1)
            {
                btnPatras.Enabled = true;
                btnPalante.Enabled = true;
                btnFin.Enabled = true;
            }

            label3.Text = album.getIndice().ToString();
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            Personaje p = album.recibir();
            p.setNombre(txtNombre.Text.ToString());
            p.setEdad(int.Parse(txtEdad.Text.ToString()));
            album.guardarFichero();
        }

        private void btnInicio_Click(object sender, EventArgs e)
        {
            Personaje p;
            album.indiceInicio();
            label3.Text = album.getIndice().ToString();
            p = album.recibir();
            if (p != null)
            {
                btnAgregar.Enabled = false;
                btnGuardar.Enabled = true;
                txtNombre.Text = p.getNombre();
                txtEdad.Text = p.getEdad().ToString();
            }
            else
            {
                btnAgregar.Enabled = true;
                btnGuardar.Enabled = false;
            }

            btnPalante.Enabled = true;
            btnFin.Enabled = true;
            btnInicio.Enabled = false;
            btnPatras.Enabled = false;
        }

        private void btnFin_Click(object sender, EventArgs e)
        {
            Personaje p;
            album.indiceFin();
            label3.Text = album.getIndice().ToString();
            p = album.recibir();
            if (p != null)
            {
                btnAgregar.Enabled = false;
                btnGuardar.Enabled = true;
                txtNombre.Text = p.getNombre();
                txtEdad.Text = p.getEdad().ToString();
            }
            else
            {
                btnAgregar.Enabled = true;
                btnGuardar.Enabled = false;
            }
            btnPalante.Enabled = false;
            btnFin.Enabled = false;
            btnInicio.Enabled = true;
            btnPatras.Enabled = true;
        }
    }
}

