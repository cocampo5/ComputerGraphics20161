package com.dis;

public class Matriz2D {

    private final double[][] matrix;

    public Matriz2D(double[][] matrix) {
        matrix = new double[3][3];
        this.matrix = matrix;

    }

    public double[][] getMatrix() {
        return matrix;
    }

}
