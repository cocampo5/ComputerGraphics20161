package com.dis;

/**
 * @author Cristóbal Ocampo Quintero
 * @author Juan Daniel Arboleda
 *
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.BasicStroke;

public class Choco3D extends JPanel implements KeyListener {

    private int xP, yP;
    BasicStroke stroke = new BasicStroke(3.f);
    ChocoScan a;
    Graphics2D g2d;
    
    public Choco3D() {
        a = new ChocoScan();
        //a.readLines();
        try {
            a.readObjet("chocolatina3D.txt");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    //mapeo en X
    public int mapeoX(double x) {
        return (int) x + xP;
    }
    //mapeo en y
    public int mapeoY(double y) {
        return (int) y * (-1) + yP;
    }
    /**
     * Metodo para la construccion de la ventana
     *
     * @param g de Tipo Graphics
     *
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        setBackground(Color.black);
        /*
         Transformacion xp=x+w/2
         yp = h/2 - y
         */
        Dimension size = getSize();
        Insets insets = getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        yP = h / 2;
        xP = w / 2;
        g2d.setColor(Color.red);
        g2d.drawLine(mapeoX(-h), mapeoY(0), mapeoX(h), mapeoY(0));
        g2d.drawLine(mapeoX(0), mapeoY(-w), mapeoX(0), mapeoY(w));
        g2d.drawLine(mapeoX(0),mapeoY(0),mapeoX(w),mapeoY(h/2));
        g2d.drawLine(mapeoX(0),mapeoY(0),mapeoX(-w),mapeoY(-h/2));
        g2d.setColor(Color.WHITE);
        g2d.setStroke(stroke);
        //Pinto la chocolatina
        g2d.drawLine(mapeoX(0),mapeoY(0),mapeoX(100),mapeoY(0));
        g2d.drawLine(mapeoX(0),mapeoY(0),mapeoX(0),mapeoY(100));
        g2d.drawLine(mapeoX(0),mapeoY(100),mapeoX(100),mapeoY(100));
        g2d.drawLine(mapeoX(100),mapeoY(100),mapeoX(100),mapeoY(0));
        
        g2d.drawLine(mapeoX(20),mapeoY(20),mapeoX(120),mapeoY(20));
        g2d.drawLine(mapeoX(20),mapeoY(20),mapeoX(20),mapeoY(120));
        g2d.drawLine(mapeoX(20),mapeoY(120),mapeoX(120),mapeoY(120));
        g2d.drawLine(mapeoX(120),mapeoY(120),mapeoX(120),mapeoY(20));
        
        g2d.drawLine(mapeoX(0),mapeoY(0),mapeoX(20),mapeoY(20));
        g2d.drawLine(mapeoX(0),mapeoY(100),mapeoX(20),mapeoY(120));
        g2d.drawLine(mapeoX(100),mapeoY(100),mapeoX(120),mapeoY(120));
        g2d.drawLine(mapeoX(100),mapeoY(0),mapeoX(120),mapeoY(20));
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("Presionó: "+ke.getKeyChar());
    }

    public void drawOneLine(int x1, int y1, int x2, int y2) {
        System.out.print(" x1 "+x1);
        g2d.drawLine(x1, y1, x2, y2);
    }

    
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Chocolatina 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Choco3D p = new Choco3D();
        frame.add(p);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(p);
    }
}
