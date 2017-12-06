namespace Examen1_Alejandro
{
    partial class Sesion
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip = new System.Windows.Forms.MenuStrip();
            this.nombreDeUsuarioToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.acercaDeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.vernotasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.salirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lblFecha = new System.Windows.Forms.Label();
            this.comboFecha = new System.Windows.Forms.ComboBox();
            this.lstPruebas = new System.Windows.Forms.ListBox();
            this.lblAlumno = new System.Windows.Forms.Label();
            this.lblEstrellas = new System.Windows.Forms.Label();
            this.menuStrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip
            // 
            this.menuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.nombreDeUsuarioToolStripMenuItem,
            this.acercaDeToolStripMenuItem,
            this.vernotasToolStripMenuItem,
            this.salirToolStripMenuItem});
            this.menuStrip.Location = new System.Drawing.Point(0, 0);
            this.menuStrip.Name = "menuStrip";
            this.menuStrip.Size = new System.Drawing.Size(328, 24);
            this.menuStrip.TabIndex = 0;
            this.menuStrip.Text = "menuStrip1";
            // 
            // nombreDeUsuarioToolStripMenuItem
            // 
            this.nombreDeUsuarioToolStripMenuItem.Name = "nombreDeUsuarioToolStripMenuItem";
            this.nombreDeUsuarioToolStripMenuItem.Size = new System.Drawing.Size(135, 20);
            this.nombreDeUsuarioToolStripMenuItem.Text = "<nombre de usuario>";
            // 
            // acercaDeToolStripMenuItem
            // 
            this.acercaDeToolStripMenuItem.Name = "acercaDeToolStripMenuItem";
            this.acercaDeToolStripMenuItem.Size = new System.Drawing.Size(71, 20);
            this.acercaDeToolStripMenuItem.Text = "&Acerca de";
            this.acercaDeToolStripMenuItem.Click += new System.EventHandler(this.acercaDeToolStripMenuItem_Click);
            // 
            // vernotasToolStripMenuItem
            // 
            this.vernotasToolStripMenuItem.Name = "vernotasToolStripMenuItem";
            this.vernotasToolStripMenuItem.Size = new System.Drawing.Size(67, 20);
            this.vernotasToolStripMenuItem.Text = "Ver &notas";
            this.vernotasToolStripMenuItem.Click += new System.EventHandler(this.vernotasToolStripMenuItem_Click);
            // 
            // salirToolStripMenuItem
            // 
            this.salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            this.salirToolStripMenuItem.Size = new System.Drawing.Size(41, 20);
            this.salirToolStripMenuItem.Text = "&Salir";
            this.salirToolStripMenuItem.Click += new System.EventHandler(this.salirToolStripMenuItem_Click);
            // 
            // lblFecha
            // 
            this.lblFecha.AutoSize = true;
            this.lblFecha.Location = new System.Drawing.Point(40, 41);
            this.lblFecha.Name = "lblFecha";
            this.lblFecha.Size = new System.Drawing.Size(73, 13);
            this.lblFecha.TabIndex = 1;
            this.lblFecha.Text = "Fecha prueba";
            // 
            // comboFecha
            // 
            this.comboFecha.FormattingEnabled = true;
            this.comboFecha.Location = new System.Drawing.Point(131, 38);
            this.comboFecha.Name = "comboFecha";
            this.comboFecha.Size = new System.Drawing.Size(166, 21);
            this.comboFecha.TabIndex = 2;
            this.comboFecha.Text = "Fecha";
            this.comboFecha.SelectedIndexChanged += new System.EventHandler(this.comboFecha_SelectedIndexChanged);
            // 
            // lstPruebas
            // 
            this.lstPruebas.FormattingEnabled = true;
            this.lstPruebas.Location = new System.Drawing.Point(12, 94);
            this.lstPruebas.Name = "lstPruebas";
            this.lstPruebas.Size = new System.Drawing.Size(304, 186);
            this.lstPruebas.TabIndex = 3;
            this.lstPruebas.SelectedIndexChanged += new System.EventHandler(this.lstPruebas_SelectedIndexChanged);
            // 
            // lblAlumno
            // 
            this.lblAlumno.AutoSize = true;
            this.lblAlumno.Location = new System.Drawing.Point(40, 78);
            this.lblAlumno.Name = "lblAlumno";
            this.lblAlumno.Size = new System.Drawing.Size(42, 13);
            this.lblAlumno.TabIndex = 4;
            this.lblAlumno.Text = "Alumno";
            // 
            // lblEstrellas
            // 
            this.lblEstrellas.AutoSize = true;
            this.lblEstrellas.Location = new System.Drawing.Point(221, 78);
            this.lblEstrellas.Name = "lblEstrellas";
            this.lblEstrellas.Size = new System.Drawing.Size(46, 13);
            this.lblEstrellas.TabIndex = 5;
            this.lblEstrellas.Text = "Estrellas";
            // 
            // Sesion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(328, 304);
            this.Controls.Add(this.lblEstrellas);
            this.Controls.Add(this.lblAlumno);
            this.Controls.Add(this.lstPruebas);
            this.Controls.Add(this.comboFecha);
            this.Controls.Add(this.lblFecha);
            this.Controls.Add(this.menuStrip);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.MainMenuStrip = this.menuStrip;
            this.Name = "Sesion";
            this.Text = "Sesion";
            this.Load += new System.EventHandler(this.Sesion_Load);
            this.menuStrip.ResumeLayout(false);
            this.menuStrip.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip;
        private System.Windows.Forms.ToolStripMenuItem nombreDeUsuarioToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem acercaDeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem vernotasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem salirToolStripMenuItem;
        private System.Windows.Forms.Label lblFecha;
        private System.Windows.Forms.ComboBox comboFecha;
        private System.Windows.Forms.ListBox lstPruebas;
        private System.Windows.Forms.Label lblAlumno;
        private System.Windows.Forms.Label lblEstrellas;
    }
}