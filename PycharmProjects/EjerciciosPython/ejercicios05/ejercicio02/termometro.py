from ejercicios05.ejercicio02.aparato import Aparato


class Termometro(Aparato):
    def __init__(self):
        super().__init__()

    def getDatos(self):
        return "T: {} ºC".format(self._medida)
