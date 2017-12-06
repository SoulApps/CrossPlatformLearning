from funciones.funciones import *

talleres = {}
trabajadores = {}

salir = False
opcion = 0

cargar_responsables(trabajadores)
cargar_trabajadores(trabajadores)
cargar_talleres(talleres, trabajadores)

idTrabajador = len(trabajadores)

while not salir:
    while not 1 <= opcion <= 5:
        opcion = pedir_entero("\n¿Qué quieres hacer?\n"
                              "\t1. Crear trabajador.\n"
                              "\t2. Dar de baja trabajador.\n"
                              "\t3. Listar trabajadores.\n"
                              "\t4. Listar talleres.\n"
                              "\t5. Listar responsables.\n"
                              "\t6. Ver trabajador.\n"
                              "\t7. Ver taller.\n"
                              "\t8. Ver responsable.\n"
                              "\t9. Salir.\n")

        if opcion == 1:
            opcion = 0
            while not 1 <= opcion <= 2:
                opcion = pedir_entero("¿Trabajaba antes aquí? 1. Sí 2. No")
            if opcion == 1:
                id = pedir_entero("¿Cuál era su id?")
                if comprobar_existe(trabajadores, id):
                    for trabajador in trabajadores:
                        if trabajador == id:
                            trabajadores[trabajador].activo = True
                            trabajador = trabajadores[trabajador]
                else:
                    print("¡Ese trabajador no existe!")
            else:
                idTrabajador += 1
                nombre = pedir_nombre("¿Cuál es el nombre?")
                apellidos = pedir_nombre("¿Cuál es el apellido?")
                dni = introducir_nif("¿Cuál es su DNI?")
                trabajador = Trabajador(idTrabajador, nombre, apellidos, dni)
                trabajadores[idTrabajador] = trabajador
            localidad = input("¿A qué localidad quiere ir?")
            asignar(talleres, trabajadores, trabajador, localidad)  # No creo que veas esto
            guardar(trabajadores)

        elif opcion == 2:
            existe = False
            empleado = pedir_entero("¿A quién quieres dar de baja?(id)")
            if not comprobar_existe(trabajadores, empleado):
                print("Ese empleado no existe")
            else:
                dar_baja(talleres, trabajadores, empleado)

        elif opcion == 3:
            for trabajador in trabajadores:
                mTrabajador = trabajadores[trabajador]
                print("{} {} {}".format(mTrabajador.getId(), mTrabajador.nombre, mTrabajador.apellidos))

        elif opcion == 4:
            for taller in talleres:
                mTaller = talleres[taller]
                print("{} {}".format(mTaller.getId(), mTaller.nombre))

        elif opcion == 5:
            for trabajador in trabajadores:
                mTrabajador = trabajadores[trabajador]
                if isinstance(mTrabajador, Responsable):
                    print("{} {} {}".format(mTrabajador.getId(), mTrabajador.nombre, mTrabajador.apellidos))

        elif opcion == 6:
            id = pedir_entero("¿A quién buscas?")
            if not comprobar_existe(trabajadores, id):
                print("No existe")
            else:
                mTrabajador = trabajadores[id]
                resultado = "{} {} {} {} {}".format(mTrabajador.getId(), mTrabajador.nombre, mTrabajador.apellidos, mTrabajador.getDni(), mTrabajador.isActivo())
                print(resultado)

        elif opcion == 7:
            id = input("¿Qué buscas?")
            if not comprobar_existe(talleres, id):
                print("No existe")
            else:
                for taller in talleres:
                    if talleres[taller].getId() == id:
                        mTaller = talleres[taller]
                        print("{} {} {} {}".format(mTaller.getId(), mTaller.nombre, mTaller.getEspecialidad(),
                                                   mTaller.localidad))

        elif opcion == 8:
            id = pedir_entero("¿A quién buscas?")
            if not comprobar_existe(trabajadores, id):
                print("No existe")
            else:
                existe = False
                for trabajador in trabajadores:
                    mTrabajador = trabajadores[trabajador]
                    if isinstance(mTrabajador, Responsable):
                        existe = True
                        print("{} {} {}".format(mTrabajador.getId(), mTrabajador.nombre, mTrabajador.apellidos))

                if not existe:
                    print("No es responsable")
        else:
            salir = True

        opcion = 0
