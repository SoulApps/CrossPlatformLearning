from funciones.funciones import *

"""Devuelve el número de líneas leídas"""


def leerFichero():
    fichero = open("alumnos.txt", "a+", encoding="UTF-8")
    longitud = fichero.tell()
    fichero.seek(0)
    while fichero.tell() != longitud:
        linea = fichero.readline().replace("\n", "")  # Quito los saltos de línea.
        alumno = linea.split("|")
        dni = alumno[0]
        apellidos = alumno[1]
        nombre = alumno[2]
        turno = alumno[3]

        alumnos[dni] = [apellidos, nombre, int(turno)]  # Turno entero.

    fichero.close()

"""Muestra todos los alumnos si n es 0"""


def mostrarAlumnos(n):
    leerFichero()
    for dni in alumnos:
        lista = alumnos[dni]
        apellidos = lista[0]
        nombre = lista[1]
        turno = lista[2]
        if n == turno or n == 0:
            print("[DNI: {}] [Apellidos: {}] [Nombre: {}] [Turno: {}]".format(dni, apellidos, nombre, turno))


def actualizarFichero():
    fichero = open("alumnos.txt", "w", encoding="UTF-8")
    for dni in alumnos:
        lista = alumnos[dni]
        apellidos = lista[0]
        nombre = lista[1]
        turno = lista[2]
        fichero.write("{}|{}|{}|{}\n".format(dni, apellidos, nombre, turno))
    fichero.close()


def cambiarTurno(alu1, alu2):
    turno1 = alumnos[alu1][2]
    turno2 = alumnos[alu2][2]

    alumnos[alu1][2] = turno2
    alumnos[alu2][2] = turno1

    actualizarFichero()


def comprobarAlumno(alu):
    for dni in alumnos:
        if alu == dni:
            return True
    print("Ese alumno no existe")
    return False

alumnos = {}
leerFichero()
salir = False
opcion = 0

while not salir:
    while not 1 <= opcion <= 5:
        opcion = pedir_entero("\n¿Qué quieres hacer?\n"
                              "\t1. Buscar por turno.\n"
                              "\t2. Contar alumnos.\n"
                              "\t3. Intercambiar turnos.\n"
                              "\t4. Listar.\n"
                              "\t5. Salir\n")

    if opcion == 1:
        tur = 0
        while not 1 <= tur <= 10:
            tur = pedir_entero("¿Por cuál turno quieres buscar? (1 - 10) ")
        mostrarAlumnos(tur)

    elif opcion == 2:
        print("Hay {} alumnos.".format(len(alumnos)))

    elif opcion == 3:
        alumno1 = input("Introduce el DNI del primer alumno ")
        while not comprobarAlumno(alumno1):
            alumno1 = input("Introduce el DNI del primer alumno ")

        alumno2 = input("Introduce el DNI del segundo alumno ")
        while not comprobarAlumno(alumno2):
            alumno1 = input("Introduce el DNI del segundo alumno ")

        cambiarTurno(alumno1, alumno2)

    elif opcion == 4:
        mostrarAlumnos(0)

    else:
        salir = True
        print("Adiós")

    opcion = 0  # Para que vuelva a entrar bien en el bucle.
