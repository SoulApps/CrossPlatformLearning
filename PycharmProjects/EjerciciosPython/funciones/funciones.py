import os.path

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
