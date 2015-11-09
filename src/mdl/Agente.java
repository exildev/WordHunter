package mdl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Migue
 */
public abstract class Agente extends PApplet {

    private Animacion animacion;
    private float x;
    private float y;
    protected int time = 0;
    private Map<Integer, Runnable> runs;

    public Agente(PImage imagen, float x, float y) {
        this.animacion = new Animacion(imagen);
        this.runs = new HashMap<Integer, Runnable>();
        this.x = x;
        this.y = y;
    }

    public Agente(String name, int lenght, float x, float y) {
        this.animacion = new Animacion(name, lenght);
        this.runs = new HashMap<Integer, Runnable>();
        this.x = x;
        this.y = y;
    }

    public void draw() {
        if (this.animacion.get(0) != null) {
            image(this.animacion.get(0), this.x, this.y);
        }
    }

    public void runIn(int time, Runnable run) {
        if (runs.containsKey(time)) {
            runIn(time + 1, run);
        } else {
            this.runs.put(time, run);
        }

    }

    public void run() {
        time++;
        ArrayList<Integer> keytodel = new ArrayList<Integer>();
        for (Map.Entry<Integer, Runnable> run : runs.entrySet()) {
            if (run != null && time >= run.getKey()) {
                if (run.getValue() != null) {
                    run.getValue().run();
                    run.setValue(null);
                    keytodel.add(run.getKey());
                }
            }
        }
        for (Integer key : keytodel){
            runs.remove(key);
        }
    }

    public Animacion getAnimacion() {
        return animacion;
    }

    public void setAnimation(Animacion animacion) {
        this.animacion = animacion;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        if (x > Nivel.width) {
            x = Nivel.width;
        } else if (x < 0) {
            x = 0;
        }
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        if (y > Nivel.height) {
            y = Nivel.height;
        } else if (y < 0) {
            y = 0;
        }
        this.y = y;
    }

    public int getTime() {
        return time;
    }

}
