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

import java.util.ArrayList;

// Una palabra está formada por un vector de letras.
public class Palabra {

    private ArrayList<Letra> palabra;
    private String solucion;

    //Constructor
    public Palabra(String entrada) {
        palabra = new ArrayList(entrada.length());
        for (int i = 0; i < entrada.length(); i++) {
            palabra.add(new Letra(entrada.charAt(i)));
        }
    }

    // Indica si la palabra contiene la letra especiicada.
    public boolean contiene(char c) {
        boolean resultado = false;
        for (int i = 0; i < palabra.size(); i++) {
            if (palabra.get(i).comprobar(c)) {
                resultado = true;
            }
        }
        return resultado;
    }

    // Indica si se ha llegado al fin del juego
    public boolean acertada() {
        for (Letra l : palabra) {
            if (!l.acertada()) {
                return false;
            }
        }
        return true;
    }

    //Devuelve la letra si ha sido adivinada o un guión en caso contrario.
    public String getPalabra() {
        String resultado = "";
        for (Letra l : palabra) {
            resultado += l.getLetra();
        }
        return resultado;
    }

}
