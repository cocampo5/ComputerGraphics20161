package com.dis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.util.Random;

public class Clipping extends JPanel {

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

        g2d.setColor(Color.BLUE);
        for (int i = 0; i < 5000; i++) {
            int x1 = Math.abs(r.nextInt()) % w;
            int y1 = Math.abs(r.nextInt()) % h;
            int x2 = Math.abs(r.nextInt()) % w;
            int y2 = Math.abs(r.nextInt()) % h;
            if (LiangBarsky(x1, y1, x2, y2)) {
                g2d.setColor(Color.RED);
                g2d.drawLine(cx0, cy0, cx1, cy1);
            } else {
                g2d.drawLine(x1, y1, x2, y2);
            }

        }
    }

    public boolean LiangBarsky(double x0, double y0, double x1, double y1) {
        double t0 = 0.0;
        double t1 = 1.0;
        double dx = x1 - x0;
        double dy = y1 - y0;
        double p = 0.0, q = 0.0, r = 0.0;
        for (int esquina = 0; esquina < 4; esquina++) {
            if (esquina == 0) {
                p = -dx;
                q = -(-125f - x0);
            }
            if (esquina == 1) {
                p = dx;
                q = (125f - x0);
            }
            if (esquina == 2) {
                p = -dy;
                q = -(-125f - y0);
            }
            if (esquina == 3) {
                p = dy;
                q = (125f - y0);
            }
            r = q / p;
            if (p == 0 && q < 0) {
                return false;
            }
            if (p < 0) {
                if (r > t1) {
                    return false;         // Don't draw line at all.
                } else if (r > t0) {
                    t0 = r;            // Line is clipped!
                }
            } else if (p > 0) {
                if (r < t0) {
                    return false;      // Don't draw line at all.
                } else if (r < t1) {
                    t1 = r;
                }// Line is clipped!
            }
        }
        System.out.println(x0+t0*dx);
        //cx0 = x0 + t0*dx;
        return true;
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Clipping");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new Clipping());
        // Asignarle tamaño
        frame.setSize(500, 500);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        //frame.setResizable(false);
        frame.setVisible(true);
    }
}
