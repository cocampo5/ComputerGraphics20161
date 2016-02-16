package com.dis;

public class Vector3D {

    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D sumarVectores(Vector3D a, Vector3D b) {
        double e = a.getX() + b.getX();
        double d = a.getY() + b.getY();
        double f = a.getZ() + b.getZ();
        Vector3D res = new Vector3D(e, d, f);
        return res;
    }

    public Vector3D multVectScalar(Vector3D a, int b) {
        double d = a.getX() * b;
        double e = a.getY() * b;
        double f = a.getZ() * b;
        Vector3D res = new Vector3D(d, e, f);
        return res;
    }

    public double productoPunto(Vector3D a, Vector3D b) {
        double res = (a.getX() * b.getX()) + (a.getY() * b.getY()) + (a.getZ() * b.getZ());
        return res;
    }

    public Vector3D productoCruz(Vector3D a, Vector3D b) {
        double i = a.getY() * b.getZ() - b.getY() * a.getZ();
        double j = -(a.getX() * b.getZ() - b.getX() * a.getZ());
        double k = a.getX() * b.getY() - b.getX() * a.getY();
        Vector3D res = new Vector3D(i, j, k);
        return res;
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

}
