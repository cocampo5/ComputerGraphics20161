package com.dis.Graphics;

public class Matriz3D {

    private double[][] matrix = new double[4][4];

    public Matriz3D(double[][] matrix) {
        this.matrix = matrix;

    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[][] multMatriz(double[][] a, double[][] b) {
        int row1 = a.length;
        int col1 = a[0].length;
        int row2 = b.length;
        int col2 = b[0].length;
        double[][] result = new double[row1][col2];
        if (row1 != col2) {
            throw new RuntimeException("Array size error");
        } else {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    for (int k = 0; k < col1; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        return result;
    }

    public double[][] sumMatriz(double[][] a, double[][] b) {
        int row1 = a.length;
        int col1 = b[0].length;
        int row2 = a.length;
        int col2 = b[0].length;
        double[][] res = new double[4][4];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }

    public double[][] resMatriz(double[][] a, double[][] b) {
        int row1 = a.length;
        int col1 = b[0].length;
        int row2 = a.length;
        int col2 = b[0].length;
        double[][] res = new double[4][4];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        return res;
    }

    public double[][] multEscalar(double[][] a, double b) {
        int row1 = a.length;
        int col1 = a[0].length;
        double[][] res = new double[4][4];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                res[i][j] = a[i][j] * b;
            }
        }
        return res;
    }

    public double detMatrix(double[][] a) {
        int sum = 0;
        int s;
        if (a.length == 1) {
            return a[0][0];
        }

        for (int i = 0; i < a.length; i++) {
            double[][] cut = new double[a.length - 1][a[0].length];
            for (int j = 1; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    if (k < i) {
                        cut[j - 1][k] = a[j][k];
                    } else if (k > i) {
                        cut[j - 1][k - 1] = a[j][k];
                    }
                }
            }
            if (i % 2 == 0) {
                s = 1;
            } else {
                s = -1;
            }
            sum += s * a[0][i] * detMatrix(cut);
        }
        return sum;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = res + matrix[i][j] + ", ";
            }
            res = res + "\n";
        }

        return res;
    }
}
