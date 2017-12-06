"""Funciones"""


def mostrar_array(array):
    for elemento in array:
        print(elemento)


"""Ejercicio"""
lista1 = ["ZA WARUDO", "STANDO PAWA", "WRYYY", "yiyi izi"]
lista2 = ["pim pam", "toma lacasitos", "WRYYY", "ZA WARUDO", "WRYY"]

print("PRINCIPAL")
mostrar_array(lista1)

print("\nANTES")
mostrar_array(lista2)

i = 0
while i < len(lista1):
    j = 0
    while j < len(lista2):
        if lista1[i] == lista2[j]:
            lista2.pop(j)
        j += 1
    i += 1

print("\nDESPUÉS")
mostrar_array(lista2)
