package com.molina;


import com.molina.controller.TorreControlApp;

public class Main {

    public static void main(String[] args) {
        TorreControlApp torreControlApp = new TorreControlApp();

        torreControlApp.loadTestFlights();

        torreControlApp.start();

    }
}
