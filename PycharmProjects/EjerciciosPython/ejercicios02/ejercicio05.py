ficha1 = [1, 1]
ficha2 = [5, 5]
encajan = False

for i in ficha1:
    for j in ficha2:
        if i == j:
            encajan = True

print("Encajan") if encajan else print("No encajan")
