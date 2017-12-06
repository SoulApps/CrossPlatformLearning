cadena = input("Mete alguna palabra ")
cadena = cadena.lower()
cadena = cadena.replace(" ", "")

if cadena == cadena[::-1]:
    print("Es palíndromo")
else:
    print("No es palíndromo")
