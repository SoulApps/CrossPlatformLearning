namespace Magic
{
    partial class Carta
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Carta));
            this.imgCarta = new System.Windows.Forms.PictureBox();
            this.lblNombre = new System.Windows.Forms.Label();
            this.imgTipo = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.imgCarta)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.imgTipo)).BeginInit();
            this.SuspendLayout();
            // 
            // imgCarta
            // 
            this.imgCarta.Location = new System.Drawing.Point(12, 58);
            this.imgCarta.Name = "imgCarta";
            this.imgCarta.Size = new System.Drawing.Size(220, 357);
            this.imgCarta.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.imgCarta.TabIndex = 0;
            this.imgCarta.TabStop = false;
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Font = new System.Drawing.Font("Segoe Script", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNombre.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblNombre.Location = new System.Drawing.Point(4, 9);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(180, 46);
            this.lblNombre.TabIndex = 1;
            this.lblNombre.Text = "Charizard";
            // 
            // imgTipo
            // 
            this.imgTipo.Location = new System.Drawing.Point(205, 24);
            this.imgTipo.Name = "imgTipo";
            this.imgTipo.Size = new System.Drawing.Size(27, 28);
            this.imgTipo.TabIndex = 2;
            this.imgTipo.TabStop = false;
            // 
            // Carta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(244, 427);
            this.Controls.Add(this.imgTipo);
            this.Controls.Add(this.lblNombre);
            this.Controls.Add(this.imgCarta);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Carta";
            this.Text = "Carta";
            this.Load += new System.EventHandler(this.Carta_Load);
            ((System.ComponentModel.ISupportInitialize)(this.imgCarta)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.imgTipo)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox imgCarta;
        private System.Windows.Forms.Label lblNombre;
        private System.Windows.Forms.PictureBox imgTipo;
    }
}