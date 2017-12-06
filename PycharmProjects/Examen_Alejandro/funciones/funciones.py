import os.path

from clases.responsable import Responsable
from clases.taller import Taller
from clases.trabajador import Trabajador

"""
from funciones.funciones import *
"""


def pedir_entero(mensaje):
    es_numero = False
    while not es_numero:
        n = input(mensaje)
        try:
            return int(n)
        except ValueError:
            print("¡¡ERROR!! Debes introducir algún número.")
            es_numero = False


def pedir_decimal(mensaje):
    es_numero = False
    while not es_numero:
        n = input(mensaje)
        try:
            return float(n)
        except ValueError:
            print("¡¡ERROR!! Debes introducir un decimal positivo.")  # Positivo para su uso.
            es_numero = False


def existe(array, x):
    resultado = False
    for elemento in array:
        if x == elemento:
            resultado = True
    return resultado


def pedir_ruta(mensaje):
    valido = False
    while not valido:
        ruta = input(mensaje)
        if not os.path.isfile(ruta):
            print("¡¡Error!! Ruta no válida.")
        else:
            return ruta


def introducir_nif(mensaje):
    valido = False
    while not valido:
        valido = True
        nif = input(mensaje)
        if len(nif) == 9:
            for i in range(len(nif) - 1):  # Solo los números.
                if not nif[i].isdigit():
                    valido = False
            if nif[len(nif) - 1].isdigit() or nif[len(nif) - 1].islower():  # La letra.
                valido = False
            if not valido:
                print("Formato de NIF incorrecto.")
            else:
                return nif
        else:
            print("Formato de NIF incorrecto.")
            valido = False


def pedir_nombre(mensaje):
    valido = False
    while not valido:
        valido = True
        nombre = input(mensaje)
        if nombre.isdigit() or nombre[0].islower():
            valido = False
        if not valido:
            print("Formato de nombre incorrecto.")
        else:
            return nombre


def comprobar_existe(coleccion, elemento):
    for o in coleccion:
        if o == elemento:
            return True
    return False


def asignar(talleres, trabajadores, empleado, localidad):
    existe = False
    disponible = False
    for taller in talleres:
        print(talleres[taller].getId(), localidad)
        if talleres[taller].localidad == localidad:
            existe = True
            if talleres[taller].isDisponible():
                disponible = True
                empleado.asignado = True
                talleres[taller].trabajadores.append(empleado)

    if not disponible:
        for taller in talleres:
            if talleres[taller].isDisponible():
                empleado.asignado = True
                talleres[taller].trabajadores.append(trabajadores[empleado])
                print("Esa localidad no estaba disponible. Empleado asignado a", talleres[taller].localidad, ".")

    if not existe:
        print("Ese taller no existe.")


def dar_baja(talleres, trabajadores, empleado):
    existe = False
    if trabajadores[empleado].isActivo:
        for taller in talleres:
            for e in talleres[taller].trabajadores:
                if e.getId() == empleado:
                    talleres[taller].trabajadores[e].activo = False
                    trabajadores[empleado].activo = False
                    trabajadores[empleado].asignado = False
    else:
        print("Ese trabajador no está activo")


def cargar_talleres(talleres, trabajadores):
    fichero = open("../ficheros/talleres.txt", "a+", encoding="UTF-8")
    longitud = fichero.tell()  # No creo que veas esto
    fichero.seek(0)
    while fichero.tell() != longitud:
        linea = fichero.readline().replace("\n", "")  # Quito los saltos de línea.
        taller = linea.split(", ")
        talleres[taller[1]] = Taller(taller[0], taller[1], taller[2], taller[3])
        for trabajador in trabajadores:
            if trabajadores[trabajador].getId() == taller[4]:
                talleres[taller[1]].responsable = taller[4]

    fichero.close()


def cargar_responsables(trabajadores):
    fichero = open("../ficheros/responsables.txt", "a+", encoding="UTF-8")
    longitud = fichero.tell()
    fichero.seek(0)
    while fichero.tell() != longitud:
        linea = fichero.readline().replace("\n", "")  # Quito los saltos de línea.
        trabajador = linea.split(", ")
        trabajadores[int(trabajador[0])] = Responsable(int(trabajador[0]), trabajador[1], trabajador[2], trabajador[3],
                                                       trabajador[4], trabajador[5])

    fichero.close()


def cargar_trabajadores(trabajadores):
    fichero = open("../ficheros/trabajadores.txt", "a+", encoding="UTF-8")
    longitud = fichero.tell()
    fichero.seek(0)
    while fichero.tell() != longitud:
        linea = fichero.readline().replace("\n", "")  # Quito los saltos de línea.
        trabajador = linea.split(", ")
        trabajadores[int(trabajador[0])] = Trabajador(int(trabajador[0]), trabajador[1], trabajador[2], trabajador[3])

    fichero.close()


def guardar(trabajadores):
    fichero = open("../ficheros/trabajadores.txt", "w+", encoding="UTF-8")
    for trabajador in trabajadores:
        mTrabajador = trabajadores[trabajador]
        if not isinstance(mTrabajador, Responsable):
            fichero.write("{}, {}, {}, {}\n".format(mTrabajador.getId(), mTrabajador.nombre, mTrabajador.apellidos,
                                                    mTrabajador.getDni()))
    fichero.close()
