package com.dis;

public class Matriz3D {

    private double [][] matriz;

    public Matriz3D(double[][] matriz) {
        matriz = new double[4][4];
        this.matriz = matriz;
    }

    public double[][] getMatriz() {
        return matriz;
    }

}
