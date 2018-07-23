/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazTextual;

import Ahorcado.Palabra;
import java.util.Scanner;

/**
 *
 * @author csp98
 */
public class AhorcadoTextual {

    static final int MAX_ERRORES = 10;
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static String solicitarPalabra() {
        System.out.println("Introduzca la palabra a adivinar:\n");
        String resultado = sc.nextLine();
        return resultado;
    }

    public static char solicitarLetra() {
        char resultado = sc.next().charAt(0);
        return resultado;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        String entrada;
        Palabra p;
        char actual, repetir;
        boolean seguir = true;
        int errores = 0;
        while (seguir) {
            entrada = solicitarPalabra();
            p = new Palabra(entrada);
            do {
                System.out.println("Introduzca una letra:\n");
                actual = solicitarLetra();
                if (p.contiene(actual)) {
                    System.out.println("La palabra contiene la letra " + actual + "\n");

                } else {
                    System.out.println("La palabra no contiene la letra " + actual + "\n");
                    errores++;
                }
                System.out.println("\t\t" + p.getPalabra() + "\n");
            } while (errores < MAX_ERRORES && !p.acertada());

            if (errores == MAX_ERRORES) {
                System.out.println("¡Perdiste! La palabra era " + entrada + "\n");
            } else {
                System.out.println("¡Enhorabuena, ganaste! ");
            }
            System.out.println(" ¿Quieres jugar de nuevo? [S/N]");
            repetir = solicitarLetra();
            seguir = repetir == 'S' || repetir == 's';
        }
    }
}
