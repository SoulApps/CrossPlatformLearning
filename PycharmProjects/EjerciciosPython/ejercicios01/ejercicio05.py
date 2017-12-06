multa = input("Multa: ")
dias = int(input("Días: "))

if dias == 1 or dias == 0:
    resultado = float(multa) / 1.5
elif dias == 2:
    resultado = float(multa) / 1.25
elif dias == 3:
    resultado = float(multa) / 1.1
else:
    resultado = multa

print(resultado)
