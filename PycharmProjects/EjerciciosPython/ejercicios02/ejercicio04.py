"""Funciones"""


def mostrar_array(array):
    for elemento in array:
        print(elemento)


n = int(input("Introduce un número "))
i = 1
lista = []
while i <= n:
    if n % i == 0:
        lista.append(i)
    i += 1

mostrar_array(lista)
