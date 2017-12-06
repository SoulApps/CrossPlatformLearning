"""Funciones"""


def mostrar_array(array):
    for elemento in array:
        print(elemento)


def crear_listas(array1, array2, modo):  # El modo será 1, 2, o 3. El modo 2 egloba los apartados 2 y 3 del enunciado.
    lista = []

    if modo == 1:
        for palabra in array1:
            lista.append(palabra)
        for palabra in array2:
            lista.append(palabra)

    elif modo == 2:
        for palabra in array1:
            if not array2.count(palabra):
                lista.append(palabra)

    elif modo == 3:
        for palabra in array1:
            if array2.count(palabra):
                lista.append(palabra)

    return lista


"""Ejercio"""
lista1 = ["ZA WARUDO", "STANDO PAWA", "WRYYY", "yiyi izi"]
lista2 = ["pim pam", "toma lacasitos", "WRYYY", "ZA WARUDO", "WRYY"]

print("1")
print(crear_listas(lista1, lista2, 1))

print("2")
print(crear_listas(lista1, lista2, 2))

print("3")
print(crear_listas(lista2, lista1, 2))  # Importante cambio de orden

print("4")
print(crear_listas(lista1, lista2, 3))
