lista1 = [2, 0, 1], [3, 0, 0], [5, 1, 1]
lista2 = [1, 0, 1], [1, 2, 1], [1, 1, 0]
i = 0

while i < len(lista1):
    j = 0
    n = ""
    while j < len(lista1[i]):
        n += str(lista1[i][j] + lista2[i][j]) + " "
        j += 1
    print(n)
    i += 1
