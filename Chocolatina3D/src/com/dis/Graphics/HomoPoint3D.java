package com.dis;

public class HomoPoint3D {

    private final double[][] point = new double[4][4];

    public HomoPoint3D(double x, double y, double z, double w) {
        this.point[0][0] = x;
        this.point[1][0] = y;
        this.point[2][0] = z;
        this.point[3][0] = w;
    }

    public double getX() {
        return this.point[0][0];
    }

    public double getY() {
        return this.point[1][0];
    }

    public double getZ() {
        return this.point[2][0];
    }

    public double getW() {
        return this.point[3][0];
    }

    public void setX(double x) {
        this.point[0][0] = x;
    }

    public void setY(double y) {
        this.point[1][0] = y;
    }

    public void setZ(double z) {
        this.point[2][0] = z;
    }

    public void setW(double w) {
        this.point[3][0] = w;
    }

    public double[][] getCoordinates() {
        return this.point;
    }

    @Override
    public String toString() {
        return "P(" + this.point[0][0] + "," + this.point[1][0] + "," + this.point[2][0] + "," + this.point[3][0] + ")";
    }

}
