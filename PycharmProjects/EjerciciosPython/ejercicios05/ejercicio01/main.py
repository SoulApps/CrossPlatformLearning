from funciones.funciones import pedir_entero
from ejercicios05.ejercicio01.caja import Caja
from ejercicios05.ejercicio01.contenedor import Contenedor
from ejercicios05.ejercicio01.cubo import Cubo


salir = False
opcion = numContenedor = numMercancia = aux = 0
contenedores = {}
mercancias = {}

while not salir:
    capacidad = ancho = alto = fondo = 0
    while not 1 <= opcion <= 7:
        opcion = pedir_entero("\n¿Qué quieres hacer?\n"
                              "\t1. Crear contenedor.\n"
                              "\t2. Crear mercancía.\n"
                              "\t3. Mostrar contenedores.\n"
                              "\t4. Mostrar mercancias sin asignar.\n"
                              "\t5. Añadir mercancía a contenedor.\n"
                              "\t6. Abrir contenedor.\n"
                              "\t7. Salir\n")

    if opcion == 1:
        while capacidad <= 0:
            capacidad = pedir_entero("¿De qué capacidad?")
        numContenedor += 1
        contenedores[numContenedor] = Contenedor(capacidad)

    elif opcion == 2:
        opcion = 0
        numMercancia += 1
        while not 1 <= opcion <= 2:
            opcion = pedir_entero("\n¿Qué tipo de mercancia quieres crear?\n"
                                  "\t1. Crear caja.\n"
                                  "\t2. Crear cubo.\n")
            if opcion == 1:
                while ancho <= 0:
                    ancho = pedir_entero("¿Con qué ancho?")
                while alto <= 0:
                    alto = pedir_entero("¿Con qué alto?")
                while fondo <= 0:
                    fondo = pedir_entero("¿Con qué fondo?")
                mercancias[numMercancia] = Caja(ancho, alto, fondo)
            elif opcion == 2:
                while ancho <= 0:
                    ancho = pedir_entero("¿Con qué capacidad?")
                mercancias[numMercancia] = Cubo(ancho)

    elif opcion == 3:
        for o in contenedores:
            print("[Número: {}] [Capacidad: {} de {}] [Estado: {}]".format(o, contenedores[o].numMercancia, contenedores[o].capacidad, "Abierto" if contenedores[o].abierto else "Cerado"))
            for m in contenedores[o].mercancia:
                tipo = "Cubo" if isinstance(contenedores[o].mercancia[m], Cubo) else "Caja"
                print("\t[Número: {}] [Volumen: {}] [Tipo: {}]".format(m, contenedores[o].mercancia[m].volumen, tipo))

    elif opcion == 4:
        for o in mercancias:
            if not mercancias[o].asignado:
                tipo = "Cubo" if isinstance(mercancias[o], Cubo) else "Caja"
                print("[Número: {}] [Volumen: {}] [Tipo: {}]".format(o, mercancias[o].volumen, tipo))

    elif opcion == 5:
        mercancia = 0
        while not 1 <= mercancia <= numMercancia:
            mercancia = pedir_entero("¿Qué mercancia quieres guardar?")
        contenedor = 0
        while not 1 <= contenedor <= numContenedor:
            contenedor = pedir_entero("¿Dónde la quieres guardar?")
        contenedores[contenedor].addMercancia(mercancia, mercancias[mercancia])

    elif opcion == 6:
        if numContenedor != 0:
            while not 1 <= opcion <= numContenedor:
                opcion = pedir_entero("¿Qué contenedor quieres abrir?")
            contenedores[opcion].abierto = True
            print("Contenedor abierto.")
        else:
            print("No hay contenedores que abrir o cerrar.")

    else:
        salir = True
        print("Adiós")

    opcion = 0  # Para que vuelva a entrar bien en el bucle.
