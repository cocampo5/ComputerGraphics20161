package com.dis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random;
import java.lang.System;

public class ClippingLiangBarsky extends JPanel {

    int cx0, cy0, cx1, cy1;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        /*
         Transformacion xp=x+w/2
         yp = h/2 - y
         */
        Dimension size = getSize();
        Insets insets = getInsets();
        Random r = new Random();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        g2d.setColor(Color.DARK_GRAY);
        g2d.drawRect(125, 125, -125, -125);
        for (int i = 0; i < 100000; i++) {
            int x1 = Math.abs(r.nextInt()) % w;
            int y1 = Math.abs(r.nextInt()) % h;
            int x2 = Math.abs(r.nextInt()) % w;
            int y2 = Math.abs(r.nextInt()) % h;
            if (LiangBarsky(x1, y1, x2, y2)) {
                g2d.setColor(Color.BLUE);
                g2d.drawLine(x1, y1, cx0, cy0);
                g2d.drawLine(cx1, cy1, x2, y2);
                g2d.setColor(Color.RED);
                g2d.drawLine(cx0, cy0, cx1, cy1);
            } else {
                g2d.setColor(Color.BLUE);
                g2d.drawLine(x1, y1, x2, y2);
            }

        }
    }

    public boolean LiangBarsky(double x0, double y0, double x1, double y1) {
        double t0 = 0.0;
        double t1 = 1.0;
        int dx = (int) (x1 - x0);
        int dy = (int) (y1 - y0);
        double p = 0.0, q = 0.0, r;
        for (int side = 0; side < 4; side++) {
            if (side == 0) {
                p = -dx;
                q = -(x0 - 250.0);
            }
            if (side == 1) {
                p = dx;
                q = (250 - x0);
            }
            if (side == 2) {
                p = -dy;
                q = -(y0 - 250);
            }
            if (side == 3) {
                p = dy;
                q = (250 - y0);
            }
            if (p == 0 && q < 0) {
                return false;
            } else {
                r = (double) q / p;
                if (p < 0) {
                    t0 = Math.max(r, t0);
                } else {
                    t1 = Math.min(r, t1);
                }
            }
//            r = q / p;
//            if (p < 0) {
//                if (r > t1) {
//                    return false;         
//                } else if (r > t0) {
//                    t0 = r;            
//                }
//            } else if (p > 0) {
//                if (r < t0) {
//                    return false;      
//                } else if (r < t1) {
//                    t1 = r;
//                }
//            }
        }
        if (t0 > t1) {
            return false;
        }
        cx0 = (int) (x0 + t0 * dx);
        cy0 = (int) (y0 + t0 * dy);
        cx1 = (int) (x0 + t1 * dx);
        cy1 = (int) (y0 + t1 * dy);
        return true;
    }

    public static void main(String[] args) {
        long viejo = System.currentTimeMillis();
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Clipping");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new ClippingLiangBarsky());
        // Asignarle tamaño
        frame.setSize(500, 500);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        //frame.setResizable(false);
        frame.setVisible(true);
        long nuevo = System.currentTimeMillis();
        System.out.println("El tiempo transcurrido fue: " + ((nuevo - viejo)) + " milisegundos");
    }
}
