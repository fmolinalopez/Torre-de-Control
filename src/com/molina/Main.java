package com.molina;


public class Main {

    public static void main(String[] args) {


        Avion.detectarAvion("IB125", "IBERIA", 800, 500);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
        Avion.detectarAvion("IB127", "IBERIA", 500, 450);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
        Avion.detectarAvion("IB122", "IBERIA", 650, 475);

    }
}
