
package Ahorcado;

// Una letra almacena el carácter y un booleano que nos indica si la hemos adivinado.
public class Letra {

    private char letra;
    private boolean acertada = false;

    public Letra(char l) {
        letra = l;
    }

    public boolean comprobar(char otra) {
        if(letra==otra)
            acertada=true;
        //acertada = letra == otra;
        return acertada;
    }

    public boolean acertada() {
        return acertada;
    }

    //Devuelve la letra si ha sido adivinada o un guión en caso contrario.
    public char getLetra(){
        char resultado='-';
        if(acertada)
            resultado=letra;
        return resultado;            
    }
}
