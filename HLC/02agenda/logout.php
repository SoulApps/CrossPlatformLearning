<?php
session_start();
if(!isset($_SESSION['nick'])){
        $_SESSION['msg']=1;
        header('Location: index.php');
        exit();
    }else{
        session_destroy();
        $_SESSION['msg']=8;
        header('Location: index.php');
        exit();
    }

?>