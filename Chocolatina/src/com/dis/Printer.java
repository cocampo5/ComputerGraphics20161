package com.dis;

/**
 * @author Cristóbal Ocampo Quintero
 *
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Printer extends JPanel {
    
    public ArrayList choco;

    
    public void getArrayList() throws IOException{
        initializer init = new initializer();
        this.choco = init.res.getChocolatina();
    }
    
     /**
     * Metodo para la construccion de la ventana
     *
     * @param g de Tipo Graphics
     *
     */
    @Override
    public void paintComponent(Graphics g)  {
        
        super.paintComponent(g);
        System.out.println(choco.get(0));
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
        for (int i = 0; i < 10000; i++) {
            int x1 = Math.abs(r.nextInt()) % w;
            int y1 = Math.abs(r.nextInt()) % h;
            int x2 = Math.abs(r.nextInt()) % w;
            int y2 = Math.abs(r.nextInt()) % h;
            g2d.drawLine(x1, y1, x2, y2);

        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tangentes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Printer());
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
