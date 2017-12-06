from funciones.funciones import *

"""Devuelve el número de líneas leídas"""


def leerFichero():
    fichero = open("alumnos.txt", "a+", encoding="UTF-8")
    longitud = fichero.tell()
    fichero.seek(0)
    alumnos.clear()
    while fichero.tell() != longitud:
        linea = fichero.readline().replace("\n", "")  # Quito los saltos de línea.
        alumno = linea.split(";")
        alumnos.append(alumno)

    fichero.close()


"""Muestra todos los alumnos si n es 0"""


def mostrarAlumnos():
    leerFichero()
    for alumno in alumnos:
        apellido1 = alumno[0]
        apellido2 = alumno[1]
        nombre = alumno[2]
        dni = alumno[3]
        edad = alumno[4]
        direccion = alumno[5]
        email = alumno[6]
        print("[Apellido1: {}] [Apellido2: {}] [Nombre: {}] [DNI: {}] [Edad: {}] [Direccion: {}] [Email: {}]".format(
            apellido1, apellido2, nombre, dni, edad, direccion, email))


def agregarAlumno(apellido1, apellido2, nombre, dni, edad, direccion, email):
    alumnos.append([apellido1, apellido2, nombre, dni, edad, direccion, email])
    actualizarFichero()


def eliminarAlumno(dni):
    leerFichero()
    encontrado = False
    i = 0
    while i < len(alumnos) and not encontrado:
        if alumnos[i][3] == dni:
            encontrado = True
            alumnos.pop(i)
        i += 1
    actualizarFichero()


def actualizarFichero():
    fichero = open("alumnos.txt", "w", encoding="UTF-8")
    for alumno in alumnos:
        apellido1 = alumno[0]
        apellido2 = alumno[1]
        nombre = alumno[2]
        dni = alumno[3]
        edad = alumno[4]
        direccion = alumno[5]
        email = alumno[6]
        fichero.write("{};{};{};{};{};{};{}\n".format(apellido1, apellido2, nombre, dni, edad, direccion, email))
    fichero.close()


def comprobarAlumno(alu):
    for alumno in alumnos:
        dni = alumno[3]
        if alu == dni:
            return True
    return False


alumnos = []
salir = False
opcion = 0

while not salir:
    leerFichero()
    while not 1 <= opcion <= 5:
        opcion = pedir_entero("\n¿Qué quieres hacer?\n"
                              "\t1. Agregar alumno.\n"
                              "\t2. Borrar alumno.\n"
                              "\t3. Listar alumnos.\n"
                              "\t4. Contar alumnos.\n"
                              "\t5. Salir\n")

    if opcion == 1:
        ap1 = input("¿Cuál es el apellido 1? ")
        ap2 = input("¿Cuál es el apellido 2? ")
        nom = input("¿Cuál es el nombre? ")
        nif = input("¿Cuál es el dni? ")
        ed = pedir_entero("¿Cuál es el edad? ")
        dire = input("¿Cuál es el dirección? ")
        mail = input("¿Cuál es el email? ")

        if comprobarAlumno(nif):
            print("Ese alumno ya existe.")
        else:
            agregarAlumno(ap1, ap2, nom, nif, ed, dire, mail)
            print("Alumno creado.")

    elif opcion == 2:
        nif = input("¿Cuál es el dni? ")
        if comprobarAlumno(nif):
            eliminarAlumno(nif)
            print("Alumno borrado.")
        else:
            print("Ese alumno no existe.")

    elif opcion == 3:
        mostrarAlumnos()

    elif opcion == 4:
        print("Hay {} alumnos.".format(len(alumnos)))

    else:
        salir = True
        print("Adiós")

    opcion = 0  # Para que vuelva a entrar bien en el bucle.
