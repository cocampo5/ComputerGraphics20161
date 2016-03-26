/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PingPong;
import javax.swing.JPanel;
import javax.swing.JFrame;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;
import java.awt.BasicStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author JDaniel  s
 */
public class Game extends JPanel implements KeyListener{
    BasicStroke stroke = new BasicStroke(4.f);
    BasicStroke strokeplayer = new BasicStroke(10.f);
    public int p1[] = {20,180,20,240};
    public int p2[] = {655,180,655,240};
     Graphics2D g2d ;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.green);
        g2d = (Graphics2D) g;
        g2d.setColor(Color.orange);
        Dimension size = getSize();//Tamaño de la ventana
        Insets insets = getInsets();//Vordes y titulos de la ventana
        int w =  size.width - insets.left - insets.right;
        int h =  size.height - insets.top - insets.bottom;
         g2d.setStroke(stroke);
         g2d.drawRect(25, 25, 625, 420);
         g2d.drawLine(w/2,25,w/2,445);
         g2d.setStroke(strokeplayer);
         g2d.setColor(Color.red);
         g2d.drawLine(20,180,20,240);
         pintarPlayer1();
         pintarPlayer2();
    }
    public void pintarPlayer1(){
         g2d.setStroke(strokeplayer);
         g2d.setColor(Color.red);
         g2d.drawLine(p1[0],p1[1],p1[2],p1[3]); 
         g2d.drawString("JUGADOR 1",230,20);
    }
    public void pintarPlayer2(){
         g2d.setStroke(strokeplayer);
         g2d.setColor(Color.red);
         g2d.drawLine(p2[0],p2[1],p2[2],p2[3]);
         g2d.drawString("JUGADOR 2",400,20);
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
                System.out.println("DOWN");
                p1[1] -= 10;
                p1[3] -= 10;
                if (p1[1] > 25) {
                    System.out.print(p1[0] + " " + p1[1] + " " +p1[2] + " " +p1[3] + " " );
                    //try {
                       // paintComponent(d);
                        pintarPlayer1();
                    //}catch(Exception e){
                        
                    //}
                }
                break;
            case KeyEvent.VK_S:
                System.out.println("DOWN");
             
                break;
            case KeyEvent.VK_O:
                System.out.println("RIGHT");
               
                break;
            case KeyEvent.VK_L:
                System.out.println("LEFT");
               
                break;     
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("SS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new Game());
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Game p = new Game();
        frame.addKeyListener(p);
    }
}
