from funciones.funciones import *


def calcular_desglose(numero):
    n = numero
    tupla = (500, 200, 100, 50, 20, 10, 5, 2, 1)

    for i in tupla:
        resultado = int(n / i)
        n %= i

        if resultado > 1:
            if i > 2:
                print(resultado, "billetes de", i, "euros.")
            else:
                print(resultado, "monedas de", i, "euros.")
        elif resultado == 1:
            if i > 2:
                print(resultado, "billete de", i, "euros.")
            else:
                print(resultado, "moneda de", i, "euros.")


cantidad = 0
while cantidad < 1:
    cantidad = pedir_entero("Mete una cantidad ")
calcular_desglose(cantidad)
