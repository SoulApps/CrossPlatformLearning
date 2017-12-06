class Trabajador:
    def __init__(self, id, nombre, apellidos, dni):
        self._id = id
        self.nombre = nombre
        self.apellidos = apellidos
        self._dni = dni
        self._activo = True
        self.asignado = False

    def getId(self):
        return self._id

    def setId(self, id):
        self._id = id

    def getDni(self):
        return self._dni

    def setDni(self, dni):
        self._dni = dni

    def isActivo(self):
        return self._activo

    def setActivo(self, activo):
        self._activo = activo

    # _id = property(getId, setId)
    # _dni = property(getDni, setDni)
    # _activo = property(isActivo, setActivo)
