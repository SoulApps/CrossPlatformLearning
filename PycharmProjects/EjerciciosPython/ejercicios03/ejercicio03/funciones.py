"""Funciones"""


def llamarFuncion(i1, i2, funcion=""):
    if funcion in globals():
        if callable(globals()[funcion]):
            return globals()[funcion](i1, i2)
    else:
        return "Función no encontrada"


def sumar(i1, i2):
    return i1 + i2


def restar(i1, i2):
    return i1 - i2


def multiplicar(i1, i2):
    return i1 * i2


def dividir(i1, i2):
    return i1 / i2


def comprobarOperacion(i1, i2, c):
    if c == 1:
        print(llamarFuncion(i1, i2, funcion="sumar"))
    elif c == 2:
        print(llamarFuncion(i1, i2, funcion="restar"))
    elif c == 3:
        print(llamarFuncion(i1, i2, funcion="multiplicar"))
    else:
        print(llamarFuncion(i1, i2, funcion="dividir"))


def pedir_entero(mensaje):
    es_numero = False
    while not es_numero:
        n = input(mensaje)
        try:
            return int(n)
        except ValueError:
            es_numero = False
