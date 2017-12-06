from ejercicios05.ejercicio01.mercancia import Mercancia


class Caja(Mercancia):
    def __init__(self, ancho, alto, fondo):
        super(Caja, self).__init__()
        self.ancho = ancho
        self.alto = alto
        self.fondo = fondo
        self.volumen = ancho * alto * fondo
