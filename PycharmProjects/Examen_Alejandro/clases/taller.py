class Taller:
    def __init__(self, nombre, id, especialidad, localidad):
        self.nombre = nombre
        self._id = id
        self._especialidad = especialidad
        self.localidad = localidad
        self.responsable = False
        self.trabajadores = []

    def getId(self):
        return self._id

    def setId(self, id):
        self._id = id

    def getEspecialidad(self):
        return self._especialidad

    def setEspecialidad(self, especialidad):
        self._especialidad = especialidad

    def isDisponible(self):
        activos = 0
        for trabajador in self.trabajadores:
            if trabajador.isActivo:
                activos += 1
        if activos < 5:
            return True
        else:
            return False

    # _id = property(getId, setId)
    # _especialidad = property(getEspecialidad, setEspecialidad)
