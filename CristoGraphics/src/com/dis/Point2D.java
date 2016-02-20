package com.dis;

public class Point2D {

    private final double[] coordinates = new double[2];

    public Point2D(double x, double y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    public double getX() {
        return this.coordinates[0];
    }

    public double getY() {
        return this.coordinates[1];
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    @Override
    public String toString() {
        String rta = "P(" + this.coordinates[0] + "," + this.coordinates[1] + ")";
        return rta;
    }

}
