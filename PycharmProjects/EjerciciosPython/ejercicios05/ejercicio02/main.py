from funciones.funciones import *
from ejercicios05.ejercicio02.caseta_meteo import CasetaMeteo


salir = False
opcion = numCaseta = 0
casetas = {}

while not salir:
    while not 1 <= opcion <= 7:
        opcion = pedir_entero("\n¿Qué quieres hacer?\n"
                              "\t1. Crear caseta.\n"
                              "\t2. Leer datos.\n"
                              "\t3. Comprobar probabilidad de lluvia.\n"
                              "\t4. Salir\n")

    if opcion == 1:
        opcion = 0
        while not 1 <= opcion <= 2:
            opcion = pedir_entero("\n¿Qué formato quieres?\n"
                                  "\t1. Día/Mes/Año.\n"
                                  "\t2. Mes/Día/Año.\n")
        if opcion == 1:
            formato_normal = True
        else:
            formato_normal = False
        numCaseta += 1
        casetas[numCaseta] = CasetaMeteo(formato_normal)

    elif opcion == 2:
        if numCaseta != 0:
            for caseta in casetas:
                print("Caseta {} -> {}".format(caseta, casetas[caseta].getObservaciones()), end="")
        else:
            print("No hay casetas.")

    elif opcion == 3:
        if numCaseta != 0:
            existeProbabilidadDeLluvia = False
            for caseta in casetas:
                if casetas[caseta].existeProbabilidadLluvia():
                    existeProbabilidadDeLluvia = True
            if existeProbabilidadDeLluvia:
                print("Existe probabilidad de lluvia.")
            else:
                print("No existe probabilidad de lluvia.")
        else:
            print("No hay casetas.")

    else:
        salir = True

    opcion = 0

print("Adiós.")
