/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis;

/**
 *
 * @author JDaniels
 */
public class Misil extends Sprite {

    private final int BOARD_WIDTH = 700;
    private final int MISSILE_SPEED = 2;

    public Misil(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("Imagenes/Misil.png");  
        getImageDimensions();
    }


    public void move() {
        
        x += MISSILE_SPEED;
        
        if (x > BOARD_WIDTH) {
            vis = false;
        }
    }
}
