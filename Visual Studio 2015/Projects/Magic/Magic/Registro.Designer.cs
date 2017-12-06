namespace Magic
{
    partial class Registro
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Registro));
            this.lblUsuario = new System.Windows.Forms.Label();
            this.txtUsuario = new System.Windows.Forms.TextBox();
            this.txtContrasenha = new System.Windows.Forms.TextBox();
            this.txtRepetirContrasenha = new System.Windows.Forms.TextBox();
            this.lblContrasenha = new System.Windows.Forms.Label();
            this.lblRepetirContrasenha = new System.Windows.Forms.Label();
            this.btnRegistrarse = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.lblYaCuenta = new System.Windows.Forms.Label();
            this.btnIniciarSesion = new System.Windows.Forms.Button();
            this.lblError = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // lblUsuario
            // 
            this.lblUsuario.AutoSize = true;
            this.lblUsuario.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblUsuario.Location = new System.Drawing.Point(529, 30);
            this.lblUsuario.Name = "lblUsuario";
            this.lblUsuario.Size = new System.Drawing.Size(43, 13);
            this.lblUsuario.TabIndex = 0;
            this.lblUsuario.Text = "Usuario";
            // 
            // txtUsuario
            // 
            this.txtUsuario.Location = new System.Drawing.Point(530, 46);
            this.txtUsuario.MaxLength = 16;
            this.txtUsuario.Name = "txtUsuario";
            this.txtUsuario.Size = new System.Drawing.Size(126, 20);
            this.txtUsuario.TabIndex = 1;
            // 
            // txtContrasenha
            // 
            this.txtContrasenha.Location = new System.Drawing.Point(530, 85);
            this.txtContrasenha.MaxLength = 16;
            this.txtContrasenha.Name = "txtContrasenha";
            this.txtContrasenha.Size = new System.Drawing.Size(126, 20);
            this.txtContrasenha.TabIndex = 2;
            this.txtContrasenha.UseSystemPasswordChar = true;
            // 
            // txtRepetirContrasenha
            // 
            this.txtRepetirContrasenha.Location = new System.Drawing.Point(530, 124);
            this.txtRepetirContrasenha.MaxLength = 16;
            this.txtRepetirContrasenha.Name = "txtRepetirContrasenha";
            this.txtRepetirContrasenha.Size = new System.Drawing.Size(126, 20);
            this.txtRepetirContrasenha.TabIndex = 3;
            this.txtRepetirContrasenha.UseSystemPasswordChar = true;
            // 
            // lblContrasenha
            // 
            this.lblContrasenha.AutoSize = true;
            this.lblContrasenha.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblContrasenha.Location = new System.Drawing.Point(529, 69);
            this.lblContrasenha.Name = "lblContrasenha";
            this.lblContrasenha.Size = new System.Drawing.Size(61, 13);
            this.lblContrasenha.TabIndex = 4;
            this.lblContrasenha.Text = "Contraseña";
            // 
            // lblRepetirContrasenha
            // 
            this.lblRepetirContrasenha.AutoSize = true;
            this.lblRepetirContrasenha.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblRepetirContrasenha.Location = new System.Drawing.Point(527, 108);
            this.lblRepetirContrasenha.Name = "lblRepetirContrasenha";
            this.lblRepetirContrasenha.Size = new System.Drawing.Size(97, 13);
            this.lblRepetirContrasenha.TabIndex = 5;
            this.lblRepetirContrasenha.Text = "Repetir contraseña";
            // 
            // btnRegistrarse
            // 
            this.btnRegistrarse.Location = new System.Drawing.Point(530, 150);
            this.btnRegistrarse.Name = "btnRegistrarse";
            this.btnRegistrarse.Size = new System.Drawing.Size(125, 23);
            this.btnRegistrarse.TabIndex = 6;
            this.btnRegistrarse.Text = "Registrarse";
            this.btnRegistrarse.UseVisualStyleBackColor = true;
            this.btnRegistrarse.Click += new System.EventHandler(this.btnRegistrarse_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(0, 0);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(521, 315);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 8;
            this.pictureBox1.TabStop = false;
            // 
            // lblYaCuenta
            // 
            this.lblYaCuenta.AutoSize = true;
            this.lblYaCuenta.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblYaCuenta.Location = new System.Drawing.Point(532, 263);
            this.lblYaCuenta.Name = "lblYaCuenta";
            this.lblYaCuenta.Size = new System.Drawing.Size(120, 13);
            this.lblYaCuenta.TabIndex = 10;
            this.lblYaCuenta.Text = "¿Ya tienes una cuenta?";
            // 
            // btnIniciarSesion
            // 
            this.btnIniciarSesion.Location = new System.Drawing.Point(530, 278);
            this.btnIniciarSesion.Name = "btnIniciarSesion";
            this.btnIniciarSesion.Size = new System.Drawing.Size(126, 23);
            this.btnIniciarSesion.TabIndex = 9;
            this.btnIniciarSesion.Text = "Iniciar sesión";
            this.btnIniciarSesion.UseVisualStyleBackColor = true;
            this.btnIniciarSesion.Click += new System.EventHandler(this.btnIniciarSesion_Click);
            // 
            // lblError
            // 
            this.lblError.AutoSize = true;
            this.lblError.ForeColor = System.Drawing.Color.Red;
            this.lblError.Location = new System.Drawing.Point(532, 176);
            this.lblError.Name = "lblError";
            this.lblError.Size = new System.Drawing.Size(0, 13);
            this.lblError.TabIndex = 11;
            this.lblError.Visible = false;
            // 
            // Registro
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(668, 313);
            this.Controls.Add(this.lblError);
            this.Controls.Add(this.lblYaCuenta);
            this.Controls.Add(this.btnIniciarSesion);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnRegistrarse);
            this.Controls.Add(this.lblRepetirContrasenha);
            this.Controls.Add(this.lblContrasenha);
            this.Controls.Add(this.txtRepetirContrasenha);
            this.Controls.Add(this.txtContrasenha);
            this.Controls.Add(this.txtUsuario);
            this.Controls.Add(this.lblUsuario);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "Registro";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Registro";
            this.Load += new System.EventHandler(this.Registro_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblUsuario;
        private System.Windows.Forms.TextBox txtUsuario;
        private System.Windows.Forms.TextBox txtContrasenha;
        private System.Windows.Forms.TextBox txtRepetirContrasenha;
        private System.Windows.Forms.Label lblContrasenha;
        private System.Windows.Forms.Label lblRepetirContrasenha;
        private System.Windows.Forms.Button btnRegistrarse;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label lblYaCuenta;
        private System.Windows.Forms.Button btnIniciarSesion;
        private System.Windows.Forms.Label lblError;
    }
}