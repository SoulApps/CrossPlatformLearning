def leerFicheroClientes(clientes):
    fichero = open("clientes.txt", "a+", encoding="UTF-8")
    longitud = fichero.tell()
    fichero.seek(0)
    clientes.clear()
    while fichero.tell() != longitud:
        linea = fichero.readline().replace("\n", "")  # Quito los saltos de línea.
        cliente = linea.split(";")
        nif = cliente[0]
        nombre = cliente[1]
        apellidos = cliente[2]
        direccion = cliente[3]
        tipo = cliente[4]
        clientes[nif] = [nombre, apellidos, direccion, tipo]
    fichero.close()


def agregarCliente(clientes, nif, nombre, apellidos, direccion, tipo):
    clientes[nif] = [nombre, apellidos, direccion, tipo]
    actualizarFicheroClientes(clientes)


def actualizarFicheroClientes(clientes):
    fichero = open("clientes.txt", "w", encoding="UTF-8")
    for cliente in clientes:
        nif = cliente
        nombre = clientes[cliente][0]
        apellidos = clientes[cliente][1]
        direccion = clientes[cliente][2]
        tipo = clientes[cliente][3]
        fichero.write("{};{};{};{};{}\n".format(nif, nombre, apellidos, direccion, tipo))
    fichero.close()


def comprobarCliente(nif, clientes):
    for cliente in clientes:
        if cliente == nif:
            return True
    return False


def getTipo(cliente, clientes):
    if clientes[cliente][3] == "1":
        return True
    return False
