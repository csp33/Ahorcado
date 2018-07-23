
package Ahorcado;

import java.util.ArrayList;

// Una palabra está formada por un vector de letras.
public class Palabra {

    private ArrayList<Letra> palabra;

    public Palabra(String entrada) {
        palabra = new ArrayList(entrada.length());
        for (int i = 0; i < entrada.length(); i++) {
            palabra.add(new Letra(entrada.charAt(i)));
        }
    }

    // Indica si la palabra contiene la letra especiicada.
    public boolean contiene(char c) {
        boolean resultado = false;
        for (Letra l : palabra) {
            if (l.comprobar(c)) {
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
            resultado+= l.getLetra();
        }
        return resultado;
    }

}
