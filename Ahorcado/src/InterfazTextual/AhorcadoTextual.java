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
package InterfazTextual;

import Ahorcado.Palabra;
import static java.lang.Character.toLowerCase;
import java.util.Scanner;

public class AhorcadoTextual {

    static final int MAX_ERRORES = 5;

    //Solicita una línea de la entrada estándar.
    public static String solicitarPalabra() {
        Scanner sc = new Scanner(System.in);    //Debe ser local para que se destruya y no queden residuos.
        System.out.println("Introduzca la palabra a adivinar:\n");
        String resultado = sc.nextLine();
        if (resultado.contains(" ")) {
            System.out.println("¡No se permiten espacios!");
            resultado = solicitarPalabra();
        }
        return resultado;
    }

    //Solicita una única letra de la entrada estándar.
    public static char solicitarLetra() {
        Scanner sc = new Scanner(System.in);
        char resultado = sc.next().charAt(0);
        return resultado;
    }

    //Pregunta al jugador si quiere jugar otra partida. Incluye filtro de entrada.
    public static boolean seguirJugando() {
        char lectura;
        do {
            System.out.println(" ¿Quieres jugar de nuevo? [S/N]");
            lectura = solicitarLetra();
            lectura = toLowerCase(lectura);
        } while (lectura != 's' && lectura != 'n');

        return lectura == 's';
    }

    //Método main
    public static void main(String[] args) {
        String entrada;
        Palabra p;
        char actual;
        boolean seguir = true;
        int errores;
        int vidas;
        while (seguir) {
            //Inicializamos variables
            errores = 0;
            entrada = solicitarPalabra();
            p = new Palabra(entrada);
            //Entramos al juego
            do {
                //Informamos del estado actual
                System.out.println("\t\t" + p.getPalabra() + "\n");
                System.out.println("Vidas restantes: " + (MAX_ERRORES - errores) + "\n");
                //Pedimos letra
                System.out.println("Introduzca una letra:\n");
                actual = solicitarLetra();
                //Anotamos el error si lo hemos cometido
                System.out.println("Errores: " + (errores) + "\n");
                if (!p.contiene(actual)) {
                    errores++;
                }
            } while (errores < MAX_ERRORES && !p.acertada());
            //Fin del juego.
            if (errores == MAX_ERRORES) {
                System.out.println("¡Perdiste! La palabra era " + entrada + "\n");
            } else {
                System.out.println("¡Enhorabuena, ganaste! ");
            }
            //Preguntamos si se quiere jugar otra vez
            seguir = seguirJugando();
        }
    }
}
