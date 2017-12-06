from ejercicios05.ejercicio03.material import Material


class Libro(Material):
    def __init__(self, nombre):
        super(Libro, self).__init__(nombre)
