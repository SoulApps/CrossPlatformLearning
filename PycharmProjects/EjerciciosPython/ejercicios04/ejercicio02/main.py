from funciones.funciones import *

""""
C:/Users/ale_z/PycharmProjects/EjerciciosPython/ejercicios04/ejercicio02/fichero.txt
"""

ruta = pedir_ruta("Introduce una ruta de archivo. ")
input()
# ruta = "C:/Users/ale_z/PycharmProjects/EjerciciosPython/ejercicios04/ejercicio02/fichero.txt"

fichero = open(ruta, "a+")
longitud = fichero.tell()
fichero.seek(0)
while longitud != fichero.tell():
    for i in range(5):  # 25
        s = fichero.readline()
        if s != "":
            print(s, end="")
    if longitud != fichero.tell():
        input()
    """seguir = " "
    if longitud != fichero.tell():
        while seguir != "":
            seguir = input()  # Esto no va la primera vez."""

fichero.close()
