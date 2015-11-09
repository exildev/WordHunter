package main;

import mdl.Lapix;
import mdl.Letra;
import mdl.Nivel1;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Migue
 */
public class Main extends PApplet {
    Nivel1 nivel1;
    public void setup() {
        size(800, 600);
        background(125);
        frameRate(15);
        PImage bg = loadImage("src/img/Bg1.png");
        nivel1 = new Nivel1(bg);
        nivel1.setup();
        Lapix lapix = new Lapix("src/img/lapix", 400, 400);
        lapix.moverA(100, 100);

    }

    public void draw() {
        background(255);
        nivel1.run();
        nivel1.draw();
    }

    void mouseClicked(float mouseX, float mouseY) {
        nivel1.moverLapixA(mouseX, mouseY);
    }
    
}
