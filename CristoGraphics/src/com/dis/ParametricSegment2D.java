package com.dis;

public class ParametricSegment2D {

    private final double x0;
    private final double y0;
    private final double x1;
    private final double y1;

    public ParametricSegment2D(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

}
