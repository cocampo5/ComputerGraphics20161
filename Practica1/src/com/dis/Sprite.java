/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
/**
 *
 * @author JDaniels
 * @author Cristobal
 */
public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        vis = true;
    }
    
    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
