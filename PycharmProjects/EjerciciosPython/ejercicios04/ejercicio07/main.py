from funciones.funciones import *
from ejercicios04.ejercicio07.funcionesClientes import *
from ejercicios04.ejercicio07.funcionesFacturas import *
from ejercicios04.ejercicio07.funcionesInformes import *


clientes = {}
facturas = []

leerFicheroClientes(clientes)
leerFicheroFactura(facturas)

salir = False
opcion = 0
while not salir:
    while not 1 <= opcion <= 5:
        opcion = pedir_entero("\n¿Qué quieres hacer?\n"
                              "\t1. Añadir cliente.\n"
                              "\t2. Añadir factura a cliente.\n"
                              "\t3. Generar factura por cliente.\n"
                              "\t4. Generar informe general del mes.\n"
                              "\t5. Salir\n")

    if opcion == 1:
        tipo = 0
        while not 1 <= tipo <= 2:
            tipo = pedir_entero("\n¿Qué tipo de cliente es?\n"
                                "\t1. Normal\n"
                                "\t2. Preferente")
        nif = introducir_nif("¿Cuál es el NIF? ")
        nombre = pedir_nombre("¿Cuál es su nombre? ")
        apellidos = pedir_nombre("¿Cuáles son sus apellidos? ")
        direccion = input("¿Cuál es su dirección? ")

        if comprobarCliente(nif, clientes):
            print("Ese cliente ya existe.")
        else:
            agregarCliente(clientes, nif, nombre, apellidos, direccion, tipo)
            print("Cliente creado.")

    elif opcion == 2:
        nif = input("¿A qué cliente le quieres añadir una factura? ")
        if not comprobarCliente(nif, clientes):
            print("Ese cliente no existe.")
        else:
            esNormal = getTipo(nif, clientes)
            importe = 0
            while importe <= 0:
                importe = pedir_decimal("¿Con qué importe? ")
            concepto = input("¿Cuál es el concepto?")
            agregarFactura(facturas, nif, concepto, importe, esNormal)
            print("Factura creada.")

    elif opcion == 3:
        nif = input("¿De qué cliente quieres hacer un informe? ")
        if not comprobarCliente(nif, clientes):
            print("Ese cliente no existe.")
        else:
            informe = generarInformeCliente(clientes, facturas, nif)
            print(informe)
            guardar = 0
            while not 1 <= guardar <= 2:
                guardar = pedir_entero("¿Quieres guardar el informe? 1.Sí 2.No ")
            if guardar == 1:
                exportarInformeCliente(nif, informe)

    elif opcion == 4:
        informe = generarInformeGeneral(clientes, facturas)
        print(informe)
        guardar = 0
        while not 1 <= guardar <= 2:
            guardar = pedir_entero("¿Quieres guardar el informe? 1.Sí 2.No ")
        if guardar == 1:
            exportarInformeGeneral(informe)

    else:
        salir = True
        print("Adiós")

    opcion = 0  # Para que vuelva a entrar bien en el bucle.
