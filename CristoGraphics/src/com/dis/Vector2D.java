package com.dis;

public class Vector2D {

    private final double x;
    private final double y;
    //private final Point2D x0;
    //private final Point2D x1;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D sumarVectores(Vector2D a, Vector2D b) {
        double e = a.getX() + b.getX();
        double d = b.getY() + a.getY();
        Vector2D res = new Vector2D(e, d);
        return res;
    }

    public Vector2D restarVectores(Vector2D a, Vector2D b) {
        double e = a.getX() - b.getX();
        double d = b.getY() - a.getY();
        Vector2D res = new Vector2D(e, d);
        return res;
    }

    public Vector2D multVectScalar(Vector2D a, int b) {
        double d = a.getX() * b;
        double e = a.getY() * b;
        Vector2D res = new Vector2D(d, e);
        return res;
    }

    public double productoPunto(Vector2D a, Vector2D b) {
        double res = (a.getX() * b.getX()) + (a.getY() * b.getY());
        return res;
    }

    public Vector3D productoCruz(Vector2D a, Vector2D b) {
        double i = a.getY() * 0 - b.getY() * 0;
        double j = -(a.getX() * 0 - b.getX() * 0);
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

}
