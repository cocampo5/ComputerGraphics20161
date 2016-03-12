package com.dis;

/**
 * @author Cristóbal Ocampo Quintero
 * @author Juan Daniel Arboleda
 *
 */
import com.dis.Graphics.HomoPoint3D;
import com.dis.Graphics.Vector3D;
import com.dis.Graphics.Matriz3D;
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

    JFrame frame;
    private int xP, yP;
    BasicStroke stroke = new BasicStroke(2.f);
    ChocoScan a;
    Graphics2D g2d;
    private ArrayList<HomoPoint3D> choco_puntos = new ArrayList<>();
    private ArrayList<Vector3D> choco_vectores = new ArrayList<>();
    private ArrayList<Vector3D> choco_vectores_trans = new ArrayList<>();
    //Matrices de transformación
    private final double radians = Math.toRadians(10.0);
    private final double radianX = Math.toRadians(180);
    private final double radianY = Math.toRadians(180);
    private final double perspectiva[][] = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1 / 50f, 0}};
    private final double zoomin[][] = {{1.2, 0, 0, 0}, {0, 1.2, 0, 0}, {0, 0, 1.2, 0}, {0, 0, 0, 1}};
    private final double zoomout[][] = {{0.8, 0, 0, 0}, {0, 0.8, 0, 0}, {0, 0, 0.8, 0}, {0, 0, 0, 1}};
    private final double up[][] = {{1, 0, 0, 0}, {0, 1, 0, 10}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    private final double down[][] = {{1, 0, 0, 0}, {0, 1, 0, -10}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    private final double right[][] = {{1, 0, 0, 10}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    private final double left[][] = {{1, 0, 0, -10}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    
    private final double[][] clockz = {{Math.cos(radians), Math.sin(radians), 0,0}, {-Math.sin(radians), Math.cos(radians), 0,0}, {0, 0, 1,0},{0,0,0,1}};
    private final double[][] counterz = {{Math.cos(radians), -Math.sin(radians), 0,0}, {Math.sin(radians), Math.cos(radians), 0,0}, {0, 0, 1,0},{0,0,0,1}};
    
    private final double[][] clockx = {{1,0,0,0}, {0,Math.cos(radianX), -Math.sin(radianX),0}, {0,Math.sin(radianX), Math.cos(radianX),0},{0,0,0,1}};
    private final double[][] counterx = {{1,0,0,0}, {0,Math.cos(radianX),Math.sin(radianX),0}, {0,-Math.sin(radianX), Math.cos(radianX),0},{0,0,0,1}};
    
    private final double[][] clocky = {{Math.cos(radianY),0,Math.sin(radianY),0},{0,1,0,0},{-Math.sin(radianY),0,Math.cos(radianY),0},{0,0,0,1}};
    private final double[][] countery = {{Math.cos(radianY),0,-Math.sin(radianY),0},{0,1,0,0},{Math.sin(radianY),0,Math.cos(radianY),0},{0,0,0,1}};
    //Matriz3D desde donde opero
    double matriz_madre[][] = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    Matriz3D mother = new Matriz3D(matriz_madre);

    public Choco3D() throws IOException {
        a = new ChocoScan();
        choco_puntos = a.getChoco_puntos();
        choco_vectores = a.getChoco_vectores();
        choco_vectores_trans = a.getChoco_vectores();
        a.readObjet("chocolatina3D.txt");
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
        g2d.drawLine(mapeoX(0), mapeoY(0), mapeoX(w), mapeoY(h / 2));
        g2d.drawLine(mapeoX(0), mapeoY(0), mapeoX(-w), mapeoY(-h / 2));
        g2d.setColor(Color.WHITE);
        g2d.setStroke(stroke);

        for (int i = 0; i < choco_vectores.size(); i++) {
            HomoPoint3D x = choco_vectores.get(i).getXx();
            HomoPoint3D y = choco_vectores.get(i).getYy();
            double[][] res = mother.multMatriz(perspectiva, x.getCoordinates());
            double[][] res2 = mother.multMatriz(perspectiva, y.getCoordinates());
            x = new HomoPoint3D(res[0][0] / res[3][0], res[1][0] / res[3][0], res[2][0] / res[3][0], res[3][0] / res[3][0]);
            y = new HomoPoint3D(res2[0][0] / res2[3][0], res2[1][0] / res2[3][0], res2[2][0] / res2[3][0], res2[3][0] / res2[3][0]);
            choco_vectores_trans.get(i).setXx(x);
            choco_vectores_trans.get(i).setYy(y);
        }
        //Pinto la chocolatina
        for (int i = 0; i < choco_vectores.size(); i++) {
            double x0, y0, x1, y1;
            x0 = choco_vectores.get(i).getXx().getX();
            y0 = choco_vectores.get(i).getXx().getY();
            x1 = choco_vectores.get(i).getYy().getX();
            y1 = choco_vectores.get(i).getYy().getY();
            g2d.drawLine(mapeoX(x0), mapeoY(y0), mapeoX(x1), mapeoY(y1));
            //System.out.println("OIE OIE");
        }
        //Hacer transformación
        for (int i = 0; i < choco_vectores_trans.size(); i++) {
            double x0, y0, x1, y1;
            x0 = choco_vectores_trans.get(i).getXx().getX();
            y0 = choco_vectores_trans.get(i).getXx().getY();
            x1 = choco_vectores_trans.get(i).getYy().getX();
            y1 = choco_vectores_trans.get(i).getYy().getY();
            g2d.drawLine(mapeoX(x0), mapeoY(y0), mapeoX(x1), mapeoY(y1));
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        repaint();
        //System.out.println(choco_vectores.get(0).toString());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        switch (code) {
            case KeyEvent.VK_C:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(countery, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(countery, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
                case KeyEvent.VK_V:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(clocky, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(clocky, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_Z:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(counterx, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(counterx, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
                case KeyEvent.VK_X:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(clockx, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(clockx, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_Q:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(counterz, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(counterz, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
                case KeyEvent.VK_A:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(left, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(left, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_E:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(clockz, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(clockz, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_D:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(right, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(right, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_S:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(down, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(down, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_W:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(up, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(up, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_MINUS:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(zoomout, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(zoomout, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_PLUS:
                for (int i = 0; i < choco_vectores.size(); i++) {
                    double[][] res = mother.multMatriz(zoomin, choco_vectores.get(i).getXx().getCoordinates());
                    double[][] res2 = mother.multMatriz(zoomin, choco_vectores.get(i).getYy().getCoordinates());
                    choco_vectores.get(i).getXx().setX(res[0][0]);
                    choco_vectores.get(i).getXx().setY(res[1][0]);
                    choco_vectores.get(i).getYy().setX(res2[0][0]);
                    choco_vectores.get(i).getYy().setY(res2[1][0]);
                }
                break;
            case KeyEvent.VK_T:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("Presionó: " + ke.getKeyChar());
    }

    public void drawOneLine(int x1, int y1, int x2, int y2) {
        //System.out.print(" x1 " + x1);
        g2d.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Chocolatina 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Choco3D p = new Choco3D();
        frame.add(p);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(p);

    }
}
