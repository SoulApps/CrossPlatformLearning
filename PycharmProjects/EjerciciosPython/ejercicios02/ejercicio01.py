i = 0
add = " "
lista = []

while add != "":
    add = input("Mete una palabra. (No introducirla deja de pedir) ")
    lista.append(add)

buscar = input("¿Qué palabra quieres buscar? ")

for palabra in lista:
    if palabra == buscar:
        i += 1
print(buscar, "aparece", i, "veces")
