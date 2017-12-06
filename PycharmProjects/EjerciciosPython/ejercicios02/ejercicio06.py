tupla = ("Alejandro", "Dabeef", "David", "Carmen", "JoJo")
char = input("¿Qué caracter quieres buscar? ")
for palabra in tupla:
    if palabra.__contains__(char):
        print(palabra)
