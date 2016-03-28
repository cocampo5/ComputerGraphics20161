package com.dis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.dis.Start.sonido;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author JDaniels
 * @author Critobal 
 */
public class Tablero extends JPanel implements ActionListener {

    private Timer timer;
    private Arthuro arthuro;
    private ArrayList<Enemigo> enemigos;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 400;
    private int naves;
    private int puntos =0;
    private int DELAY;
    private int intimer =0;
    private int reina=0;
     Random r = new Random();

    public Tablero() {
       
        initTablero();
    }
    
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon im = new ImageIcon("Imagenes/universo.gif");
        g.drawImage(im.getImage(),0,0, tamanio.width, tamanio.height , null);
        setOpaque(false);
        super.paint(g);
    }
    
    private void initTablero() {
         DELAY = 15;
         naves =0;
         intimer =0;
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        arthuro = new Arthuro(ICRAFT_X, ICRAFT_Y);
        initEnemigos();
        timer = new Timer(DELAY, this);
        timer.start();
        
    }

    public void initEnemigos() {
        enemigos = new ArrayList<>();
       // for (int[] p : pos) {
            enemigos.add(new Enemigo(400,300));
        //}
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ingame) {
            drawObjects(g);
        } else {
            drawGameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {
        if (arthuro.isVisible()) {
            g.drawImage(arthuro.getImage(), arthuro.getX(), arthuro.getY(),
                    this);
        //setOpaque(false);
        }
        ArrayList<Laser> ms = arthuro.getMissiles();
        for (Laser m : ms) {
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }
        for (Enemigo a : enemigos) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Arthur: " + naves + " Naves destruidas", 5, 15);
        g.drawString("\t Naves reinas derribadas: " + this.reina, 320, 15 );
        g.drawString("\t Puntos: " + this.puntos, 200, 15 );
        g.drawString("\t R para rotar los laser ", 500, 15 );
        
    }

    private void drawGameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        intimer++;
        inGame();
        updateCraft();
        updateMissiles();
        updateEnemigos();
        checkCollisions();
        repaint();
    }

    private void inGame() {
        
        if (!ingame) {
            timer.stop();
            sonidoBeepMenu();
            int res = JOptionPane.showConfirmDialog(this, 
                    "Desea reiniciar", "Perdiste" , 0, 1);
            if(res == 0){
                initTablero();  
            }else{
                System.exit(0);
            }
        }else{
            if(intimer==40 && enemigos.size()<5){
                enemigos.add(new Enemigo(750+r.nextInt(50), r.nextInt(350)));
                intimer=0;
                puntos = 0;
                reina = 0;
                timer.restart();
            }
        }
    }

    private void updateCraft() {
        if (arthuro.isVisible()) {
            arthuro.move();
        }
    }

    private void updateMissiles() {
        ArrayList<Laser> ms = arthuro.getMissiles();
        for (int i = 0; i < ms.size(); i++) {
            Laser m = ms.get(i);
            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateEnemigos() {
        if (enemigos.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < enemigos.size(); i++) {
            Enemigo a = enemigos.get(i);
            if (a.isVisible()) {
                a.move();
            } else {
                enemigos.remove(i);
                enemigos.add(new Enemigo(750+r.nextInt(50), r.nextInt(350)));//Eliminar esto
            }
        }
    }

    public void checkCollisions() {
        Rectangle r3 = arthuro.getBounds();
        for (Enemigo alien : enemigos) {
            Rectangle r2 = alien.getBounds();
            if (r3.intersects(r2)) {
                arthuro.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }
        ArrayList<Laser> ms = arthuro.getMissiles();
        for (Laser m : ms) {
            Rectangle r1 = m.getBounds();
            for (Enemigo alien : enemigos) {
                Rectangle r2 = alien.getBounds();
                if (r1.intersects(r2)) {
                    naves++;
                    puntos +=5;
                    m.setVisible(false);
                    alien.setVisible(false);
                    if (alien.getNaveReina()){
                        reina++;
                        puntos +=5;
                    }
                    if (naves%100 == 0){
                        this.DELAY = this.DELAY -1;
                        timer.setDelay(this.DELAY);
                    }
                }
            }
        }
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

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            arthuro.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            arthuro.keyPressed(e);
        }
    }
}