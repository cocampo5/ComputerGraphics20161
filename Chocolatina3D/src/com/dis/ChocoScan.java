package com.dis;


import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ChocoScan {

    private final ArrayList<HomoPoint3D> chocolatina = new ArrayList<>();

    public ChocoScan() {

    }

    public void readLines() {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("chocolatina3D.txt")));
            while (s.hasNext()) {
                String str = s.next();
                char[] myChar = str.toCharArray();
                //System.out.println(myChar.length);
                System.out.println(myChar);
                if(myChar.length == 10){
                    System.out.println("Coordenada");
                }
                else{
                    if (myChar.length == 3) {
                        System.out.println("Punto");
                    }
                    
                    if (myChar.length == 4) {
                        System.out.println("Punto");
                    }
                    
                    if (myChar.length == 5) {
                        System.out.println("Punto");
                    }
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

    public ArrayList<HomoPoint3D> getChocolatina() {
        return chocolatina;
    }

}
