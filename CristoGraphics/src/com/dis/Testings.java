package com.dis;

public class Testings {

    public Testings() {

    }

    public static void main(String args[]) {
        Vector2D a = new Vector2D(3, 2);
        Vector2D b = new Vector2D(5, 7);
        Vector3D c = new Vector3D(1, 3, 5);
        Vector3D d = new Vector3D(2, 4, 6);
        Vector2D res1 = a.multVectScalar(a, 2);
        Vector2D res2 = a.sumarVectores(a, b);
        Vector3D res3 = a.productoCruz(a, b);
        double res4 = a.productoPunto(a, b);
        System.out.println(res1.getX() + "," + res1.getY());
        System.out.println(res2.getX() + "," + res2.getY());
        System.out.println(res3.getX() + "," + res3.getY() + "," + res3.getZ());
        System.out.println(res4);

        Vector3D res5 = c.multVectScalar(c, 2);
        Vector3D res6 = c.sumarVectores(c, d);
        Vector3D res7 = c.productoCruz(c, d);
        double res8 = c.productoPunto(c, d);

        System.out.println(res5.getX() + "," + res5.getY() + "," + res5.getZ());
        System.out.println(res6.getX() + "," + res6.getY() + "," + res6.getZ());
        System.out.println(res7.getX() + "," + res7.getY() + "," + res7.getZ());
        System.out.println(res8);
    }
}
