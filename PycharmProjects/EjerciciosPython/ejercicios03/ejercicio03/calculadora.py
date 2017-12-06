from ejercicios03.ejercicio03.funciones import *

"""print(globals())
print(locals())"""


signo = 0
n1 = pedir_entero("Mete el primer número ")
n2 = pedir_entero("Mete el segundo número ")

while signo <= 0 or signo >= 5:
    signo = pedir_entero("¿Qué operación quieres hacer? 1.Suma 2.Resta 3.Multiplicación 4.Dividir ")

comprobarOperacion(n1, n2, signo)
