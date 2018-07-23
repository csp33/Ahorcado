package Ahorcado;

// Una letra almacena el carácter y un booleano que nos indica si la hemos adivinado.
public class Letra {

    private char letra;
    private boolean acertada = false;
    
    //Constructor
    public Letra(char l) {
        letra = l;
    }

    //Devuelve si la letra coincide con el parámetro. Si es así, actualizamos el atributo.
    public boolean comprobar(char otra) {
        if (letra == otra) {
            acertada = true;
        }
        return letra == otra;
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
