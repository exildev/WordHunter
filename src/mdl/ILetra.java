package mdl;

import processing.core.PApplet;

/**
 *
 * @author Migue
 */
public abstract class ILetra extends PApplet {

    private final char letra;

    public ILetra(char letra) {
        this.letra = letra;
    }

    public static ILetra getInstance(char letra) {
        ILetra iletra = null;
        if (letra == 'A') {
            iletra = new LetraA();
        } else if (letra == 'B') {
            iletra = new LetraB();
        }
        return iletra;
    }

    public abstract void setup(Letra letra);

    public abstract void run(Letra letra);

    public char getLetra() {
        return letra;
    }

}
