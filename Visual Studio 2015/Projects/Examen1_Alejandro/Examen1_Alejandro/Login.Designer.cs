namespace Examen1_Alejandro
{
    partial class Login
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblNombre = new System.Windows.Forms.Label();
            this.lblContrasenha = new System.Windows.Forms.Label();
            this.comboNombre = new System.Windows.Forms.ComboBox();
            this.btnEntrar = new System.Windows.Forms.Button();
            this.txtContrasenha = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(13, 13);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(44, 13);
            this.lblNombre.TabIndex = 0;
            this.lblNombre.Text = "Nombre";
            // 
            // lblContrasenha
            // 
            this.lblContrasenha.AutoSize = true;
            this.lblContrasenha.Location = new System.Drawing.Point(13, 44);
            this.lblContrasenha.Name = "lblContrasenha";
            this.lblContrasenha.Size = new System.Drawing.Size(61, 13);
            this.lblContrasenha.TabIndex = 1;
            this.lblContrasenha.Text = "Contraseña";
            // 
            // comboNombre
            // 
            this.comboNombre.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboNombre.FormattingEnabled = true;
            this.comboNombre.Location = new System.Drawing.Point(80, 10);
            this.comboNombre.Name = "comboNombre";
            this.comboNombre.Size = new System.Drawing.Size(121, 21);
            this.comboNombre.TabIndex = 4;
            // 
            // btnEntrar
            // 
            this.btnEntrar.Location = new System.Drawing.Point(80, 79);
            this.btnEntrar.Name = "btnEntrar";
            this.btnEntrar.Size = new System.Drawing.Size(75, 23);
            this.btnEntrar.TabIndex = 5;
            this.btnEntrar.Text = "Entrar";
            this.btnEntrar.UseVisualStyleBackColor = true;
            this.btnEntrar.Click += new System.EventHandler(this.btnEntrar_Click);
            // 
            // txtContrasenha
            // 
            this.txtContrasenha.Location = new System.Drawing.Point(80, 44);
            this.txtContrasenha.MaxLength = 16;
            this.txtContrasenha.Name = "txtContrasenha";
            this.txtContrasenha.Size = new System.Drawing.Size(121, 20);
            this.txtContrasenha.TabIndex = 6;
            this.txtContrasenha.UseSystemPasswordChar = true;
            this.txtContrasenha.Enter += new System.EventHandler(this.txtContrasenha_Enter);
            this.txtContrasenha.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtContrasenha_KeyPress);
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(213, 110);
            this.Controls.Add(this.txtContrasenha);
            this.Controls.Add(this.btnEntrar);
            this.Controls.Add(this.comboNombre);
            this.Controls.Add(this.lblContrasenha);
            this.Controls.Add(this.lblNombre);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Login";
            this.Text = "Login";
            this.Load += new System.EventHandler(this.Login_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblNombre;
        private System.Windows.Forms.Label lblContrasenha;
        private System.Windows.Forms.ComboBox comboNombre;
        private System.Windows.Forms.Button btnEntrar;
        private System.Windows.Forms.TextBox txtContrasenha;
    }
}

