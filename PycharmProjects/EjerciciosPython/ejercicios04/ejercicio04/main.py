ruta1 = "C:/Users/ale_z/PycharmProjects/EjerciciosPython/ejercicios04/ejercicio04/f1.txt"
ruta2 = "C:/Users/ale_z/PycharmProjects/EjerciciosPython/ejercicios04/ejercicio04/f2.txt"
ruta3 = "C:/Users/ale_z/PycharmProjects/EjerciciosPython/ejercicios04/ejercicio04/f3.txt"

fichero1 = open(ruta1, "r")
fichero2 = open(ruta2, "r")
fichero3 = open(ruta3, "w")

longitud1 = len(fichero1.readlines())
longitud2 = len(fichero2.readlines())
fichero1.seek(0)
fichero2.seek(0)

for i in range(longitud1):
    linea1 = fichero1.readline().replace("\n", "")  # Le quito el salto de línea.
    cabecera1 = linea1.split(":")[0]   # Saco la cabecera.
    for j in range(longitud2):
        linea2 = fichero2.readline().replace("\n", "")  # Le quito el salto de línea.
        cabecera2 = linea2.split(":")[0]  # Saco la cabecera.
        if cabecera1 == cabecera2:  # Miro si las cabeceras son iguales.
            fichero3.write(cabecera1)  # Imprimo la cabecera.
            # Imprimo el resto.
            for k in range(len(linea1.split(":"))):
                if k != 0:
                    fichero3.write(":" + linea1.split(":")[k])
            for k in range(len(linea2.split(":"))):
                if k != 0:
                    fichero3.write(":" + linea2.split(":")[k])
            fichero3.write("\n")
    fichero2.seek(0)  # Me pongo otra vez al principio para seguir comprobando.

fichero1.close()
fichero2.close()
fichero3.close()
