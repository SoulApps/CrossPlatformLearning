"""Alejandro"""

"""Comprobar"""


def comprobar_alumno(nom):
    existe = False
    for alumno in alumnos:
        if alumno == nom:
            existe = True
    return existe


def comprobar_asignatura(nom, asig):
    lista = alumnos[nom]
    existe = False
    i = 0
    while i < len(lista):
        if asig == lista[i]:
            existe = True
        i += 1
    return existe


"""Asignaturas"""


def add_asignatura(nom, asig):
    alumnos[nom].append(asig)


def del_asignatura(nom, asig):
    lista = alumnos[nom]
    i = 0
    while i < len(lista):
        if asig == lista[i]:
            lista.pop(i)
        i += 1


def edit_asignatura(nom, old, new):
    lista = alumnos[nom]
    i = 0
    while i < len(lista):
        if old == lista[i]:
            lista[i] = new
        i += 1


"""Alumnos"""


def add_alumno(nom):
    alumnos[nom] = []


def del_alumno(nom):
    alumnos.pop(nom)


def editAlumno(old, new):
    lista = alumnos[old]
    alumnos.pop(old)
    alumnos[new] = lista


def mostrar_alumno(nom):
    i = 0
    print(nom, " -> ", sep="", end="")
    while i < len(alumnos[nom]):
        print(alumnos[nom][i], " | ", end="")
        i += 1
    print()


def mostrar_alumnos():
    for alu in alumnos:
        mostrar_alumno(alu)


alumnos = {}
salir = False

print("¡Hola!", end="")
while not salir:
    opcion = int(input("\n♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥\n"
                       " ¿Qué quieres hacer?\n"
                       " 1. Añadir asignatura\n"
                       " 2. Borrar asignatura\n"
                       " 3. Modificar asgnatura\n"
                       " 4. Agregar alumno\n"
                       " 5. Borrar alumno\n"
                       " 6. Editar alumno\n"
                       " 7. Listar alumnos\n"
                       " 8. Salir\n"
                       "♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥\n"))

    if opcion == 1:
        alumno = input("¿A qué alumno le quieres agregar una asignatura? ")
        if comprobar_alumno(alumno):
            mostrar_alumno(alumno)
            asignatura = input("¿Qué asignatura quieres agregar? ")
            if not comprobar_asignatura(alumno, asignatura):
                add_asignatura(alumno, asignatura)
            else:
                print("La asignatura ya existe")
        else:
            print("El alumno no existe")
    elif opcion == 2:
        alumno = input("¿A qué alumno le quieres borrar una asignatura? ")
        if comprobar_alumno(alumno):
            mostrar_alumno(alumno)
            asignatura = input("¿Qué asignatura quieres borrar? ")
            if comprobar_asignatura(alumno, asignatura):
                del_asignatura(alumno, asignatura)
            else:
                print("La asignatura no existe")
        else:
            print("El alumno no existe")
    elif opcion == 3:
        alumno = input("¿A qué alumno le quieres cambiar una asignatura? ")
        if comprobar_alumno(alumno):
            mostrar_alumno(alumno)
            asignatura = input("¿Qué asignatura quieres cambiar? ")
            asignatura2 = input("¿Cuál es la nueva asignatura?")
            if asignatura != asignatura2:
                if comprobar_asignatura(alumno, asignatura):
                    edit_asignatura(alumno, asignatura, asignatura2)
                else:
                    print("La asignatura no existe")
            else:
                print("Las asignaturas no pueden ser iguales")
        else:
            print("El alumno no existe")
    elif opcion == 4:
        alumno = input("¿Cómo se llama el nuevo alumno? ")
        if not comprobar_alumno(alumno):
            add_alumno(alumno)
        else:
            print("El alumno ya existe")
    elif opcion == 5:
        alumno = input("¿A quién quieres borrar? ")
        if comprobar_alumno(alumno):
            del_alumno(alumno)
        else:
            print("El alumno no existe")
    elif opcion == 6:
        alumno = input("¿A quién quieres modificar? ")
        if comprobar_alumno(alumno):
            alumno2 = input("¿Cómo se va a llamar ahora el alumno?")
            if alumno != alumno2:
                if not comprobar_alumno(alumno2):
                    editAlumno(alumno, alumno2)
                else:
                    print("Ese alumno ya existe")
            else:
                print("Los alumnos no pueden ser iguales")
        else:
            print("El alumno no existe")
    elif opcion == 7:
        mostrar_alumnos()
    else:
        salir = True
        print("¡Adiós!")
