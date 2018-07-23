package Ahorcado;

// Una letra almacena el carácter y un booleano que nos indica si la hemos adivinado.
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
