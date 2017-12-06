dimension = int(input("Dimensión: "))
matriz = []

"""Meter datos"""
i = 0
while i < dimension:
    j = 0
    matriz.append([])
    while j < dimension:
        dato = input("Dato " + " " + str(i) + " " + str(j) + " ")
        if dato != "":
            matriz[i].append(dato)
            j += 1
    i += 1

"""Imprimir diagonal"""
i = 0
while i < dimension:
    j = 0
    while j < dimension:
        if i == j:
            print(matriz[i][j], end="")
            """print(matriz[i][j], end="", flush=True)"""
        j += 1
    i += 1
