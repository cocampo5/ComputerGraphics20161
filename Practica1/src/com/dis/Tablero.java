package com.dis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.util.ArrayList;
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
    private Arthuro craft;
    private ArrayList<Enemigo> aliens;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 700;
    private final int B_HEIGHT = 500;
    private final int DELAY = 20;

    private final int[][] pos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };

    public Tablero() {
       
        initBoard();
    }
    
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon im = new ImageIcon("Imagenes/universo.gif");
        g.drawImage(im.getImage(),0,0, tamanio.width, tamanio.height , null);
        setOpaque(false);
        super.paint(g);
    }
    
    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        craft = new Arthuro(ICRAFT_X, ICRAFT_Y);
        initEnemigos();
        timer = new Timer(DELAY, this);
        timer.start();
        
    }

    public void initEnemigos() {
        aliens = new ArrayList<>();
        for (int[] p : pos) {
            aliens.add(new Enemigo(p[0], p[1]));
        }
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
        if (craft.isVisible()) {
            g.drawImage(craft.getImage(), craft.getX(), craft.getY(),
                    this);
        //setOpaque(false);
        }
        ArrayList<Misil> ms = craft.getMissiles();
        for (Misil m : ms) {
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }
        for (Enemigo a : aliens) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Arthur Faltan: " + aliens.size() + " Naves", 5, 15);
        
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
            int res = JOptionPane.showConfirmDialog(this, 
                    "Desea reiniciar", "Perdiste" , 0, 1);
            if(res == 0){
                initBoard();
            }else{
                System.exit(0);
            }
        }
    }

    private void updateCraft() {
        if (craft.isVisible()) {
            craft.move();
        }
    }

    private void updateMissiles() {
        ArrayList<Misil> ms = craft.getMissiles();
        for (int i = 0; i < ms.size(); i++) {
            Misil m = ms.get(i);
            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateEnemigos() {
        if (aliens.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < aliens.size(); i++) {
            Enemigo a = aliens.get(i);
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
    }

    public void checkCollisions() {
        Rectangle r3 = craft.getBounds();
        for (Enemigo alien : aliens) {
            Rectangle r2 = alien.getBounds();
            if (r3.intersects(r2)) {
                craft.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }
        ArrayList<Misil> ms = craft.getMissiles();
        for (Misil m : ms) {
            Rectangle r1 = m.getBounds();
            for (Enemigo alien : aliens) {
                Rectangle r2 = alien.getBounds();
                if (r1.intersects(r2)) {
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}