package com.dis;

public class HomoPoint2D {

    private final double x;
    private final double y;
    private final double w;

    public HomoPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
        this.w = 1;
    }

    public double[][] toMatrix(HomoPoint2D a) {
        double[][] ret = {{a.x}, {a.y}, {a.w}};
        return ret;
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
