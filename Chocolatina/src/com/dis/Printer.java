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
import java.util.Iterator;
import java.awt.BasicStroke;

public class Printer extends JPanel implements KeyListener {

    private int xP, yP;
    BasicStroke stroke = new BasicStroke(5.f);
    ChocoScan a;
    //Guardo mi array original por si acaso
    private ArrayList<HomoPoint2D> choco_original = new ArrayList<>();

    //Matriz desde la cual opero (Identidad 3x3)
    private final double[][] madre = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    private final Matriz2D matriz_madre = new Matriz2D(madre);
    private final double radians = Math.cos(Math.toRadians(1));
    //Matrices de transformación
    private final double[][] up = {{1, 0, 0}, {0, 1, 10}, {0, 0, 1}};
    private final double[][] down = {{1, 0, 0}, {0, 1, -10}, {0, 0, 1}};
    private final double[][] left = {{1, 0, -10}, {0, 1, 0}, {0, 0, 1}};
    private final double[][] right = {{1, 0, 10}, {0, 1, 0}, {0, 0, 1}};
    private final double[][] zoomin = {{1.2, 0, 0}, {0, 1.2, 0}, {0, 0, 1}};
    private final double[][] zoomout = {{0.8, 0, 0}, {0, 0.8, 0}, {0, 0, 1}};
    private final double[][] clock = {{Math.cos(radians), Math.sin(radians), 0}, {-Math.sin(radians), Math.cos(radians), 0}, {0, 0, 1}};
    private final double[][] counter = {{Math.cos(radians), -Math.sin(radians), 0}, {Math.sin(radians), Math.cos(radians), 0}, {0, 0, 1}};

    public Printer() {
        a = new ChocoScan();
        a.readLines();
        choco_original = a.getChocolatina();
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
        Random r = new Random();
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
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(up, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_S:
                System.out.println("DOWN");
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(down, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_D:
                System.out.println("RIGHT");
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(right, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_A:
                System.out.println("LEFT");
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(left, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_Q:
                System.out.println("ROTATE COUNTER CLOCKWISE");
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(counter, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_E:
                System.out.println("ROTATE CLOCKWISE");
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(clock, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_PLUS:
                System.out.println("ZOOM IN");
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(zoomin, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_MINUS:
                System.out.println("ZOOM OUT");
                for (int i = 0; i < 8; i++) {
                    double[][] fin = matriz_madre.multMatriz(zoomout, a.getChocolatina().get(i).getCoordinates());
                    a.getChocolatina().get(i).setX(fin[0][0]);
                    a.getChocolatina().get(i).setY(fin[1][0]);
                    System.out.println(fin[0][0] + "," + fin[1][0] + "," + fin[2][0]);
                }
                break;
            case KeyEvent.VK_R:
                System.out.print("RESET: ");
                System.out.println("Por implementar");
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
