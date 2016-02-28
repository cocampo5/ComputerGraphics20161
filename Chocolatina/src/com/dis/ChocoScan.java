package com.dis;

import com.dis.Graphics.HomoPoint2D;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ChocoScan {

    private final ArrayList<HomoPoint2D> chocolatina = new ArrayList<>();

    public ChocoScan() {

    }

    public void readLines() {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("chocolatina.txt")));
            while (s.hasNext()) {
                String str = s.next();
                char[] myChar = str.toCharArray();
                System.out.println(myChar.length);
                System.out.println(myChar);
                if (myChar.length == 2) {
                    //System.out.println("Punto " + myChar[0] + "," + myChar[1]);
                } else if (myChar.length == 5) {
                    String x = myChar[0] + "" + myChar[1];
                    double xf = Double.parseDouble(x);
                    String y = myChar[3] + "" + myChar[4];
                    double yf = Double.parseDouble(y);
                    HomoPoint2D res = new HomoPoint2D(xf, yf, 1);
                    //System.out.println(xf + "," + yf);
                    chocolatina.add(res);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    public ArrayList<HomoPoint2D> getChocolatina() {
        return chocolatina;
    }

}
