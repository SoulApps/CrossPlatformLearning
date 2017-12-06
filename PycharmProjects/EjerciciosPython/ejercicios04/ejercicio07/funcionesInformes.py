import time


def generarInformeCliente(clientes, facturas, nif):
    total = 0

    nombre = clientes[nif][0]
    apellidos = clientes[nif][1]
    direccion = clientes[nif][2]
    tipo = "Normal" if clientes[nif][3] == "1" else "Preferente"

    resultado = "Nombre: {}\n" \
                "Apellidos: {}\n" \
                "Dirección: {}\n" \
                "Tipo de cliente {}\n" \
                "Facturas: \n".format(nombre, apellidos, direccion, tipo)

    for factura in facturas:
        if factura[0] == nif:  # Comprobar fecha...
            concepto = factura[1]
            importe = float(factura[2])
            fecha = factura[3]
            resultado += "\tConcepto: {}\n" \
                         "\tImporte: {}\n" \
                         "\tFecha: {}\n\n".format(concepto, importe, fecha)
            total += importe
    resultado += "Total: {}".format(total)
    return resultado


def generarInformeGeneral(clientes, facturas):
    resultado = ""
    total = 0
    for cliente in clientes:
        nombre = clientes[cliente][0]
        apellidos = clientes[cliente][1]
        direccion = clientes[cliente][2]
        tipo = "Normal" if clientes[cliente][3] == "1" else "Preferente"

        totalCliente = 0
        for factura in facturas:
            if factura[0] == cliente and factura[3].split("/")[1] == time.strftime("%m"):
                totalCliente += float(factura[2])

        total += totalCliente

        resultado += "Nombre: {}\n" \
                "Apellidos: {}\n" \
                "Dirección: {}\n" \
                "Tipo de cliente {}\n" \
                "Facturas: {}\n\n".format(nombre, apellidos, direccion, tipo, totalCliente)

    resultado += "Total: {}".format(total)
    return resultado


def exportarInformeCliente(nif, informe):
    nombre = "{}.txt".format(nif)
    fichero = open(nombre, "w", encoding="UTF-8")
    fichero.write(informe)
    fichero.close()


def exportarInformeGeneral(informe):
    fichero = open("informe.txt", "w", encoding="UTF-8")
    fichero.write(informe)
    fichero.close()
