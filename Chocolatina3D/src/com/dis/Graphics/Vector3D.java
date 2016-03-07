package com.dis.Graphics;

public class Vector3D {

    private final double[] components = new double[3];
    private HomoPoint3D xx,yy;

    public Vector3D(double x, double y, double z) {
        this.components[0] = x;
        this.components[1] = y;
        this.components[2] = z;
    }

    public Vector3D(Point3D a, Point3D b) {
        this.components[0] = a.getX()-b.getX();
        this.components[1] = a.getY()-b.getY();
        this.components[2] = a.getZ()-b.getZ();
    }

    public Vector3D(HomoPoint3D a, HomoPoint3D b) {
        this.components[0] = a.getX()-b.getX();
        this.components[1] = a.getY()-b.getY();
        this.components[2] = a.getZ()-b.getZ();
        this.xx=a;
        this.yy=b;
    }

    
    public Vector3D sumarVectores(Vector3D a, Vector3D b) {
        double e = a.getX() + b.getX();
        double d = a.getY() + b.getY();
        double f = a.getZ() + b.getZ();
        Vector3D res = new Vector3D(e, d, f);
        return res;
    }

    public Vector3D restarVectores(Vector3D a, Vector3D b) {
        double e = a.getX() - b.getX();
        double d = a.getY() - b.getY();
        double f = a.getZ() - b.getZ();
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
    
    @Override
    public String toString(){
        return getX()+","+getY()+","+getZ(); 
    }

    public double getX() {
        return this.components[0];
    }

    public double getY() {
        return this.components[1];
    }

    public double getZ() {
        return this.components[2];
    }

}
