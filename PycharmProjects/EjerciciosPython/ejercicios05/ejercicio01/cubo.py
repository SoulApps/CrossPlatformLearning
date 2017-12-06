from ejercicios05.ejercicio01.caja import Caja


class Cubo(Caja):
    def __init__(self, dimension):
        super(Cubo, self).__init__(dimension, dimension, dimension)
