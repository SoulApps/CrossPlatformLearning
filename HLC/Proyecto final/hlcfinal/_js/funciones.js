function crearHilo() {

    var titulo = document.getElementById("titulo").value;
    var detalles = document.getElementById("detalles").value;

    
    if(titulo != "" && detalles != ""){
        if(window.XMLHttpRequest){
            xmlhttp= new XMLHttpRequest();
        }else{
            xmlhttp= new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            window.location.href = xmlhttp.responseText;
        }
    }

    xmlhttp.open("POST","crear_hilo.php", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("titulo="+titulo+"&detalles="+detalles);
}

function escribirComentario() {

    var contenido = document.getElementById("contenido").value;
    var titulo = document.getElementById("titulo").value;
    var hilo = document.getElementById("hilo").value;

    
    if(contenido != ''){
        if(window.XMLHttpRequest){
        xmlhttp= new XMLHttpRequest();
        }else{
            xmlhttp= new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            window.location.href = xmlhttp.responseText;
            window.location.reload(true);
        }
    }

    xmlhttp.open("POST","crear_comentario.php", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("contenido="+contenido+"&titulo="+titulo+"&thread="+hilo);
}

function comprobarPass(str){
    
    var xmlhttp;
    if(str == ''){
        document.getElementById("passErr").innerHTML="Campo obligatorio";
        document.getElementById("passErr").classList.remove('verde');
        document.getElementById("passErr").classList.add('rojo');
        exit();
    }
}

function comprobarNick(str){
    
    var xmlhttp;
    if(str == ''){
        document.getElementById("nickErr").innerHTML="Campo obligatorio";
        document.getElementById("nickErr").classList.remove('verde');
        document.getElementById("nickErr").classList.add('rojo');
        exit();
    }
    if(window.XMLHttpRequest){
        xmlhttp= new XMLHttpRequest();
    }else{
        xmlhttp= new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            if(xmlhttp.responseText == '0'){
                document.getElementById("nickErr").innerHTML="Usuario dispoble";
                document.getElementById("nickErr").classList.remove('rojo');
                document.getElementById("nickErr").classList.add('verde');
            }else{
                document.getElementById("nickErr").innerHTML="Usuario NO dispoble";
                document.getElementById("nickErr").classList.remove('verde');
                document.getElementById("nickErr").classList.add('rojo');
            }
            
            
        }
    }
    xmlhttp.open("POST","_includes/comp_nick.php", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("q="+str);
}

function comprobarEmail(str){
    
    var xmlhttp;
    if(str == ''){
        document.getElementById("emailErr").innerHTML="Campo obligatorio";
        document.getElementById("emailErr").classList.remove('verde');
        document.getElementById("emailErr").classList.add('rojo');
        exit();
    }
    if(window.XMLHttpRequest){
        xmlhttp= new XMLHttpRequest();
    }else{
        xmlhttp= new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            if(xmlhttp.responseText == '0'){
                document.getElementById("emailErr").innerHTML="Email dispoble";
                document.getElementById("emailErr").classList.remove('rojo');
                document.getElementById("emailErr").classList.add('verde');
            }else if(xmlhttp.responseText == '-1'){
                document.getElementById("emailErr").innerHTML="Email incorrecto";
                document.getElementById("emailErr").classList.remove('verde');
                document.getElementById("emailErr").classList.add('rojo');
            }else{
                document.getElementById("emailErr").innerHTML="Email NO dispoble";
                document.getElementById("emailErr").classList.remove('verde');
                document.getElementById("emailErr").classList.add('rojo');
            }
            
            
        }
    }
    xmlhttp.open("POST","_includes/comp_email.php", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("q="+str);
}
// Toggle between showing and hiding the sidenav when clicking the menu icon
var mySidenav = document.getElementById("mySidenav");

function w3_open() {
    if (mySidenav.style.display === 'block') {
        mySidenav.style.display = 'none';
    } else {
        mySidenav.style.display = 'block';
    }
}

// Close the sidenav with the close button
function w3_close() {
    mySidenav.style.display = "none";
}
