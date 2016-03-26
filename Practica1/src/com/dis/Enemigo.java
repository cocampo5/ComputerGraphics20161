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
public class Enemigo extends Sprite {

    private final int INITIAL_X = 400;

    public Enemigo(int x, int y) {
        super(x, y);

        initAlien();    
    }

    private void initAlien() {

        loadImage("Imagenes/craft.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1; 
    }
}


