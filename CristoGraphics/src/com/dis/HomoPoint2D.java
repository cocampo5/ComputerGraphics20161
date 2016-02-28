package com.dis;

public class HomoPoint2D {

    private final double[][] point = new double[3][3];

    public HomoPoint2D(double x, double y, double w) {
        this.point[0][0] = x;
        this.point[1][0] = y;
        this.point[2][0] = w;
    }

    public double getX() {
        return this.point[0][0];
    }

    public double getY() {
        return this.point[1][0];
    }

    public double getW() {
        return this.point[2][0];
    }

    public double[][] getCoordinates() {
        return this.point;
    }

    public void setX(double x) {
        this.point[0][0] = x;
    }

    public void setY(double y) {
        this.point[1][0] = y;
    }

    public void setW(double w) {
        this.point[2][0] = w;
    }

    @Override
    public String toString() {
        return "P(" + this.point[0][0] + "," + this.point[1][0] + "," + this.point[2][0] + ")";
    }

}
