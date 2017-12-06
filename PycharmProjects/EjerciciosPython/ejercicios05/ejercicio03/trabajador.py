from ejercicios05.ejercicio03.persona import Persona


class Trabajador(Persona):
    def __init__(self, nombre):
        super(Trabajador, self).__init__(nombre)
