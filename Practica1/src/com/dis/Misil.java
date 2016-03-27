/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis;

/**
 *
 * @author JDaniels
 * @author Cristobal
 */
public class Misil extends Sprite {

    private final int BOARD_WIDTH = 700;
    private final int MISSILE_SPEED = 2;
    private int moment = 0;

    public Misil(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("Imagenes/la1.png");  
        //getImageDimensions();
    }
    /*
    Con esto tengo pensado hacer rotar los laser
    */
    /*
     private void rot(){
        switch(moment%8){
            case 6:
                loadImage("Imagenes/la1.png");
                break;
            case 4:
                loadImage("Imagenes/la3.png");
                break;
            case 2:
                loadImage("Imagenes/la3.png");
                break;
            case 0:
                loadImage("Imagenes/la4.png");
                break;
        }
    }
  */

    public void move() {
        
        x += MISSILE_SPEED;
        
        if (x > BOARD_WIDTH) 
            vis = false;
        moment++;
        //rot();
    }
}
