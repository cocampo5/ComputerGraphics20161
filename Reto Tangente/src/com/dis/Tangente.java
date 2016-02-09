package com.dis;

/**
 * @author Cristóbal Ocampo Quintero
 **/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Tangente extends JPanel {

    /**
     * Metodo para la construccion de la ventana
     * @param g de Tipo Graphics
     **/
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //Color RGB aleatorio
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B= (int)(Math.random()*256);
        g2d.setColor(new Color(R, G, B));
        
        //Radio aleatorio entre 50 y 200
        int radius= 50 + (int)(Math.random() * ((150 - 50) + 1));
        int alpha;
        //Incremento aleatorio entre 0 y 10
        int inc= 1 + (int)(Math.random() * ((10 - 1) + 1));
        
        int x, y, xT, yT;

        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        for (alpha = 0; alpha < 360; alpha += inc) {
            double alphaRad = alpha * Math.PI / 180d;
            x = (int) (radius * Math.cos(alphaRad));
            y = (int) (radius * Math.sin(alphaRad));
            xT = x - y;
            yT = y + x;
            /*
            Transformacion 
            xp = x+w/2
            yp = h/2 - y
            */
            pintarBresenham(g, x + w / 2, h / 2 - y, xT + w / 2, h / 2 - yT);
        }
    }

    /**
     * Implementación del Algoritmo de Bresenham
     * @see <a href="http://members.chello.at/easyfilter/bresenham.html">Bresenham Algorithm</a>
     * @param g  Una ventana Java de tipo Graphics
     * @param x0 Coordenada x del primer punto
     * @param y0 Coordenada y del primer punto
     * @param x1 Coordenada x del segundo punto
     * @param y1 Coordenada y del segundo punto
     */
    public void pintarBresenham(Graphics g, int x0, int y0, int x1, int y1) {
        Graphics2D g2d = (Graphics2D) g;
        
        int dx = Math.abs(x1 - x0);
        int dy = -Math.abs(y1 - y0);
        int err = dx + dy, e2;
        int sx, sy;
        if (x0 < x1) {
            sx = 1;
        } else {
            sx = -1;
        }
        if (y0 < y1) {
            sy = 1;
        } else {
            sy = -1;
        }
        for (;;) {
            //setPixel(x0, y0);
            g2d.drawLine(x0, y0, x0, y0);
            if (x0 == x1 && y0 == y1) {
                break;
            }
            e2 = 2 * err;
            if (e2 >= dy) {
                err += dy;
                x0 += sx;
            }
            if (e2 <= dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tangentes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Tangente());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
