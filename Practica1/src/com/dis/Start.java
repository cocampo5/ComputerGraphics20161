/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author JDaniels
 */
public class Start extends JFrame {
    public static javax.sound.sampled.Clip sonido;
    public Start() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Tablero());
        
        setResizable(false);
        pack();
        
        setTitle("Super Arthurito");
        setLocationRelativeTo(null);
        //Dimension tam = getSize();
        //ImageIcon fondo = new ImageIcon(getClass().getResource("Imagenes/universo.gif"));
        //add(fondo, BorderLayout.CENTER);
       
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /*
    http://picarcodigo.blogspot.com.co/2013/01/poner-sonido-nuestras-aplicaciones-java.html
    */
    public static void sonidoBeepMenu() {
        try {
            sonido = AudioSystem.getClip();
            sonido.open(AudioSystem.getAudioInputStream(new File("Imagenes/inicio.wav")));

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ee) {
            System.out.println(ee);
        }
            sonido.start();
    }       

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Start ex = new Start();
                //ex.setIconImage("Imagenes/universo.gif");
                ex.sonidoBeepMenu();
                ex.setVisible(true);
            }
        });
    }
}