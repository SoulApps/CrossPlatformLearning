import time
from random import randint

from ejercicios05.ejercicio02.barometro import Barometro
from ejercicios05.ejercicio02.termometro import Termometro


class CasetaMeteo:
    def __init__(self, formato_normal):
        self._barometro = Barometro()
        self._termometro = Termometro()
        self._formato_normal = formato_normal
        self._existeProbabilidadLluvia = False

    def getObservaciones(self):
        n = randint(0, 1)
        if self._formato_normal:
            fecha = time.strftime("%d/%m/%Y")
        else:
            fecha = time.strftime("%m/%d/%Y")

        resultado = "{} {} - {}\n".format(fecha, self._termometro.getDatos(), self._barometro.getDatos())
        if self._barometro.getMedida() < 10:
            probable = True
        else:
            probable = False

        if n == 1:
            self._existeProbabilidadLluvia = probable
            self.guardarObservaciones(resultado)
            return resultado
        else:
            n = randint(0, 1)
            if n == 1:
                self._existeProbabilidadLluvia = probable
                self.guardarObservaciones(resultado)
                return resultado
            else:
                return "--\n"

    def guardarObservaciones(self, resultado):
        fichero = open("log.txt", "a+", encoding="UTF-8")
        fichero.write(resultado)
        fichero.close()

    def existeProbabilidadLluvia(self):
        return self._existeProbabilidadLluvia

    def getTermometro(self):
        return self._termometro

    def getBarometro(self):
        return self._barometro
