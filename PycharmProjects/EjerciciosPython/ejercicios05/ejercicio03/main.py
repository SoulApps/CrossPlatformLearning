from funciones.funciones import *
from ejercicios05.ejercicio03.libro import Libro
from ejercicios05.ejercicio03.pelicula import Pelicula
from ejercicios05.ejercicio03.revista import Revista
from ejercicios05.ejercicio03.trabajador import Trabajador
from ejercicios05.ejercicio03.usuario import Usuario


salir = False
opcion = numUsuario = numMaterial = numTrabajador = 0
usuarios = {}
materiales = {}
trabajadores = {}

while not salir:
    while not 1 <= opcion <= 12:
        opcion = pedir_entero("\n¿Qué quieres hacer?\n"
                              "\t1. Crear usuario.\n"
                              "\t2. Borrar usuario.\n"
                              "\t3. Ver usuarios.\n"
                              "\t4. Crear material.\n"
                              "\t5. Borrar material.\n"
                              "\t6. Ver materiales sin asignar.\n"
                              "\t7. Crear trabajador.\n"
                              "\t8. Borrar trabajador.\n"
                              "\t9. Ver trabajadores.\n"
                              "\t10. Hacer préstamo.\n"
                              "\t11. Devolver préstamo.\n"
                              "\t12. Salir.\n")

    if opcion == 1:
        nombre = input("¿Cómo se llamará el usuario? ")
        numUsuario += 1
        usuarios[numUsuario] = Usuario(nombre)

    elif opcion == 2:
        if numUsuario == 0:
            print("No hay usuarios")
        else:
            id = 0
            existe = False
            while not existe:
                id = pedir_entero("¿A quién quieres borrar? ")
                existe = comprobar_existe(usuarios, id)
            if usuarios[id].material != False:
                usuarios.pop(id)
            else:
                usuarios[id].material.asignado = False

    elif opcion == 3:
        for usuario in usuarios:
            if usuarios[usuario].material == False:
                material = ""
            else:
                material = usuarios[usuario].material.nombre
            print("[Id: {}] [Nombre: {}] [Material: {}]".format(usuario, usuarios[usuario].nombre, material))

    elif opcion == 4:
        nombre = input("¿Cómo se llamará el material? ")
        tipo = 0
        while not 1 <= tipo <= 3:
            tipo = pedir_entero("¿De qué tipo será el material?\n"
                                "\t1. Libro.\n"
                                "\t2. Película.\n"
                                "\t3. Revista.\n")
        numMaterial += 1
        if tipo == 1:
            materiales[numMaterial] = Libro(nombre)
        elif tipo == 2:
            materiales[numMaterial] = Pelicula(nombre)
        else:
            materiales[numMaterial] = Revista(nombre)

    elif opcion == 5:
        if numMaterial == 0:
            print("No hay o materiales")
        else:
            id = 0
            existe = False
            while not existe:
                id = pedir_entero("¿Qué quieres borrar? ")
                existe = comprobar_existe(usuarios, id)
            if not materiales[id].asignado:
                materiales.pop(id)
            else:
                print("Ese material no está disponible.")

    elif opcion == 6:
        for material in materiales:
            if not materiales[material].asignado:
                if isinstance(materiales[material], Libro):
                    tipo = "Libro"
                elif isinstance(materiales[material], Pelicula):
                    tipo = "Película"
                else:
                    tipo = "Revista"
                print("[Id: {}] [Nombre: {}] [Tipo: {}]".format(material, materiales[material].nombre, tipo))

    elif opcion == 7:
        nombre = input("¿Cómo se llamará el trabajador? ")
        numTrabajador += 1
        trabajadores[numTrabajador] = Trabajador(nombre)

    elif opcion == 8:
        if numTrabajador == 0:
            print("No hay trabajadores")
        else:
            id = 0
            existe = False
            while not existe:
                id = pedir_entero("¿A quién quieres borrar? ")
                existe = comprobar_existe(usuarios, id)
            trabajadores.pop(id)

    elif opcion == 9:
        for trabajador in trabajadores:
            print("[Id: {}] [Nombre: {}]".format(trabajador, usuarios[trabajadores].nombre))

    elif opcion == 10:
        usuario = 0
        material = 0

        if numUsuario == 0 or numMaterial == 0:
            print("No hay usuarios o materiales")
        else:
            existe = False
            while not existe:
                usuario = pedir_entero("¿A quién le quieres prestar? ")
                existe = comprobar_existe(usuarios, usuario)

            existe = False
            while not existe:
                material = pedir_entero("¿Qué quieres prestar? ")
                existe = comprobar_existe(materiales, material)

            if not materiales[material].asignado:
                materiales[material].asignado = True
                usuarios[usuario].asignarMaterial(materiales[material])
            else:
                print("Ese material no está disponible.")

    elif opcion == 11:
        if numUsuario == 0 or numMaterial == 0:
            print("No hay usuarios o materiales")
        else:
            usuario = 0
            existe = False
            while not existe:
                usuario = pedir_entero("¿Quién va a devolver? ")
                existe = comprobar_existe(usuarios, usuario)
            if usuarios[usuario].material != False:
                usuarios[usuario].devolverMaterial().asignado = False
            else:
                print("Ese usuario no tenía nada asignado")
    else:
        salir = True

    opcion = 0
print("Adiós")
