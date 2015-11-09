package mdl;

import processing.core.PImage;

/**
 *
 * @author Migue
 */
public class Letra extends Agente {

    private int dietime = 50;
    private ILetra iletra = null;
    private boolean todel;
    private int transaparent = 2;

    public Letra(PImage imagen, float x, float y) {
        super(imagen, x, y);
    }

    public void run() {
        super.run();
        if (iletra != null) {
            iletra.run(this);
        }
        if (this.getTime() > this.getDietime()) {
            this.setTodel(true);
        }
    }

    public void draw() {
        if (time < dietime / 2 || time % transaparent != 0) {
            image(this.getAnimacion().get(0), this.getX() - (128 / 2), this.getY() - (128 / 2));
        }
    }

    public void setIletra(ILetra iletra) {
        this.iletra = iletra;
        this.iletra.setup(this);
    }

    public void setTodel(boolean todel) {
        this.todel = todel;
    }

    public boolean isTodel() {
        return todel;
    }

    public ILetra getIletra() {
        return iletra;
    }

    public void setDietime(int dietime) {
        this.dietime = dietime;
    }

    public int getDietime() {
        return dietime;
    }

}
