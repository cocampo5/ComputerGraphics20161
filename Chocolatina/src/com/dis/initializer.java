package com.dis;

import java.io.IOException;

public class initializer {

    public ChocoScan res;
    
    public initializer() throws IOException {
        this.res = new ChocoScan();
        res.readLines();
    }
}
