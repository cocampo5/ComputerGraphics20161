package com.dis;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import com.dis.Graphics.*;

public class ChocoScan {

    //HomoPoint3D puntos[];
    //Vector3D vertices[];
    private final ArrayList<HomoPoint3D> choco_puntos = new ArrayList<>();
    private final ArrayList<Vector3D> choco_vectores = new ArrayList<>();

    public ChocoScan() {

    }

    public void readObjet(String file) throws IOException {
        Scanner read;
        try {
            read = new Scanner(new File(file));
            int nVertices = read.nextInt();
            //puntos = new HomoPoint3D[nVertices];
            for (int i = 0; i < nVertices; i++) {
                int x = read.nextInt();
                int y = read.nextInt();
                int z = read.nextInt();
                //System.out.println("P("+x+","+y+","+z+")");
                HomoPoint3D res = new HomoPoint3D(x, y, z, 1);
                choco_puntos.add(res);
                //puntos[i] = res;
            }
            int nEdges = read.nextInt();
            //vertices = new Vector3D[nEdges];
            for (int i = 0; i < nEdges; i++) {
                int init = read.nextInt();
                int finish = read.nextInt();
                System.out.println("Vertice del punto: " + init + " al " + finish);
                Vector3D res = new Vector3D(choco_puntos.get(init), choco_puntos.get(finish));
                //vertices[i] = new Vector3D(puntos[init], puntos[finish]);
                choco_vectores.add(res);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public ArrayList<HomoPoint3D> getChoco_puntos() {
        return choco_puntos;
    }

    public ArrayList<Vector3D> getChoco_vectores() {
        return choco_vectores;
    }

//    public HomoPoint3D[] getPuntos() {
//        return puntos;
//    }
//
//    public Vector3D[] getVertices() {
//        return vertices;
//    }
}
