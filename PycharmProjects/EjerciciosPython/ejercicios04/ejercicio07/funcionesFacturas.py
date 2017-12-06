import time
from funciones.funciones import pedir_entero


def leerFicheroFactura(facturas):
    fichero = open("facturas.txt", "a+", encoding="UTF-8")
    longitud = fichero.tell()
    fichero.seek(0)
    facturas.clear()
    while fichero.tell() != longitud:
        linea = fichero.readline().replace("\n", "")  # Quito los saltos de línea.
        factura = linea.split(";")
        facturas.append(factura)

    fichero.close()


def agregarFactura(facturas, nif, concepto, importe, esNormal):
    fecha = time.strftime("%d/%m/%Y %H:%M:%S")
    if not esNormal:
        descuento = 0
        while descuento <= 0:
            descuento = pedir_entero("Introduce el valor del descuento. ")
        importe -= importe * descuento / 100
    facturas.append([nif, concepto, importe, fecha])
    actualizarFicheroFactura(facturas)


def actualizarFicheroFactura(facturas):
    fichero = open("facturas.txt", "w", encoding="UTF-8")
    for factura in facturas:
        nif = factura[0]
        concepto = factura[1]
        importe = factura[2]
        fecha = factura[3]
        fichero.write("{};{};{};{}\n".format(nif, concepto, importe, fecha))
    fichero.close()
