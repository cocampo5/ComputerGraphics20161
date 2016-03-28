/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis;


import static com.dis.Start.sonido;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author JDaniels 
 * @author Cristobal
 */
public class Arthuro extends Sprite {

    private int dx;
    private boolean rotar = false;
    private int dy;
    private ArrayList<Laser> missiles;

    public Arthuro(int x, int y) {
        super(x, y);

        initArthuro();
    }

    private void initArthuro() {
        
        missiles = new ArrayList<>();
        loadImage("Imagenes/arthurito.png");
        //getImageDimensions();
    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
        if (key == KeyEvent.VK_R){
            if (rotar==false){
                rotar = true;
            }else{
                rotar = false;
            }
       
            
        }
    }
    
    /*
       MEtodo para disparar un nuevo Laser
    */
    public void fire() {
        missiles.add(new Laser(x + width, y + height / 2,rotar));
        sonido();
        
    }
        /*
    http://picarcodigo.blogspot.com.co/2013/01/poner-sonido-nuestras-aplicaciones-java.html
    */
    public static void sonido() {
        try {
            sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(new File("Imagenes/LAZER.wav")));

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ee) {
            System.out.println(ee);
        }
            sonido.start();
    }  

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
