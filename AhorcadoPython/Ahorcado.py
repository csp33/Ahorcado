from Palabra import Palabra

def solicitarPalabra():
    print("Introduzca la palabra a adivinar:")
    palabra=input()
    if not palabra.isalpha():
        print("¡Sólo se permiten letras!")
        palabra=solicitarPalabra()
    return palabra

def solicitarLetra():
    print("Introduzca una letra:")
    letra=input()
    if not letra.isalpha():
        print("¡Sólo se permiten letras!")
        letra=solicitarLetra()
    return letra[0]

def seguirJugando():
    print(" ¿Quieres jugar de nuevo? [S/N]")
    lectura=input()
    lectura=tolower(lectura)
    if lectura != "s" or lectura != "n":
        seguir=seguirJugando()
    seguir=lectura=="s"
    return seguir

MAX_ERRORES=7

def __init__():
    seguir=True
    while seguir:
        entrada=solicitarPalabra()
        p=Palabra(entrada)
        errores=0
        while errores<MAX_ERRORES and not p.acertada():
            print("\t\t"+p.getPalabra())
            print("Vidas restantes: "+str(MAX_ERRORES-errores))
            actual=solicitarLetra()
            print("Errores: "+errores)
            if not p.contiene(actual):
                errores+=1
        if errores==MAX_ERRORES:
            print("¡Perdiste! La palabra era " + entrada)
        else:
            print("¡Enhorabuena, ganaste! ")
        seguir=seguirJugando()


__init__()
