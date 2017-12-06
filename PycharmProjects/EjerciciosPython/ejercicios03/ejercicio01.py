"""Funciones"""


def hourToSeconds(horas=0, minutos=0, segundos=0):
    return horas * 3600 + minutos * 60 + segundos


def secondsToHour(n):
    segundos = n
    horas = int(segundos / 3600)
    segundos -= horas * 3600
    minutos = int(segundos / 60)
    segundos -= minutos * 60

    return str(horas) + ":" + str(minutos) + ":" + str(segundos)


"""Main"""

dato1 = input("Introduce una hora con este formato H:M:S ")
dato2 = input("Introduce otra hora con este formato H:M:S ")

dato1 = (dato1.split(":"))
dato2 = (dato2.split(":"))

segundos1 = hourToSeconds(int(dato1[0]), int(dato1[1]), int(dato1[2]))
segundos2 = hourToSeconds(int(dato2[0]), int(dato2[1]), int(dato2[2]))

print(secondsToHour(segundos1 + segundos2))
