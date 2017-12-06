import os.path

if not os.path.isfile("fichero.txt"):
    print("El fichero no existe")
else:
    fichero = open("fichero.txt", "r")
    datos = fichero.readlines()[0]
    if datos == "":
        print("El fichero está vacío.")
    else:
        if not os.path.isfile("fichero2.txt"):
            print("El fichero2 no existe.")
        else:
            fichero = open("fichero2.txt", "r+")
            fichero.write(str.upper(datos))
            print(datos)
