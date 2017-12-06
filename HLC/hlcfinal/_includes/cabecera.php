<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-card-2" id="myNavbar">
    <a href="pcontrol.php"><img src="_img/icono.jpg" alt="Logo" class="w3-bar-item w3-button w3-wide" height="42" width="42"></img></a>
    <!-- Right-sided navbar links -->
    <div class="w3-right w3-hide-small">
      <a href="pcontrol.php" class="w3-bar-item w3-button">INICIO</a>
      <a href="pcontrol_mis_hilos.php" class="w3-bar-item w3-button">MIS HILOS</a>
      <a href="pcontrol_crear_hilo.php" class="w3-bar-item w3-button">CREAR HILO</a>
      <a href="logout.php" class="w3-bar-item w3-button">CERRAR SESIÓN</a>
    </div>
    <!-- Hide right-floated links on small screens and replace them with a menu icon -->
    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="w3_open()">
      <i class="fa fa-bars w3-padding-right w3-padding-left"></i>
    </a>
  </div>
</div>

<!-- Sidenav on small screens when clicking the menu icon -->
<nav class="w3-sidenav w3-black w3-card-2 w3-animate-left w3-hide-medium w3-hide-large" style="display:none" id="mySidenav">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-large w3-padding-16">Cerrar ×</a>
  <a href="pcontrol.php" onclick="w3_close()">INICIO</a>
  <a href="pcontrol_mis_hilos.php" onclick="w3_close()">MIS HILOS</a>
  <a href="pcontrol_crear_hilo.php" onclick="w3_close()">CREAR HILO</a>
  <a href="logout.php" onclick="w3_close()">CERRAR SESIÓN</a>
</nav>
