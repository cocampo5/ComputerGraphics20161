package com.dis;

/**
 * @author Cristóbal Ocampo Quintero
 *
 */
import com.dis.Graphics.HomoPoint2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;

public class Printer extends JPanel implements KeyListener {

    ChocoScan a;
    Color color = Color.BLACK;
    public Printer() {
        a = new ChocoScan();
        a.readLines();
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
        for (int i = 0; i < 6; i++) {
            //System.out.println(i);
            if (i == 0) {
                int x0 = (int) a.getChocolatina().get(0).getX();
                int y0 = (int) a.getChocolatina().get(0).getY();
                int x1 = (int) a.getChocolatina().get(1).getX();
                int y1 = (int) a.getChocolatina().get(1).getY();
                //System.out.println(x0 + "" + y0 + "" + x1 + "" + y1);
                g2d.drawLine(x0 + w / 2, h / 2 - y0, x1 + w / 2, h / 2 - y1);
            }
            if (i == 1) {
                int x0 = (int) a.getChocolatina().get(1).getX();
                int y0 = (int) a.getChocolatina().get(1).getY();
                int x1 = (int) a.getChocolatina().get(2).getX();
                int y1 = (int) a.getChocolatina().get(2).getY();
                //System.out.println(x0 + "" + y0 + "" + x1 + "" + y1);
                g2d.drawLine(x0 + w / 2, h / 2 - y0, x1 + w / 2, h / 2 - y1);
            }
            if (i == 2) {
                int x0 = (int) a.getChocolatina().get(2).getX();
                int y0 = (int) a.getChocolatina().get(2).getY();
                int x1 = (int) a.getChocolatina().get(3).getX();
                int y1 = (int) a.getChocolatina().get(3).getY();
                //System.out.println(x0 + "" + y0 + "" + x1 + "" + y1);
                g2d.drawLine(x0 + w / 2, h / 2 - y0, x1 + w / 2, h / 2 - y1);
            }
            if (i == 3) {
                int x0 = (int) a.getChocolatina().get(3).getX();
                int y0 = (int) a.getChocolatina().get(3).getY();
                int x1 = (int) a.getChocolatina().get(0).getX();
                int y1 = (int) a.getChocolatina().get(0).getY();
                //System.out.println(x0 + "" + y0 + "" + x1 + "" + y1);
                g2d.drawLine(x0 + w / 2, h / 2 - y0, x1 + w / 2, h / 2 - y1);
            }
            if (i == 4) {
                int x0 = (int) a.getChocolatina().get(4).getX();
                int y0 = (int) a.getChocolatina().get(4).getY();
                int x1 = (int) a.getChocolatina().get(7).getX();
                int y1 = (int) a.getChocolatina().get(7).getY();
                //System.out.println(x0 + "" + y0 + "" + x1 + "" + y1);
                g2d.drawLine(x0 + w / 2, h / 2 - y0, x1 + w / 2, h / 2 - y1);
            }
            if (i == 5) {
                int x0 = (int) a.getChocolatina().get(5).getX();
                int y0 = (int) a.getChocolatina().get(5).getY();
                int x1 = (int) a.getChocolatina().get(6).getX();
                int y1 = (int) a.getChocolatina().get(6).getY();
                //System.out.println(x0 + "" + y0 + "" + x1 + "" + y1);
                g2d.drawLine(x0 + w / 2, h / 2 - y0, x1 + w / 2, h / 2 - y1);
            }
        }
        //System.out.println(this.a.getChocolatina());
        //} catch (Exception e) {
        //System.out.println(e.getMessage());
        //}

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int a = ke.getKeyCode();
        if (a == KeyEvent.VK_B) {
            System.out.println("Azul");
            color = Color.BLUE;
        } else if (a == KeyEvent.VK_R) {
            color = Color.RED;
        } else {
            color = Color.MAGENTA;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println(ke.getKeyCode());
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Chocolatinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //initializer a = new initializer();
        Printer p = new Printer();
        frame.add(p);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(p);
    }
}
