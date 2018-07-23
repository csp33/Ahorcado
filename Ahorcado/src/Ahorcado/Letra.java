/* 
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
 */
package Ahorcado;

// Una letra almacena el carácter y un booleano que nos indica si la hemos adivinado.
// En esta implementación no se distingue entre mayúsculas, minúsculas y acentos.
import static java.lang.Character.toLowerCase;
import java.text.Collator;

public class Letra {

    private char letra;
    private boolean acertada = false;
    
    // Collator se usa para que los acentos no se tengan en cuenta.
    final Collator comparador = Collator.getInstance();

    //Constructor
    public Letra(char l) {
        letra = toLowerCase(l);
        comparador.setStrength(Collator.NO_DECOMPOSITION);
    }

    //Devuelve si la letra coincide con el parámetro. Si es así, actualizamos el atributo.
    public boolean comprobar(char otra) {
        // No tengo en cuenta mayúsculas y minúsculas
        otra = toLowerCase(otra);
        boolean iguales=comparador.compare(Character.toString(letra), Character.toString(otra))==0;

        if (iguales) {
            acertada = true;
        }
        return iguales;
    }

    //Nos dice si hemos acertado esa letra.
    public boolean acertada() {
        return acertada;
    }

    //Devuelve la letra si ha sido adivinada o un guión en caso contrario.
    public char getLetra() {
        return acertada ? letra : '-';
    }
}
