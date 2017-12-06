from funciones.funciones import *

""""Funciones"""


def mcm(lista):
    resultado = i = 0
    while i < len(lista):
        j = 0
        while j < len(lista):
            if i != j:
                aux = lista[i] * lista[j]
                if resultado < aux:
                    resultado = aux
            j += 1
        i += 1
    return resultado


"""Main"""

n1 = pedir_entero("Mete el primer número ")
n2 = pedir_entero("Mete el segundo número ")
n3 = pedir_entero("Mete el tercero número ")
n4 = pedir_entero("Mete el cuarto número ")

numeros = (n1, n2, n3, n4)
print(mcm(numeros))
