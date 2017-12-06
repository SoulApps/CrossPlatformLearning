salir = False
while not salir:
    datoMal = True
    importe = 0
    total = 0

    while importe < 500:
        importe = int(input("Mete un importe "))

    if 500 <= importe <= 1500:
        intereses = importe * 20 / 100
    elif 1501 <= importe <= 3000:
        intereses = importe * 15 / 100
    elif 3001 <= importe <= 6000:
        intereses = importe * 12 / 100
    elif importe >= 6000:
        intereses = importe * 10 / 100

    total = importe + intereses

    while datoMal:
        descuento = int(input("¿Aplicar descuento? 1.Sí 2.No "))
        if descuento == 1 or descuento == 2:
            datoMal = False
            if descuento == 1:
                total /= 1.03
            print("Intereses:", descuento, "Total:", total)

    datoMal = True
    while datoMal:
        pregunta = int(input("¿Quieres salir? 1.Sí 2.No "))
        if pregunta == 1 or pregunta == 2:
            datoMal = False
            if pregunta == 1:
                salir = True

print("Adiós")
