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
    BasicStroke stroke = new BasicStroke(5.f);
    ChocoScan a;
    
    public Choco3D() {
        a = new ChocoScan();
        a.readLines();
      
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

        //try {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
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
        g2d.drawLine(mapeoX(-1000), mapeoY(0), mapeoX(1000), mapeoY(0));
        g2d.drawLine(mapeoX(0), mapeoY(-1000), mapeoX(0), mapeoY(1000));
        g2d.setColor(Color.WHITE);
        g2d.setStroke(stroke);
        //Pinto la chocolatina
        
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

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Chocolatinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //initializer code = new initializer();
        Choco3D p = new Choco3D();
        frame.add(p);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(p);
    }
}
