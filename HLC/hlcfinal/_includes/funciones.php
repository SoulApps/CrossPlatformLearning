<?php

function debug($valor){
    echo "<pre>";
    var_dump($valor);
    echo "</pre>";
}
function consulta($select, $conex){
    
    $resultado= mysqli_query($conex, $select);
    
    return $resultado;
}
function comprobar_msg(){
    /*mesajes de $_SESSION['msg']
    1: NO HA ESCRITO USURIO
    2: CONTRASÑA O USUARIO INCORRECTO.
    
    */
    if(isset($_SESSION['msg'])){
        if($_SESSION['msg'] == 1){
        
        $_SESSION['msg']= 0;
        return  "<span style='display:block;'> Debes introducir usuario y contraseña.</span>";
        
        }else if($_SESSION['msg'] == 2){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'> Usuario o contraseña incorrecto.</span>";
        }else if($_SESSION['msg'] == 3){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'> Tienes que rellenar el formulario de registro.</span>";
        }else if($_SESSION['msg'] == 4){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'> Usuario {$_GET['n']} no disponible.</span>";
        }else if($_SESSION['msg'] == 5){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'> Problemas en el servidor inténtalo en 5'</span>";
        }else if($_SESSION['msg'] == 6){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'> Tipo de archivo no soportado'</span>";
        }else if($_SESSION['msg'] == 7){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'>Registro correcto. .</span>";
        }else if($_SESSION['msg'] == 7){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'>Bye bye</span>";
        }else if($_SESSION['msg'] == 8){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'> Email no disponible.</span>";
        }else if($_SESSION['msg'] == 9){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'>Formato de email incorrecto.</span>";
        }else if($_SESSION['msg'] == 10){
            $_SESSION['msg']= 0;
            return  "<span style='display:block;'>Las contraseñas deben ser iguales.</span>";
        }else{
            return  "<span style='display:none;'> HOla</span>";
        }
    }
}









