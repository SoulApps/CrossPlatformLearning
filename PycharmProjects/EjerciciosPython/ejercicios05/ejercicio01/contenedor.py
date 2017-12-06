class Contenedor:
    def __init__(self, capacidad):
        self.capacidad = capacidad
        self.mercancia = {}
        self.numMercancia = 0
        self.abierto = False

    def actualizarNumMercancia(self):
        self.numMercancia = 0
        for o in self.mercancia:
            self.numMercancia += self.mercancia[o].volumen

    def addMercancia(self, num, mercancia):
        if not self.abierto:
            print("No se puede añadir a un contenedor cerrado.")
            return
        if mercancia.asignado:
            print("Esa mercancia ya está en un contenedor.")
            return
        if self.numMercancia + mercancia.volumen > self.capacidad:
            print("La mercancia no cabe.")
            return

        self.mercancia[num] = mercancia
        self.actualizarNumMercancia()
        mercancia.asignado = True
