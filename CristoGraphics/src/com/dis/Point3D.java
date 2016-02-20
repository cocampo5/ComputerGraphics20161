package com.dis;

public class Point3D {

    private final double[] coordinates = new double[2];

    public Point3D(double x, double y, double z) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.coordinates[2] = z;
    }

    public double getX() {
        return this.coordinates[0];
    }

    public double getY() {
        return this.coordinates[1];
    }

    public double getZ() {
        return this.coordinates[2];
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    @Override
    public String toString() {
        return "P(" + this.coordinates[0] + "," + this.coordinates[1] + "," + this.coordinates[2] + ")";
    }

}
