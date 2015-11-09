/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdl;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Migue
 */
public class Animacion extends PApplet{
    private ArrayList<PImage> images;

    public Animacion(String name, int lenght) {
        loadFromName(name, lenght);
    }
    
    public Animacion(PImage image){
        images = new ArrayList<PImage>();
        images.add(image);
    }
    
    public final void loadFromName(String name, int lenght){
        images = new ArrayList<PImage>();
        for (int i = 0; i < lenght; i++){
            PImage image = loadImage(name + "-" + i + ".png");
            images.add(image);
        }
    }
    
    public PImage get(int index){
        return images.get(index);
    }
    
}
