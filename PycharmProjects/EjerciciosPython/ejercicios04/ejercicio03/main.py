from funciones.funciones import *

""""
C:/Users/ale_z/PycharmProjects/EjerciciosPython/ejercicios04/ejercicio03/fichero.txt
"""


def finfichero(num, archivo):
    fichero = open(archivo, "r")
    lineas = fichero.readlines()
    lineaActual = 1
    for linea in lineas:
        if lineaActual >= len(lineas) - num:
            print(linea, end="")
        lineaActual += 1
    fichero.close()

ruta = pedir_ruta("Introduce una ruta de archivo. ")
n = ""
while not str.isdigit(n):
    n = input("Introduce un número positivo. ")
n = int(n)

finfichero(n, ruta)
