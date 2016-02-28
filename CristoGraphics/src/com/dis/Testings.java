package com.dis;

public class Testings {

    public Testings() {
        System.out.println("Testeando los métodos\n");
    }

    public void Point2D() {
        System.out.println("Testeando puntos 2D");
        Point2D a = new Point2D(3, 5);
        System.out.println(a.toString());
    }

    public void Point3D() {
        System.out.println("Testeando puntos 3D");
        Point3D a = new Point3D(1, 2, 3);
        System.out.println(a.toString());
    }

    public void TestHomoPoint2D() {
        System.out.println("Testeando Puntos Homogeneos 2D");
        HomoPoint2D a = new HomoPoint2D(3, 4, 9);
        System.out.println(a.toString());
    }

    public void TestHomoPoint3D() {
        System.out.println("Testeando Puntos Homogeneos 3D");
        HomoPoint3D a = new HomoPoint3D(3, 4, 9, 2);
        System.out.println(a.toString()+"\n");
    }

    public void Matriz2D() {
        System.out.println("Testeando Matrices2D");
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matriz2D aa = new Matriz2D(a);
        Matriz2D res = new Matriz2D(aa.multEscalar(a, 2));
        Matriz2D res1 = new Matriz2D(aa.multMatriz(a, a));
        Matriz2D res2 = new Matriz2D(aa.sumMatriz(a, res.getMatrix()));
        double res3 = aa.detMatrix(a);
        System.out.println("Multipliación por Escalar");
        System.out.println(res.toString());
        System.out.println("Matriz x Matriz");
        System.out.println(res1.toString());
        System.out.println("Sumando Matriz y Matriz");
        System.out.println(res2.toString());
        System.out.println("Determinante de la matriz");
        System.out.println(res3+"\n");

    }

    public void Matriz3D() {
        System.out.println("Testeando Matrices3D\n");
        double[][] a = {{1, 2, 3, 1}, {4, 5, 6, 1}, {7, 8, 9, 1}, {10, 11, 12, 1}};
        Matriz3D aa = new Matriz3D(a);
        Matriz3D res = new Matriz3D(aa.multEscalar(a, 2));
        Matriz3D res1 = new Matriz3D(aa.multMatriz(a, a));
        Matriz3D res2 = new Matriz3D(aa.sumMatriz(a, res.getMatrix()));
        double res3 = aa.detMatrix(a);
        System.out.println("Multipliación por Escalar");
        System.out.println(res.toString());
        System.out.println("Matriz x Matriz");
        System.out.println(res1.toString());
        System.out.println("Sumando Matriz y Matriz");
        System.out.println(res2.toString());
        System.out.println("Determinante de la matriz");
        System.out.println(res3+"\n");
    }

    public void Vector2D() {
        System.out.println("Testeando Vectores2D");
        Vector2D a = new Vector2D(3, 2);
        Vector2D b = new Vector2D(5, 7);
        Vector2D res1 = a.multVectScalar(a, 2);
        Vector2D res2 = a.sumarVectores(a, b);
        Vector3D res3 = a.productoCruz(a, b);
        double res4 = a.productoPunto(a, b);
        System.out.println("Vector 1");
        System.out.println(res1.getX() + "," + res1.getY());
        System.out.println("Vector 2");
        System.out.println(res2.getX() + "," + res2.getY());
        System.out.println("Producto cruz v1 x v2");
        System.out.println(res3.getX() + "," + res3.getY() + "," + res3.getZ());
        System.out.println("Producto punto v1 . v2");
        System.out.println(res4+"\n");
    }

    public void Vector3D() {
        System.out.println("Testeando Vectores3D");
        Vector3D a = new Vector3D(1, 3, 5);
        Vector3D b = new Vector3D(2, 4, 6);
        Vector3D res1 = a.multVectScalar(a, 2);
        Vector3D res2 = a.sumarVectores(a, b);
        Vector3D res3 = a.productoCruz(a, b);
        double res4 = a.productoPunto(a, b);
        System.out.println("Vector 1");
        System.out.println(res1.getX() + "," + res1.getY() + "," + res1.getZ());
        System.out.println("Vector 2");
        System.out.println(res2.getX() + "," + res2.getY() + "," + res2.getZ());
        System.out.println("Producto cruz v1 x v2");
        System.out.println(res3.getX() + "," + res3.getY() + "," + res3.getZ());
        System.out.println("Producto punto v1 . v2");
        System.out.println(res4+"\n");
    }

    public void multPuntHMatriz() {
        System.out.println("Multiplicando un punto homogeneo 2D por una Matriz2D");
        HomoPoint2D a = new HomoPoint2D(2, 3, 4);
        double[][] b = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        Matriz2D c = new Matriz2D(b);
        Matriz2D res = new Matriz2D(c.multMatriz(b,a.getCoordinates()));
        System.out.println(res.toString());
        System.out.println("Multiplicando un punto homogeneo 3D por una Matriz3D");
        HomoPoint3D d = new HomoPoint3D(2, 3, 4, 5);
        double[][] e = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        Matriz3D f = new Matriz3D(e);
        Matriz3D res1 = new Matriz3D(f.multMatriz(d.getCoordinates(), e));
        System.out.println(res1.toString());
    }

    public void ParSeg3D() {
        System.out.println("Ecuación Parametrica xyz");
        ParametricSegment3D a = new ParametricSegment3D(3, 4, 6, 8, 9, 12);
        System.out.println(a.toString());
    }
    
    public void ParSeg2D(){
        System.out.println("Ecuacion parametrica xy");
        ParametricSegment2D a = new ParametricSegment2D(3,4,12,16);
        System.out.println(a.toString());
    }

    public static void main(String args[]) {
        Testings test1 = new Testings();
        test1.Matriz2D();
        test1.Matriz3D();
        test1.Point2D();
        test1.Point3D();
        test1.TestHomoPoint2D();
        test1.TestHomoPoint3D();
        test1.Vector2D();
        test1.Vector3D();
        test1.multPuntHMatriz();
        test1.ParSeg2D();
        test1.ParSeg3D();
    }
}
