from ejercicios05.ejercicio02.aparato import Aparato


class Barometro(Aparato):
    def __init__(self):
        super().__init__()

    def getDatos(self):
        return "H: {} Mb".format(self._medida)
