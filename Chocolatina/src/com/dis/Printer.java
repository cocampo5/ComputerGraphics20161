package com.dis;

/**
 * @author Cristóbal Ocampo Quintero
 *
 */
import com.dis.Graphics.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.ArrayList;

public class Printer extends JPanel implements KeyListener {

    ChocoScan a;
    private ArrayList<HomoPoint2D> choco_original = new ArrayList<>();
    private final double[][] b = {{1, 0, 10}, {0, 1, 10}, {0, 0, 1}};
    private final Matriz2D trans_positiva = new Matriz2D(b);

    public Printer() {
        a = new ChocoScan();
        a.readLines();
        choco_original = a.getChocolatina();
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
        //System.out.println(this.code.getChocolatina());
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
        int code = ke.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
                System.out.println("UP");
                double[][] fin = trans_positiva.multMatriz(b,a.getChocolatina().get(0).getCoordinates());
                a.getChocolatina().get(0).setX(fin[0][0]);
                a.getChocolatina().get(0).setY(fin[1][0]);
                System.out.println(fin[0][0]+""+fin[1][0]+""+fin[2][0]);
                break;
            case KeyEvent.VK_S:
                System.out.println("DOWN");
                break;
            case KeyEvent.VK_D:
                System.out.println("RIGHT");
                break;
            case KeyEvent.VK_A:
                System.out.println("LEFT");
                break;
            case KeyEvent.VK_Q:
                System.out.println("ROTATE COUNTER CLOCKWISE");
                break;
            case KeyEvent.VK_E:
                System.out.println("ROTATE CLOCKWISE");
                break;
            case KeyEvent.VK_PLUS:
                System.out.println("ZOOM IN");
                break;
            case KeyEvent.VK_MINUS:
                System.out.println("ZOOM OUT");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Chocolatinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //initializer code = new initializer();
        Printer p = new Printer();
        frame.add(p);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(p);
    }
}
