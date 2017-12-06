function poblaciones(str){
    
    var xmlhttp;
    if(str == '-1'){
       document.getElementById("pob").innerHTML="<option value='-1'>Elige una...</option>"
    }
    if(window.XMLHttpRequest){
        xmlhttp= new XMLHttpRequest();
    }else{
        xmlhttp= new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            document.getElementById("pob").innerHTML= xmlhttp.responseText;
            
        }
        
        
        
    }
    xmlhttp.open("POST","_includes/poblaciones.php", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("q="+str);
    
}

function comprobarNick(str){
    
    var xmlhttp;
    if(str == ''){
       
       document.getElementById("nickErr").innerHTML="No puedes dejar el campo en blanco";
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

function favoritos(id) {
    var xmlhttp;
    
    if(window.XMLHttpRequest){
        xmlhttp= new XMLHttpRequest();
    }else{
        xmlhttp= new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    xmlhttp.onreadystatechange=function(){
        
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            if(xmlhttp.responseText == '0'){ //No es favorito ahora.
                document.getElementById("contacto"+id).classList.remove('favorito');
            }else{
                document.getElementById("contacto"+id).classList.add('favorito');
            }
            
            
        }
        
        
        
    }
    
    xmlhttp.open("POST","favoritos.php", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("id="+id);
}