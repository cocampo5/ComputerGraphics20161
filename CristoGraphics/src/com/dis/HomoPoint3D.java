package com.dis;

public class HomoPoint3D {

    private final double x;
    private final double y;
    private final double z;
    private final double w;

    public HomoPoint3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }

    public double[][] toMatrix(HomoPoint3D a) {
        double[][] ret = {{a.x}, {a.y}, {a.z}, {a.w}};
        return ret;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getW() {
        return w;
    }

}
