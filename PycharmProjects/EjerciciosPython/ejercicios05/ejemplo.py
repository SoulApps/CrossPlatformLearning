class Vehiculo():
    def __init__(self, color, ancho, alto, largo, ruedas, gasolina):
        self.color = color
        self.ancho = ancho
        self.alto = alto
        self.largo = largo
        self.ruedas = ruedas
        self.gasolina = gasolina

    def acelerar(self):
        if self.gasolina > 0:
            self.gasolina -= 1
            print("Acelerando vehículo.")
        else:
            print("No hay gasofa en el vehículo.")

    def frenar(self):
        print("Frenando vehículo.")

    def arrancar(self):
        if self.gasolina > 0:
            self.gasolina -= 1
            print("Arrancando vehículo.")
        else:
            print("No hay gasofa en el vehículo.")

    def conducir(self):
        print("Quedan {} litros de gasofa en el vehículo.".format(self.gasolina))


class Moto(Vehiculo):
    def __init__(self, color):
        Vehiculo.__init__(self, color, 0, 0, 0, 2, 0)
        self.marcha = 0

    def arrancar(self):
        if self.gasolina > 0:
            self.gasolina -= 1
            print("Arrancando moto.")
        else:
            print("No hay gasofa en la moto.")

    def cambiarMarcha(self, marcha):
        if 0 <= marcha <= 5:
            self.marcha = marcha
            print("Marcha:", self.marcha)
        else:
            print("Esa marcha no es válida.")


coche = Vehiculo("azul", 2, 2, 4, 5, 10)
coche.conducir()
coche.arrancar()
coche.acelerar()
coche.frenar()
coche.conducir()

moto = Moto("rojo")
moto.arrancar()
moto.acelerar()
moto.cambiarMarcha(1)
moto.cambiarMarcha(2)
