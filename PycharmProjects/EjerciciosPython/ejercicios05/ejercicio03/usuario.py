from ejercicios05.ejercicio03.persona import Persona


class Usuario(Persona):
    def __init__(self, nombre):
        super(Usuario, self).__init__(nombre)
        self.material = False

    def asignarMaterial(self, material):
        self.material = material

    def devolverMaterial(self):
        aux = self.material
        self.material.asingado = False
        self.material = False
        return aux
