from funciones.funciones import *


def comprobar_curso(curso):
    for cur in cursos:
        if cur == curso:
            return True
    return False


def comprobar_profesor(profesor):
    resultado = 0
    for cur in cursos:
        if cursos[cur][0] == profesor:
            resultado += 1
    return resultado


def agregar(cur, datos):
    if comprobar_curso(cur):
        print("Curso repetido")
    else:
        if comprobar_profesor(datos[0]) < 2:
            cursos[cur] = datos
            print("Se ha agregado", cur, "con el profesor", datos[0], "y con", datos[1], "alumnos")
        else:
            print("Profesor con 2 cursos")


def eliminar(cur):
    if comprobar_curso(cur):
        cursos.pop(curso)
        print("Curso eliminado")
    else:
        print("El curso no existe")


def listar():
    for cur in cursos:
        print("Curso:", cur, "Profesor:", cursos[cur][0], "Alumnos:", cursos[cur][1])


salir = False
cursos = {}
alumnos = 0

print("¡Hola!")

while not salir:
    opcion = 0
    while opcion <= 0 or opcion >= 5:
        opcion = pedir_entero("¿Qué quieres hacer?\n"
                              "\t1. Agregar curso\n"
                              "\t2. Eliminar curso\n"
                              "\t3. Listar cursos\n"
                              "\t4. Salir\n")

    if opcion == 1:
        curso = input("Nombre: ")
        profesor = input("Profesor: ")
        alumnos = 0
        while alumnos < 1:
            alumnos = pedir_entero("Número de alumnos: ")

        agregar(curso, [profesor, alumnos])

    elif opcion == 2:
        curso = input("¿Qué curso quieres eliminar? ")
        eliminar(curso)

    elif opcion == 3:
        listar()

    else:
        salir = True
        print("¡Hasta pronto!")
