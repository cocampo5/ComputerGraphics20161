package com.dis;

public class HomoPoint2D {

    private double x;
    private double y;
    private double w;

    public HomoPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
        this.w = 1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

}
