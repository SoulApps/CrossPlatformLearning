<a href="index.php">
   <h3>Agenda Personal</h3>
   <h4>IES Saladillo</h4>
</a>
<figure>
   <img src="_img/logo-peq.jpg">
   <figcaption>
       Logo de la página
   </figcaption>
</figure>
<nav>
    <ul>
<!--menus de admin -->
       <?php
        if($_SESSION['admin'] == 1){
        ?>
        <li><a <?php if($titulo == 'Usuarios'){echo "class='activo'";}?> href="">Usuarios</a></li>
        <li><a <?php if($titulo == 'Incidencias'){echo "class='activo'";}?> href="">Incidencias</a></li>
        <?php
        }else{
        ?>
<!--fin menu de admin -->
<!--menus de usuario -->
        <li><a <?php if($titulo == 'Contactos'){echo "class='activo'";} ?> href="pcontrol.php">Contactos</a></li>
        <li><a <?php if($titulo == 'Favoritos'){echo "class='activo'";}?> href="pcontrol_favoritos.php">Favoritos</a></li>
        <li><a <?php if($titulo == 'Grupos'){echo "class='activo'";}?> href="">Grupos</a></li>
        <li><a <?php if($titulo == 'Mensajes'){echo "class='activo'";}?> href="">Mensajes</a></li>
        <?php 
        }
        ?>
    </ul>
    <ul  class="der">
<!--fin menus de usua -->
<!--menu de comun -->
       <li><a href="logout.php" ><i class="fa fa-times" aria-hidden="true"></i>
</a></li>
       <li><a href="" ><i class="fa fa-envelope-open" aria-hidden="true"></i>
</a></li>
       <li id="ocul">Hola: <?php echo $_SESSION['nick']; ?></li>
    </ul>
</nav>
