"""
 * Copyright (C) 2018 csp98
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 """
from Palabra import Palabra

def solicitar_palabra():
    print("Introduzca la palabra a adivinar:")
    palabra=input()
    if not palabra.isalpha():
        print("¡Sólo se permiten letras!")
        palabra=solicitar_palabra()
    return palabra

def solicitar_letra():
    print("Introduzca una letra:")
    letra=input()
    if not letra.isalpha():
        print("¡Sólo se permiten letras!")
        letra=solicitar_letra()
    return letra[0]

def seguir_jugando():
    print(" ¿Quieres jugar de nuevo? [S/N]")
    lectura=input()
    lectura=lectura.lower()
    if lectura != "s" and lectura != "n":
        seguir=seguir_jugando()
    seguir=lectura=="s"
    return seguir

MAX_ERRORES=7

def __init__():
    seguir=True
    while seguir:
        entrada=solicitar_palabra()
        p=Palabra(entrada)
        errores=0
        while errores<MAX_ERRORES and not p.acertada():
            print("\t\t"+p.get_palabra())
            print("Vidas restantes: "+str(MAX_ERRORES-errores))
            actual=solicitar_letra()
            if not p.contiene(actual):
                errores+=1
        if errores==MAX_ERRORES:
            print("¡Perdiste! La palabra era " + entrada)
        else:
            print("¡Enhorabuena, ganaste! ")
        seguir=seguir_jugando()


__init__()
