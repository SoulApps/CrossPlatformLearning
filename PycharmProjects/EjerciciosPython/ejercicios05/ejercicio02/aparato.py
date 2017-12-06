from random import randint


class Aparato:
    def __init__(self):
        self._medida = randint(5, 15)

    def getDatos(self):
        pass

    def getMedida(self):
        return self._medida
