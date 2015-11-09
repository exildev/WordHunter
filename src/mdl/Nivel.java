package mdl;

import java.util.HashMap;
import java.util.Map;
import processing.core.PImage;

/**
 *
 * @author Migue
 */
public abstract class Nivel extends Agente {

    public static final int width = 800;
    public static final int height = 600;
    private int totaltime;
    private final int xcelda = 128;
    private final int ycelda = 128;
    private final int w = 10;
    private final int h = 10;
    private final Letra letras[][];
    private final Map<Character, PImage> imgs;
    private final String[] palabras;

    public Nivel(PImage fondo, String[] palabras, int totaltime) {
        super(fondo, 0, 0);
        this.imgs = new HashMap<Character, PImage>();
        this.palabras = palabras;
        this.letras = new Letra[w][h];
        this.totaltime = totaltime;
    }

    void cargarImagen(char letra, PImage imagen) {
        this.imgs.put(letra, imagen);
    }

    public void ponerLetra(int cx, int cy, char car) {
        letras[cx][cy] = new Letra(imgs.get(car), (cx + 1) * xcelda, (cy + 1) * ycelda);
        letras[cx][cy].setIletra(ILetra.getInstance(car));
        Sound.play("toc");
    }

    public void ponerPalabra(int palabra) {
        char chars[] = palabras[palabra].toCharArray();
        for (char car : chars) {
            int cx = 0;
            int cy = 0;
            do {
                cx = (int) (Math.floor(Math.random() * 5) + 0);
                cy = (int) (Math.floor(Math.random() * 4) + 0);
            } while (letras[cx][cy] != null);
            ponerLetra(cx, cy, car);
        }

    }

    public void run() {
        if (totaltime > time) {
            super.run();
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (letras[i][j] != null) {
                        letras[i][j].run();
                    }
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (letras[i][j] != null && letras[i][j].isTodel()) {
                        letras[i][j] = null;
                    }
                }
            }

            Lapix.getInstance().run();
        }
    }

    public void draw() {
        super.draw();
        fill(20, 20, 10);
        textSize(25);
        text("Time: " + (totaltime - time), 500, 40);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (letras[i][j] != null) {
                    letras[i][j].draw();
                }
            }
        }

        Lapix.getInstance().draw();
        
        if (totaltime <= time) {
            fill(100, 100, 100);
            rect(100, 100, 600, 400);
            fill(200, 200, 200);
            text("Score: " + Lapix.getInstance().getScore(), 200, 200);
        }
    }

    public void moverLapixA(float mouseX, float mouseY) {
        if (totaltime > time) {
            Lapix.getInstance().moverA(mouseX, mouseY);
        }
    }
}
