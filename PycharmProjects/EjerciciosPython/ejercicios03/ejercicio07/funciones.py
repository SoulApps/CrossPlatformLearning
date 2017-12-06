

def comprobar_nick(nick):
    if len(nick) < 6:
        return "El nombre de usuario debe contener al menos 6 caracteres."
    elif len(nick) > 12:
        return "El nombre de usuario no puede contener más de 12 caracteres."
    else:
        tiene_numeros = False
        tiene_letras = False

        i = 0
        while i < len(nick):
            if 48 <= ord(nick[i]) <= 57:
                tiene_numeros = True
            elif 65 <= ord(nick[i]) <= 90 or 97 <= ord(nick[i]) <= 122:
                tiene_letras = True
            i += 1

        if not tiene_numeros:
            return "El nick debe contener algún número."
        elif not tiene_letras:
            return "nick debe contener alguna letra."
        else:
            return True


def comprobar_passwd(passwd):
    if len(passwd) < 8:
        return "La contraseña debe contener al menos 8 caracteres."
    elif " " in passwd:
        return "La contraseña no puede tener espacios."
    else:
        tiene_numeros = False
        tiene_mayusculas = False
        tiene_minusuculas = False
        tiene_otros = False

        i = 0
        while i < len(passwd):
            if 48 <= ord(passwd[i]) <= 57:
                tiene_numeros = True
            elif 65 <= ord(passwd[i]) <= 90:
                tiene_mayusculas = True
            elif 97 <= ord(passwd[i]) <= 122:
                tiene_minusuculas = True
            elif 33 <= ord(passwd[i]) <= 47 or 58 <= ord(passwd[i]) <= 64:
                tiene_otros = True
            i += 1

        if not tiene_numeros:
            return "La contraseña debe contener números."
        elif not tiene_mayusculas:
            return "La contraseña debe contener mayúsculas."
        elif not tiene_minusuculas:
            return "La contraseña debe contener minúsculas."
        elif not tiene_otros:
            return "La contraseña debe contener caracteres no alfanuméricos."
        else:
            return True
