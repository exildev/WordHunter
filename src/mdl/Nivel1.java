package mdl;

import processing.core.PImage;

/**
 *
 * @author Migue
 */
public class Nivel1 extends Nivel {

    public Nivel1(PImage fondo) {
        super(fondo, new String[]{
            "AA",
            "ABA",
            "A",
            "BBB"
        }, 500);
    }

    public void setup() {
        this.cargarImagen('A', loadImage("src/img/a.png"));
        this.cargarImagen('B', loadImage("src/img/b.png"));

        for (int i = 0; i < 100; i++) {
            runIn(i*70, new Runnable() {
                public void run() {
                    ponerPalabra(0);
                }
            });
        }
        for (int i = 0; i < 100; i++) {
            runIn(i*80, new Runnable() {
                public void run() {
                    ponerPalabra(1);
                }
            });
        }
        for (int i = 0; i < 100; i++) {
            runIn(i*90, new Runnable() {
                public void run() {
                    ponerPalabra(2);
                }
            });
        }
        for (int i = 1; i < 10; i++) {
            runIn(i*200, new Runnable() {
                public void run() {
                    ponerPalabra(3);
                }
            });
        }
    }

}
