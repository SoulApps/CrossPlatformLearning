from funciones.funciones import *


def agregar(key, tlf):
    if not existe(agenda, key):
        agenda[key] = tlf
        print("Se ha agregado a", key)
    else:
        print(key, "ya existe")


def eliminar(key):
    if existe(agenda, key):
        agenda.pop(key)
        return print("Se ha eliminado a", key)
    print(key, "no existe")


def editar(key, tlf):
    if existe(agenda, key):
        agenda[key] = tlf
        print("Se ha agregado a", key)
    else:
        print(key, "no existe")


def listar():
    for contacto in agenda:
        print(contacto, agenda[contacto])


def buscar(key):
    if existe(agenda, key):
        print(agenda[key])
    else:
        print(key, "no existe")


salir = False
agenda = {}

print("¡Hola!")

while not salir:

    opcion = 0
    while opcion <= 0 or opcion >= 7:
        opcion = pedir_entero("¿Qué quieres hacer?\n"
                              "\t1. Agregar contactos\n"
                              "\t2. Eliminar contactos\n"
                              "\t3. Editar contacto\n"
                              "\t4. Listar contactos\n"
                              "\t5. Buscar contactos\n"
                              "\t6. Salir\n")

    if opcion == 1:
        nombre = input("Nombre: ")
        telefono = input("Teléfono: ")
        agregar(nombre, telefono)

    elif opcion == 2:
        nombre = input("¿A quién quieres eliminar? ")
        eliminar(nombre)

    elif opcion == 3:
        nombre = input("¿A quién quieres editar? ")
        telefono = input("¿Cuál es su nuevo número de teléfono?")
        editar(nombre, telefono)
        print("El teléfono de", nombre, "ahora es", telefono)

    elif opcion == 4:
        listar()

    elif opcion == 5:
        nombre = input("¿A quién quieres buscar? ")
        print(buscar(nombre))

    else:
        salir = True
        print("¡Hasta pronto!")
