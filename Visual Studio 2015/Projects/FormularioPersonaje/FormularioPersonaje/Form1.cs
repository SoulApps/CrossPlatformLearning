using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace FormularioPersonaje
{
    public partial class Form1 : Form
    {
        private int tiradasDisponibles, movimientosCheckeados, numeroPokemon = -1;
        private ToolTip ttRandom;
        private Pokemon[] pokemon;
        private Pokemon actual;
        private CheckBox[] movimientos;
        private RadioButton[] objetos1;
        private RadioButton[] objetos2;
        private Album album;
        private string ruta = @"img\";

        public Form1()
        {
            InitializeComponent();
        }


        private void Form1_Load(object sender, EventArgs e)
        {
            //Cambia la ruta para buscar las imágenes si se ejecuta desde Visual Studio.
            if (Application.StartupPath.Split('\\')[Application.StartupPath.Split('\\').Length - 1] == "Debug")
                ruta = Application.StartupPath + @"\..\..\img\";


            //Crea el array de movimientos que se utilizará.
            movimientos = new CheckBox[10];
            movimientos[0] = checkBox1; movimientos[1] = checkBox2; movimientos[2] = checkBox3; movimientos[3] = checkBox4; movimientos[4] = checkBox5;
            movimientos[5] = checkBox6; movimientos[6] = checkBox7; movimientos[7] = checkBox8; movimientos[8] = checkBox9; movimientos[9] = checkBox10;

            //Crea los arrays de objetos que se utilizarán.
            objetos1 = new RadioButton[5];
            objetos1[0] = radioButton1; objetos1[1] = radioButton2; objetos1[2] = radioButton3; objetos1[3] = radioButton4; objetos1[4] = radioButton5;
            objetos2 = new RadioButton[5];
            objetos2[0] = objetos2[0] = radioButton6; objetos2[1] = radioButton7; objetos2[2] = radioButton8; objetos2[3] = radioButton9; objetos2[4] = radioButton10;

            //Creación de Pokémon.
            pokemon = new Pokemon[18];
            pokemon[0] = new Pokemon("Bulbasaur", Tipos.PLANTA); pokemon[1] = new Pokemon("Charmander", Tipos.FUEGO); pokemon[2] = new Pokemon("Squirtle", Tipos.AGUA);
            pokemon[3] = new Pokemon("Chikorita", Tipos.PLANTA); pokemon[4] = new Pokemon("Cyndaquil", Tipos.FUEGO); pokemon[5] = new Pokemon("Totodile", Tipos.AGUA);
            pokemon[6] = new Pokemon("Treecko", Tipos.PLANTA); pokemon[7] = new Pokemon("Torchic", Tipos.FUEGO); pokemon[8] = new Pokemon("Mudkip", Tipos.AGUA);
            pokemon[9] = new Pokemon("Turtwig", Tipos.PLANTA); pokemon[10] = new Pokemon("Chimchar", Tipos.FUEGO); pokemon[11] = new Pokemon("Piplup", Tipos.AGUA);
            pokemon[12] = new Pokemon("Snivy", Tipos.PLANTA); pokemon[13] = new Pokemon("Tepig", Tipos.FUEGO); pokemon[14] = new Pokemon("Oshawott", Tipos.AGUA);
            pokemon[15] = new Pokemon("Chespin", Tipos.PLANTA); pokemon[16] = new Pokemon("Fennekin", Tipos.FUEGO); pokemon[17] = new Pokemon("Froakie", Tipos.AGUA);

            

            album = new Album();
            ttRandom = new ToolTip();
            album.leerFichero(); //Leo el fichero por defecto.
            cargarPersonaje(album.recibir()); //Cargo el primer personaje.
            if (album.longitud() > 0) //Activo el botón siguiente si hay pesonajes.
                btnSiguiente.Enabled = true;         
        }

        //Escribe los datos del personaje que se pasa por argumentos en el formulario.
        private void cargarPersonaje(Personaje p)
        {
            int i, j = 0;

            btnSiguiente.Enabled = false;

            if (p != null) //Compruebo si existe el personaje.
            {
                resetearTodo(false); //Rreseteo los valores actuales del formulario.
                btnEliminar.Enabled = btnResetAll.Enabled = true;

                //Asigno los valores.
                txtNombre.Text = p.getNombre();
                if (p.getGenero())
                    rdbHombre.Checked = true;
                else
                    rdbMujer.Checked = true;


                if (p.getPokemon() != -1)
                {
                    actual = pokemon[p.getPokemon()];
                    imgPokemon.Image = Image.FromFile(ruta + actual.getNombre() + ".gif");
                }


                i = p.getEstadisticas().Length - 1;
                foreach (Object o in panelEstadisticas.Controls)
                {
                    if (o is NumericUpDown && i >= 0)
                    {
                        ((NumericUpDown)o).Enabled = true;
                        if (p.getPokemon() != -1)
                            ((NumericUpDown)o).Value = p.getEstadisticas()[i];
                        i--;
                    }
                }

                i = p.getValoresIndividuales().Length - 1;
                foreach (Object o in panelIV.Controls)
                {
                    if (o is ProgressBar && i >= 0)
                    {
                        ((ProgressBar)o).Value = p.getValoresIndividuales()[i];
                        i--;
                    }
                }
                lblVida.Text = pgVidaIV.Value.ToString();
                lblAtaque.Text = pgAtaqueIV.Value.ToString();
                lblDefensa.Text = pgDefensaIV.Value.ToString();
                lblAtEsp.Text = pgAtEspIV.Value.ToString();
                lblDefEsp.Text = pgDefEspIV.Value.ToString();
                lblVelocidad.Text = pgVelocidadIV.Value.ToString();

                if (tiradasDisponibles != 0)
                    imgRandom.Enabled = true;

                for (i = 0; i < movimientos.Length; i++)
                {
                    if (p.getPokemon() != -1)
                    {
                        movimientos[i].Visible = true;
                        movimientos[i].Text = actual.getMovimientos()[i].getNombre();
                    }
                    else
                        movimientos[i].Visible = false;
                }


                while (j < p.getMovimientos().Length)
                {
                    if (p.getMovimientos()[j] != -1)
                        movimientos[p.getMovimientos()[j]].Checked = true;
                    j++;
                }

                //Selecciona los objetos de la mochila que tiene el personaje.
                if (p.getObjetos()[0] != -1)
                    objetos1[p.getObjetos()[0]].Checked = true;
                if (p.getObjetos()[1] != -1)
                    objetos2[p.getObjetos()[1]].Checked = true;

                tiradasDisponibles = p.getTiradasDisponibles();
                if (tiradasDisponibles == 0)
                {
                    ttRandom.SetToolTip(imgRandom, "No te quedan tiradas");
                    btnAceptarRandom.Enabled = false;
                }
                else
                {
                    ttRandom.SetToolTip(imgRandom, "Oportunidades restantes: " + tiradasDisponibles);
                    btnAceptarRandom.Enabled = true;
                }

                //Activo los botones si se reúnen los requisitos.
                if (album.getIndice() < album.longitud())
                    btnSiguiente.Enabled = true;

                if (album.getIndice() > 0)
                    btnAtras.Enabled = true;

            }
            else  //Si no existe preparo el formulario para añadir un personaje nuevo.
                resetearTodo(true);
        }


        //Datos básicos

        //Cambia la imagen del personaje según su género.
        private void rdbGenero_CheckedChanged(object sender, EventArgs e)
        {
            imgPersona.Image = Image.FromFile(ruta + ((RadioButton)sender).Text + ".png");
        }

        //Cambia los datos del ComboBox con las especies de pokémon según la región.
        private void comboBoxRegión_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (((ComboBox)sender).SelectedIndex >= 0)
            {
                comboBoxEspecie.Enabled = true; //Activa el ComboBox de las especies.
                comboBoxEspecie.Items.Clear();  //Y lo limpia.

                //Se añaden los datos oportunos.
                switch (comboBoxRegion.SelectedItem.ToString())
                {
                    case "Kanto":
                        comboBoxEspecie.Items.Add(pokemon[0].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[1].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[2].getNombre());
                        break;

                    case "Johto":
                        comboBoxEspecie.Items.Add(pokemon[3].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[4].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[5].getNombre());
                        break;

                    case "Hoenn":
                        comboBoxEspecie.Items.Add(pokemon[6].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[7].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[8].getNombre());
                        break;

                    case "Sinnoh":
                        comboBoxEspecie.Items.Add(pokemon[9].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[10].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[11].getNombre());
                        break;

                    case "Teselia":
                        comboBoxEspecie.Items.Add(pokemon[12].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[13].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[14].getNombre());
                        break;

                    case "Kalos":
                        comboBoxEspecie.Items.Add(pokemon[15].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[16].getNombre());
                        comboBoxEspecie.Items.Add(pokemon[17].getNombre());
                        break;
                }              
            }
        }

        //Cambia la imágen del pokémon seleccionado.
        private void comboBoxEspecie_SelectedIndexChanged(object sender, EventArgs e)
        {
            int i;

            //Se comprueba.
            if (((ComboBox) sender).SelectedIndex >= 0) {
                for (i = 0; i < pokemon.Length; i++)
                {
                    if (pokemon[i].getNombre().Equals(comboBoxEspecie.SelectedItem.ToString()))
                    {
                        //Actualiza losvalores por defecto
                        numeroPokemon = i;
                        actual = pokemon[i];
                    }
                }
                imgPokemon.Image = Image.FromFile(ruta + actual.getNombre() + ".gif");
                for (i = 0; i < movimientos.Length; i++)
                {
                    //Muestra los movimientos del pokémon.
                    movimientos[i].Visible = true;
                    movimientos[i].Text = actual.getMovimientos()[i].toString();
                }

                //Activa todas las funcionaledades bloqueadas
                imgRandom.Enabled = true;
                foreach (Object o in panelEstadisticas.Controls)
                    if (o is NumericUpDown)
                        ((NumericUpDown)o).Enabled = true;

            }
            //Si no se selecciona algún personaje se pone la imágen a null.
            else
                imgPokemon.Image = null;
        }


      

        //Valores individuales

        //Da un valor aleatorio a los valores individuales.
        private void imgRandom_Click(object sender, EventArgs e)
        {
            Random rnd;
            btnAceptarRandom.Enabled = true;

            if (tiradasDisponibles > 0)
            {
                rnd = new Random();

                tiradasDisponibles--;
                ttRandom.SetToolTip(imgRandom, "Oportunidades restantes: " + tiradasDisponibles);

                pgVidaIV.Value = int.Parse(rnd.Next(pgVidaIV.Maximum).ToString());
                lblVida.Text = pgVidaIV.Value.ToString();

                pgAtaqueIV.Value = int.Parse(rnd.Next(pgAtaqueIV.Maximum).ToString());
                lblAtaque.Text = pgAtaqueIV.Value.ToString();

                pgDefensaIV.Value = int.Parse(rnd.Next(pgDefensaIV.Maximum).ToString());
                lblDefensa.Text = pgDefensaIV.Value.ToString();

                pgAtEspIV.Value = int.Parse(rnd.Next(pgAtEspIV.Maximum).ToString());
                lblAtEsp.Text = pgAtEspIV.Value.ToString();

                pgDefEspIV.Value = int.Parse(rnd.Next(pgDefEspIV.Maximum).ToString());
                lblDefEsp.Text = pgDefEspIV.Value.ToString();

                pgVelocidadIV.Value = int.Parse(rnd.Next(pgVelocidadIV.Maximum).ToString());
                lblVelocidad.Text = pgVelocidadIV.Value.ToString();

                imgRandom.Image = Image.FromFile(ruta + "Random2.png");
                timer.Interval = 300;
                timer.Enabled = true;
                timer.Start();                                                
            }

            if (tiradasDisponibles == 0)
            {
                btnAceptarRandom.Enabled = false;
                ttRandom.SetToolTip(imgRandom, "No te quedan tiradas");
            }    
        }

        //Temporizador para la animación del dado.
        private void timer_Tick(object sender, EventArgs e)
        {           
            imgRandom.Image = Image.FromFile(ruta + "Random1.png");
            timer.Stop();                                   
        }

        //Cambia a 0 las tiradas disponibles del jugador en el caso de que le guste una tirada.
        private void btnAceptarRandom_Click(object sender, EventArgs e)
        {
            tiradasDisponibles = 0;
            ttRandom.SetToolTip(imgRandom, "No te quedan tiradas");
            btnAceptarRandom.Enabled = false;
        }



        //Estadísticas

            //Actualiza los valores de las ProgressBar asociadas al NumericUpDown que activa este evento.
        private void nud_ValueChanged(object sender, EventArgs e)
        {
        
            //Condición que reduce en 1 el valor si pasa el límite.
            if ((nudVida.Value + nudAtaque.Value + nudDefensa.Value + nudAtEsp.Value + nudDefEsp.Value + nudVelocidad.Value) > pgTotal.Maximum)
                ((NumericUpDown)sender).Value--;

            //Asignaciones de los NumericUpDown a los ProgressBar correspondientes.
            pgVida.Value = int.Parse((nudVida.Value).ToString());
            pgAtaque.Value = int.Parse((nudAtaque.Value).ToString());
            pgDefensa.Value = int.Parse((nudDefensa.Value).ToString());
            pgAtEsp.Value = int.Parse((nudAtEsp.Value).ToString());
            pgDefEsp.Value = int.Parse((nudDefEsp.Value).ToString());
            pgVelocidad.Value = int.Parse((nudVelocidad.Value).ToString());

            //Calcula el total.
            pgTotal.Value = int.Parse((nudVida.Value + nudAtaque.Value + nudDefensa.Value + nudAtEsp.Value + nudDefEsp.Value + nudVelocidad.Value).ToString());
        }



        //Movimientos

        //Gestiona el número de movimientosque se pueden tener activados (4).
        private void checkBoxMovimientos_CheckedChanged(object sender, EventArgs e)
        {
            int i;
            movimientosCheckeados = 0;

            //Cuenta los movimientos checkeados.
            for (i = 0; i < movimientos.Length; i++)
                if (movimientos[i].Checked)
                    movimientosCheckeados++;         
            
            //Comprueba si junto con el que se checkea son menos de 4.
            if (((CheckBox)sender).Checked && movimientosCheckeados > 4)
                ((CheckBox)sender).Checked = false;

            //Y se desactiva el que se checkea si se pasa.
            if (!((CheckBox)sender).Checked)
                movimientosCheckeados--;

            //Si hay 4 movimientos checkeados, se bloquean los demás, y si siendo 4 checkeados se uncheckea 1, se activan.
            for (i = 0; i < movimientos.Length; i++)
            {
                if (movimientosCheckeados == 4)
                {
                    if (!movimientos[i].Checked)
                        movimientos[i].Enabled = false;
                }
                else
                    movimientos[i].Enabled = true;
            }
                
        }


        //Resets

        //Resetea las estadísticas.
        private void btnResetearEstadisticas_Click(object sender, EventArgs e)
        {
            resetearEstadisticas(false);
        }

        //Lo resea todo.
        private void btnResetAll_Click(object sender, EventArgs e)
        {
            resetearTodo(true);
            btnEliminar.Enabled = btnResetAll.Enabled = false;
        }



        //Estas funciones limpian el formulario.


        //El booleano indica si el personaje que se va a crear va a ser nuevo.
        private void resetearTodo(Boolean bloquear)
        {          
            resetearDatosBasicos();
            resetearEstadisticas(bloquear);
            resetearValoresIndividuales();
            resetearMovimientos();
            resetearMochila();
        }
 
        //Resetea los movimientos y los oculta.
        private void resetearMovimientos()
        {
            movimientosCheckeados = 0;

            for (int i = 0; i < movimientos.Length; i++)
            {
                movimientos[i].Visible = false;
                movimientos[i].Checked = false;
            }
        }
        
        //Resetea los valores básicos y cambia al valor por defecto las variables auxiliares.
        private void resetearDatosBasicos()
        {          
            imgPersona.Image = null;
            rdbMujer.Checked = true;
            comboBoxEspecie.Enabled = false;  

            imgPokemon.Image = null;
            imgPersona.Image = Image.FromFile(ruta + "M.png");

            foreach (Object o in panelDatosBasicos.Controls)
            {
                if (o is TextBox)
                    ((TextBox)o).Text = "";
                else if (o is ComboBox)
                    ((ComboBox)o).SelectedIndex = -1;
            }
        }
        
        //Resetea las estadísticas.
        private void resetearEstadisticas(Boolean bloquear)
        {
            foreach (Object o in panelEstadisticas.Controls)
            {
                if (o is NumericUpDown)
                {
                    ((NumericUpDown)o).Value = ((NumericUpDown)o).Minimum;
                    if (bloquear)
                        ((NumericUpDown)o).Enabled = false;
                }
            }
        }

        //Resetea los valores individuales.
        private void resetearValoresIndividuales()
        {
            tiradasDisponibles = 3;
            imgRandom.Enabled = false;
            ttRandom.SetToolTip(imgRandom, "Oportunidades restantes: " + tiradasDisponibles);
            btnAceptarRandom.Enabled = false;
            foreach (Object o in panelIV.Controls)
            {
                if (o is ProgressBar)
                    ((ProgressBar)o).Value = ((ProgressBar)o).Minimum;

                lblVida.Text = "0";
                lblAtaque.Text = "0";
                lblDefensa.Text = "0";
                lblAtEsp.Text = "0";
                lblDefEsp.Text = "0";
                lblVelocidad.Text = "0";
            }
        }

        //Resetea la mochila.
        private void resetearMochila()
        {
            for (int i = 0; i < 5; i++)            
                objetos1[i].Checked = objetos2[i].Checked = false;            
        }

        
        //Botonera

        //Recoge la información del formulario y crea un Personaje.
        private Personaje empaquetar()
        {
            int i, j = 0;
            //Variables que recogerán la información actual del personaje.
            int[] estadisticas = { (int)nudVida.Value, (int)nudAtaque.Value, (int)nudDefensa.Value, (int)nudAtEsp.Value, (int)nudDefEsp.Value, (int)nudVelocidad.Value };
            int[] valoresIndividuales = { (int)pgVidaIV.Value, (int)pgAtaqueIV.Value, (int)pgDefensaIV.Value, (int)pgAtEspIV.Value, (int)pgDefEspIV.Value, (int)pgVelocidadIV.Value };
            int[] movimientos = { -1, -1, -1, -1 }; // -1 si está vacío.
            int[] objetos = { -1, -1 };

            //Se le dan valores a las variables del personaje que se guardará.
            for (i = 0; i < this.movimientos.Length; i++)
            {
                if (this.movimientos[i].Checked)
                {
                    movimientos[j] = i;
                    j++;
                }
            }

            for (i = 0; i < 5; i++)
            {
                if (objetos1[i].Checked)
                    objetos[0] = i;
                if (objetos2[i].Checked)
                    objetos[1] = i;
            }

            return new Personaje(txtNombre.Text, rdbHombre.Checked, numeroPokemon, estadisticas, valoresIndividuales, movimientos, objetos, tiradasDisponibles);
        }

        //Modifica o agrega el personaje que se está viendo acutalmente solo si tiene nombre.
        private void guardarPersonaje()
        {
            if (txtNombre.Text != "")
            {
                if (album.longitud() == 0 || album.getIndice() == album.longitud())
                    album.agregar(empaquetar());
                else
                    album.cambiar(empaquetar());
            }
        }

        //Botones de cerrar y minimizar.

        //Cerrar.
        private void lblCerrar_Click(object sender, EventArgs e)
        {
            //Se guarda el personaje actual y se cierra.
            guardarPersonaje();
            album.guardarFichero();
            Close();
        }


        //Estos métodos cambian el color de fondo de los botones de cerrar y minimizar según la posición del ratón sobre ellos.

        //Cambios de color.

        private void lblCerrar_MouseEnter(object sender, EventArgs e)
        {
            lblCerrar.BackColor = Color.IndianRed;
        }

        private void lblCerrar_MouseLeave(object sender, EventArgs e)
        {
            lblCerrar.BackColor = Color.Transparent;
        }

        private void lblMinimizar_MouseEnter(object sender, EventArgs e)
        {
            lblMinimizar.BackColor = Color.LightBlue;
        }

        private void lblMinimizar_MouseLeave(object sender, EventArgs e)
        {
            lblMinimizar.BackColor = Color.Transparent;
        }

        //Minimizar.
        private void lblMinimizar_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }
    

        //Guarda la información actual del album en el archivo que quiera el usuario.
        private void exportar()
        {
            Stream myStream = null;
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            saveFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            saveFileDialog1.FilterIndex = 2;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if ((myStream = saveFileDialog1.OpenFile()) != null)
                {
                    string ruta = saveFileDialog1.FileName;
                    myStream.Close();
                    album.guardarFichero(ruta);
                }
            }
        }

        //Llama al método exportar del album.
        private void btnExportar_Click(object sender, EventArgs e)
        {
            guardarPersonaje();
            exportar();
        }

        //Llama al método eliminar del album.
        private void btnEliminar_Click(object sender, EventArgs e)
        {
            album.eliminar();
            if (album.longitud() != 0)
                cargarPersonaje(album.recibir());
            else
            {
                resetearTodo(true);
                btnEliminar.Enabled = btnResetAll.Enabled = false;
            }
        }

        //Importa un album desde un fichero .txt.
        private void btnImportar_Click(object sender, EventArgs e)
        {
            Stream myStream;
            OpenFileDialog openFileDialog1 = new OpenFileDialog();

            openFileDialog1.InitialDirectory = "c:\\";
            openFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            openFileDialog1.FilterIndex = 2;
            openFileDialog1.RestoreDirectory = true;

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    if ((myStream = openFileDialog1.OpenFile()) != null)
                    {                       
                        album.leerFichero(openFileDialog1.FileName);
                        cargarPersonaje(album.recibir());
                        myStream.Close();
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error: Could not read file from disk. Original error: " + ex.Message);
                }
            }        
        }

        //Activa el boton de siguiente, resetear y eliminar cuando se rellena.
        private void txtNombre_TextChanged(object sender, EventArgs e)
        {
            if (txtNombre.Text != "")
            {
                btnEliminar.Enabled = btnResetAll.Enabled = true;
                btnSiguiente.Enabled = true;
            }
            else
                btnSiguiente.Enabled = false;
        }

        //Si puede va hacia atrás y muestra al personaje correspondiente.
        private void btnAtras_Click(object sender, EventArgs e)
        {
            Personaje p;
            
            //Comprueba si puede ir hacia atrás.
            if (album.getIndice() > 0)
            {
                guardarPersonaje(); //Se guarda el personaje actual.
                album.indiceAtras();
                p = album.recibir();
                btnSiguiente.Enabled = true;
               
                if (p != null)
                {
                    cargarPersonaje(p); //Carga el personaje nuevo si existe.
                }
                else
                {
                    resetearTodo(false);
                }
            }


            //Activa o desactiva botones según corresponda.
            else
            {
                btnAtras.Enabled = false;
                resetearTodo(false);
            }

            if (album.getIndice() == 0)
            {
                btnAtras.Enabled = false;
            }
        }

        //Si puede va hacia delante y muestra al personaje correspondiente.
        private void btnSiguiente_Click(object sender, EventArgs e)
        {
            Personaje p;
            guardarPersonaje(); //Guarda el personaje actual.
            album.indiceSiguiente();

            //Comprueba si puede ir hacia delante.
            if (album.getIndice() <= (album.longitud() - 1))
            {
                p = album.recibir();
                btnAtras.Enabled = true;
                if (p != null)
                {
                    cargarPersonaje(p); //Muestra el personaje si no es nulo.
                }

                else
                {
                    resetearTodo(true);
                }
            }

            //Activa o desactiva botones según corresponda.
            else
            {
                btnEliminar.Enabled = btnResetAll.Enabled = false;
                btnAtras.Enabled = true;
                btnSiguiente.Enabled = false;
                resetearTodo(true);
            }

            if (album.getIndice() == album.longitud() - 1)
            {
                btnAtras.Enabled = true;
                btnSiguiente.Enabled = true;
            }
        }
    }
}
