package mdl;

import processing.core.PImage;

/**
 *
 * @author Migue
 */
public class Lapix extends Agente {

    private static Lapix instance = null;
    private float dx;
    private float dy;
    private int score = 0;
    private int bonus = 0;
    private int cbonus = 0;
    private int upbonus = 0;
    private int block = 0;

    public Lapix(PImage imagen, float x, float y) {
        super(imagen, x, y);
        instance = this;
    }

    public Lapix(String name, float x, float y) {
        super(name, 10, x, y);
        instance = this;
    }

    public static Lapix getInstance() {
        return instance;
    }

    public void moverA(float x, float y) {
        this.dx = x;
        this.dy = y;
    }

    public void run() {
        super.run();
        float rr = (float) Math.atan((this.dy - this.getY()) / (this.dx - this.getX()));
        float xx = (float) Math.cos(rr);
        float yy = (float) Math.sin(rr);
        float ux = (this.dx - this.getX()) / Math.abs(this.dx - this.getX());
        float uy = (this.dy - this.getY()) / Math.abs(this.dy - this.getY());
        float vx = Math.abs(this.dx - this.getX()) / 5;
        float vy = Math.abs(this.dy - this.getY()) / 5;
        float dd = (float) Math.sqrt(Math.pow(dx - this.getX(), 2) + Math.pow(dy - this.getY(), 2));
        if (block <= 0) {
            //text("dd: " + getX(), 120, 30);
            if (dd > 3) {
                this.setX(this.getX() + Math.abs(xx * vx) * ux);
                this.setY(this.getY() + Math.abs(yy * vy) * uy);
                //text("vx: " + vx * ux + " vy: " + vy * uy, 100, 100);

            }
        } else {
            this.setX(this.getX() - Math.abs(xx * vx) * ux);
            this.setY(this.getY() - Math.abs(yy * vy) * uy);
            block--;
            if (block <= 0) {
                this.dx = this.getX() + 1;
                this.dy = this.getY() - 1;
            }
        }
    }

    public void setBlock(int block) {
        this.block = Math.abs(block);
    }

    public void draw() {
        float dd = Math.abs(this.dx - this.getX());
        float ux = (this.dx - this.getX()) / Math.abs(this.dx - this.getX());
        PImage imagen;
        if (bonus > 0) {
            imagen = this.getAnimacion().get(1);
            if (dd > 100) {
                if (ux > 0) {
                    imagen = this.getAnimacion().get(9);
                } else {
                    imagen = this.getAnimacion().get(8);
                }
            } else if (dd > 70) {
                if (ux > 0) {
                    imagen = this.getAnimacion().get(7);
                } else {
                    imagen = this.getAnimacion().get(6);
                }
            }
        } else {
            imagen = this.getAnimacion().get(0);
            if (dd > 100) {
                if (ux > 0) {
                    imagen = this.getAnimacion().get(5);
                } else {
                    imagen = this.getAnimacion().get(4);
                }
            } else if (dd > 70) {
                if (ux > 0) {
                    imagen = this.getAnimacion().get(3);
                } else {
                    imagen = this.getAnimacion().get(2);
                }
            }
        }
        image(imagen, this.getX() - 22, this.getY() - (133 * 3 / 4));
        fill(20, 20, 10);
        textSize(25);
        text("Score: " + this.score, 20, 30);
        text("Combo: " + this.bonus, 20, 60);
        if (this.cbonus > 0) {
            textSize(20);
            fill(20, 10, 200);
            text("+" + this.cbonus, this.getX() - 22, this.getY() - (133 * 3 / 4) + 7 - upbonus * 2);
            this.upbonus++;
        }
        if (bonus == 0 || upbonus > 7) {
            cbonus = 0;
        }

    }

    public void setBonus(Letra letra) {
        this.score += 20;
        this.bonus++;
        this.cbonus += 20 * bonus;
        this.upbonus = 0;
        if (bonus == 3) {
            Sound.play("yahoo");
        }
        /*runIn(time + 7, new Runnable() {
            public void run() {
                //bonus--;
                if (bonus <= 0) {
                    cbonus = 0;
                }
            }
        });*/
    }

    public int getScore() {
        return score;
    }

}
