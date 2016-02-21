package com.dis;

public class HomoPoint3D {

    private final double[][] point = new double[4][4];

    public HomoPoint3D(double x, double y, double z, double w) {
        this.point[0][0] = x;
        this.point[0][1] = y;
        this.point[0][2] = z;
        this.point[0][3] = w;
    }

    public double getX() {
        return this.point[0][0];
    }

    public double getY() {
        return this.point[0][1];
    }

    public double getZ() {
        return this.point[0][2];
    }

    public double getW() {
        return this.point[0][3];
    }

    public double[][] getCoordinates() {
        return this.point;
    }

    @Override
    public String toString() {
        return "P(" + this.point[0][0] + "," + this.point[0][1] + "," + this.point[0][2] +","+ this.point[0][3] + ")";
    }

}
