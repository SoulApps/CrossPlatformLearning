from clases.trabajador import Trabajador


class Responsable(Trabajador):
    def __init__(self, id, nombre, apellidos, dni, telefono, ss):
        super(Responsable, self).__init__(id, nombre, apellidos, dni)
        self.telefono = telefono
        self.ss = ss
