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

 # Una
class Letra:

    #Constructor
    def __init__(self,letra):
        self.letra=letra
        self.acertada=False

    #Devuelve si la letra coincide con el parámetro. Si es así, actualizamos el atributo.
    def comprobar(self,otra):
        iguales=self.letra.lower()==otra.lower()
        if iguales:
            self.acertada=True
        return iguales

    #Devuelve la letra si ha sido adivinada o un guión en caso contrario.
    def get_letra(self):
        return ('-',self.letra)[self.acertada]
