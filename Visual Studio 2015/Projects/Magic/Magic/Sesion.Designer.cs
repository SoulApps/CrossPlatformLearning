namespace Magic
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Sesion));
            this.listaCartasTienda = new System.Windows.Forms.ImageList(this.components);
            this.lstTienda = new System.Windows.Forms.ListView();
            this.lstMisCartas = new System.Windows.Forms.ListView();
            this.listaMisCartas = new System.Windows.Forms.ImageList(this.components);
            this.menuStrip = new System.Windows.Forms.MenuStrip();
            this.sesiónToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cerrarSesiónToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.filtrosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.nORMALToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pLANTAToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.fUEGOToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aGUAToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tODOToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.eLÉCTRICOToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.lblNoEnPropiedad = new System.Windows.Forms.Label();
            this.EnPropiedad = new System.Windows.Forms.Label();
            this.menuContextualCarta = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.verCartaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip.SuspendLayout();
            this.menuContextualCarta.SuspendLayout();
            this.SuspendLayout();
            // 
            // listaCartasTienda
            // 
            this.listaCartasTienda.ColorDepth = System.Windows.Forms.ColorDepth.Depth32Bit;
            this.listaCartasTienda.ImageSize = new System.Drawing.Size(140, 140);
            this.listaCartasTienda.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // lstTienda
            // 
            this.lstTienda.AllowDrop = true;
            this.lstTienda.BackColor = System.Drawing.Color.AliceBlue;
            this.lstTienda.BackgroundImageTiled = true;
            this.lstTienda.Location = new System.Drawing.Point(12, 61);
            this.lstTienda.Name = "lstTienda";
            this.lstTienda.Size = new System.Drawing.Size(429, 439);
            this.lstTienda.TabIndex = 2;
            this.lstTienda.UseCompatibleStateImageBehavior = false;
            this.lstTienda.ItemDrag += new System.Windows.Forms.ItemDragEventHandler(this.listView_ItemDrag);
            this.lstTienda.SelectedIndexChanged += new System.EventHandler(this.listViewTienda_SelectedIndexChanged);
            this.lstTienda.DragDrop += new System.Windows.Forms.DragEventHandler(this.listView_DragDrop);
            this.lstTienda.DragEnter += new System.Windows.Forms.DragEventHandler(this.listView_DragEnter);
            this.lstTienda.MouseClick += new System.Windows.Forms.MouseEventHandler(this.listView_MouseClick);
            // 
            // lstMisCartas
            // 
            this.lstMisCartas.AllowDrop = true;
            this.lstMisCartas.BackColor = System.Drawing.Color.AliceBlue;
            this.lstMisCartas.BackgroundImageTiled = true;
            this.lstMisCartas.Location = new System.Drawing.Point(574, 61);
            this.lstMisCartas.Name = "lstMisCartas";
            this.lstMisCartas.Size = new System.Drawing.Size(429, 439);
            this.lstMisCartas.TabIndex = 3;
            this.lstMisCartas.UseCompatibleStateImageBehavior = false;
            this.lstMisCartas.ItemDrag += new System.Windows.Forms.ItemDragEventHandler(this.listView_ItemDrag);
            this.lstMisCartas.SelectedIndexChanged += new System.EventHandler(this.listViewMisCartas_SelectedIndexChanged);
            this.lstMisCartas.DragDrop += new System.Windows.Forms.DragEventHandler(this.listView_DragDrop);
            this.lstMisCartas.DragEnter += new System.Windows.Forms.DragEventHandler(this.listView_DragEnter);
            this.lstMisCartas.MouseClick += new System.Windows.Forms.MouseEventHandler(this.listView_MouseClick);
            // 
            // listaMisCartas
            // 
            this.listaMisCartas.ColorDepth = System.Windows.Forms.ColorDepth.Depth32Bit;
            this.listaMisCartas.ImageSize = new System.Drawing.Size(140, 140);
            this.listaMisCartas.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // menuStrip
            // 
            this.menuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.sesiónToolStripMenuItem,
            this.filtrosToolStripMenuItem});
            this.menuStrip.Location = new System.Drawing.Point(0, 0);
            this.menuStrip.Name = "menuStrip";
            this.menuStrip.Size = new System.Drawing.Size(1015, 24);
            this.menuStrip.TabIndex = 4;
            // 
            // sesiónToolStripMenuItem
            // 
            this.sesiónToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.cerrarSesiónToolStripMenuItem});
            this.sesiónToolStripMenuItem.Name = "sesiónToolStripMenuItem";
            this.sesiónToolStripMenuItem.Size = new System.Drawing.Size(53, 20);
            this.sesiónToolStripMenuItem.Text = "Sesión";
            // 
            // cerrarSesiónToolStripMenuItem
            // 
            this.cerrarSesiónToolStripMenuItem.Name = "cerrarSesiónToolStripMenuItem";
            this.cerrarSesiónToolStripMenuItem.Size = new System.Drawing.Size(142, 22);
            this.cerrarSesiónToolStripMenuItem.Text = "Cerrar sesión";
            this.cerrarSesiónToolStripMenuItem.Click += new System.EventHandler(this.cerrarSesiónToolStripMenuItem_Click);
            // 
            // filtrosToolStripMenuItem
            // 
            this.filtrosToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.nORMALToolStripMenuItem,
            this.pLANTAToolStripMenuItem,
            this.fUEGOToolStripMenuItem,
            this.aGUAToolStripMenuItem,
            this.tODOToolStripMenuItem,
            this.eLÉCTRICOToolStripMenuItem});
            this.filtrosToolStripMenuItem.Name = "filtrosToolStripMenuItem";
            this.filtrosToolStripMenuItem.Size = new System.Drawing.Size(51, 20);
            this.filtrosToolStripMenuItem.Text = "Filtros";
            // 
            // nORMALToolStripMenuItem
            // 
            this.nORMALToolStripMenuItem.Name = "nORMALToolStripMenuItem";
            this.nORMALToolStripMenuItem.Size = new System.Drawing.Size(134, 22);
            this.nORMALToolStripMenuItem.Text = "TODO";
            this.nORMALToolStripMenuItem.Click += new System.EventHandler(this.tipoToolStripMenuItem_Click);
            // 
            // pLANTAToolStripMenuItem
            // 
            this.pLANTAToolStripMenuItem.Name = "pLANTAToolStripMenuItem";
            this.pLANTAToolStripMenuItem.Size = new System.Drawing.Size(134, 22);
            this.pLANTAToolStripMenuItem.Text = "NORMAL";
            this.pLANTAToolStripMenuItem.Click += new System.EventHandler(this.tipoToolStripMenuItem_Click);
            // 
            // fUEGOToolStripMenuItem
            // 
            this.fUEGOToolStripMenuItem.Name = "fUEGOToolStripMenuItem";
            this.fUEGOToolStripMenuItem.Size = new System.Drawing.Size(134, 22);
            this.fUEGOToolStripMenuItem.Text = "PLANTA";
            this.fUEGOToolStripMenuItem.Click += new System.EventHandler(this.tipoToolStripMenuItem_Click);
            // 
            // aGUAToolStripMenuItem
            // 
            this.aGUAToolStripMenuItem.Name = "aGUAToolStripMenuItem";
            this.aGUAToolStripMenuItem.Size = new System.Drawing.Size(134, 22);
            this.aGUAToolStripMenuItem.Text = "FUEGO";
            this.aGUAToolStripMenuItem.Click += new System.EventHandler(this.tipoToolStripMenuItem_Click);
            // 
            // tODOToolStripMenuItem
            // 
            this.tODOToolStripMenuItem.Name = "tODOToolStripMenuItem";
            this.tODOToolStripMenuItem.Size = new System.Drawing.Size(134, 22);
            this.tODOToolStripMenuItem.Text = "AGUA";
            this.tODOToolStripMenuItem.Click += new System.EventHandler(this.tipoToolStripMenuItem_Click);
            // 
            // eLÉCTRICOToolStripMenuItem
            // 
            this.eLÉCTRICOToolStripMenuItem.Name = "eLÉCTRICOToolStripMenuItem";
            this.eLÉCTRICOToolStripMenuItem.Size = new System.Drawing.Size(134, 22);
            this.eLÉCTRICOToolStripMenuItem.Text = "ELÉCTRICO";
            this.eLÉCTRICOToolStripMenuItem.Click += new System.EventHandler(this.tipoToolStripMenuItem_Click);
            // 
            // lblNoEnPropiedad
            // 
            this.lblNoEnPropiedad.AutoSize = true;
            this.lblNoEnPropiedad.BackColor = System.Drawing.Color.Transparent;
            this.lblNoEnPropiedad.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNoEnPropiedad.ForeColor = System.Drawing.Color.Black;
            this.lblNoEnPropiedad.Location = new System.Drawing.Point(12, 33);
            this.lblNoEnPropiedad.Name = "lblNoEnPropiedad";
            this.lblNoEnPropiedad.Size = new System.Drawing.Size(171, 25);
            this.lblNoEnPropiedad.TabIndex = 5;
            this.lblNoEnPropiedad.Text = "No en propiedad";
            // 
            // EnPropiedad
            // 
            this.EnPropiedad.AutoSize = true;
            this.EnPropiedad.BackColor = System.Drawing.Color.Transparent;
            this.EnPropiedad.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.EnPropiedad.ForeColor = System.Drawing.Color.Black;
            this.EnPropiedad.Location = new System.Drawing.Point(569, 33);
            this.EnPropiedad.Name = "EnPropiedad";
            this.EnPropiedad.Size = new System.Drawing.Size(140, 25);
            this.EnPropiedad.TabIndex = 6;
            this.EnPropiedad.Text = "En propiedad";
            // 
            // menuContextualCarta
            // 
            this.menuContextualCarta.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.verCartaToolStripMenuItem});
            this.menuContextualCarta.Name = "menuContextualCarta";
            this.menuContextualCarta.Size = new System.Drawing.Size(120, 26);
            // 
            // verCartaToolStripMenuItem
            // 
            this.verCartaToolStripMenuItem.Name = "verCartaToolStripMenuItem";
            this.verCartaToolStripMenuItem.Size = new System.Drawing.Size(119, 22);
            this.verCartaToolStripMenuItem.Text = "Ver carta";
            this.verCartaToolStripMenuItem.Click += new System.EventHandler(this.verCartaToolStripMenuItem_Click);
            // 
            // Sesion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DimGray;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1015, 512);
            this.Controls.Add(this.EnPropiedad);
            this.Controls.Add(this.lblNoEnPropiedad);
            this.Controls.Add(this.lstMisCartas);
            this.Controls.Add(this.lstTienda);
            this.Controls.Add(this.menuStrip);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip;
            this.MaximizeBox = false;
            this.Name = "Sesion";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Pokémon TCG";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Sesion_FormClosed);
            this.Load += new System.EventHandler(this.Sesion_Load);
            this.menuStrip.ResumeLayout(false);
            this.menuStrip.PerformLayout();
            this.menuContextualCarta.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.ImageList listaCartasTienda;
        private System.Windows.Forms.ListView lstTienda;
        private System.Windows.Forms.ListView lstMisCartas;
        private System.Windows.Forms.ImageList listaMisCartas;
        private System.Windows.Forms.MenuStrip menuStrip;
        private System.Windows.Forms.ToolStripMenuItem sesiónToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cerrarSesiónToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem filtrosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem nORMALToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem pLANTAToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem fUEGOToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem aGUAToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tODOToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem eLÉCTRICOToolStripMenuItem;
        private System.Windows.Forms.Label lblNoEnPropiedad;
        private System.Windows.Forms.Label EnPropiedad;
        private System.Windows.Forms.ContextMenuStrip menuContextualCarta;
        private System.Windows.Forms.ToolStripMenuItem verCartaToolStripMenuItem;
    }
}