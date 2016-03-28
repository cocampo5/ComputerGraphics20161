/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis;

import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author JDaniels
 * @author Cristobal
 */
public class Enemigo extends Sprite {
    private final int INITIAL_X = 400;
    private boolean naveReina;
    Random ran = new Random();
    private Random r = new Random();
    public Enemigo(int x, int y) {
        super(x, y);
        initEnemigo();    
    }
 

    private void initEnemigo() {
        loadImage("Imagenes/craft1.png");
        naveReina = true;
       // getImageDimensions();
        switch(r.nextInt(5)%5){
            case 0:
                loadImage("Imagenes/craft1.png");
                naveReina = true;
                break;
            case 1:
                loadImage("Imagenes/nave2.png");
                naveReina = false;
                break;
            case 2:
                loadImage("Imagenes/nave3.png");
                naveReina = false;
                break;
            case 3:
                loadImage("Imagenes/nave4.png");
                naveReina = false;
                break;
        }
   
    }
    

    public void move() {
        if (x < 0) {
            x = INITIAL_X;
        }
        x -= 1; 
    }
    
    public boolean getNaveReina(){
        return naveReina;
    }

    
    @Override
    public void loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        int th = image.getHeight(null);
        int tw = image.getWidth(null);
        float scale = Math.abs(ran.nextFloat()%0.5f)+0.5f ; 
        image = image.getScaledInstance((int)(image.getWidth(null)*scale), 
                (int)(image.getHeight(null)*scale), Image.SCALE_AREA_AVERAGING);
        super.width = (int)(th*0.7f);
        super.height = (int)(tw*0.7f);
    }
}


