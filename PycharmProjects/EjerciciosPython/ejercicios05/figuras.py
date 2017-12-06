import math


class Figura:
    def __init__(self, base, altura):
        self._base = base
        self._altura = altura

    def area(self):
        pass

    def perimetro(self):
        pass


class Rectangulo(Figura):
    def __init__(self, base, altura):
        super(Rectangulo, self).__init__(base, altura)

    def area(self):
        return self._base * self._altura

    def perimetro(self):
        return self._base * 2 + self._altura * 2


class Triangulo(Figura):
    def __init__(self, base, altura):
        super(Triangulo, self).__init__(base, altura)

    def area(self):
        return self._base * self._altura / 2

    def perimetro(self):
        return self._base * 4


class Rombo(Figura):
    def __init__(self, base, altura):
        super(Rombo, self).__init__(base, altura)

    def area(self):
        return self._base * self._altura / 2

    def perimetro(self):
        return self._base * 4


class Trapecio(Figura):
    def __init__(self, base, altura):
        super(Trapecio, self).__init__(base, altura)

    def area(self):
        return self._base * self._altura

    def perimetro(self):
        return self._base * 2 + self._altura * 2


class Paralelogramo(Figura):
    def __init__(self, base, altura):
        super(Paralelogramo, self).__init__(base, altura)

    def area(self):
        return self._base * self._altura

    def perimetro(self):
        return self._base * 2 + self._altura * 2


triangulo = Triangulo(4, 5)
print(triangulo.area())
