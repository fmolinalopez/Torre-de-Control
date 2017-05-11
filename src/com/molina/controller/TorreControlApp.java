package com.molina.controller;

import com.molina.model.Avion;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by User01 on 11/05/2017.
 */
public class TorreControlApp {


    public void start(){
        int option;

        while ((option = showMenu()) != 0){
            switch (option){
                case 1:
                    añadirAvion();
                    break;
                case 2:
                    mostrarAviones();
            }
        }
    }

    public void loadTestFlights(){
        Avion.detectarAvion("RY002", "RYANAIR", 900, 5);
        Avion.detectarAvion("RY102", "RYANAIR", 650, 475);
        Avion.detectarAvion("IB125", "IBERIA", 800, 500);
        Avion.detectarAvion("IB127", "IBERIA", 500, 450);
    }

    private void añadirAvion(){
        Scanner input = new Scanner(System.in);

        String codigoVuelo;
        String aerolinea;
        double velocidadDeteccion;
        Date FechaHoraDeteccion;
        double distanciaTorre;

        System.out.println("Codigo de vuelo:");
        codigoVuelo = input.nextLine();
        System.out.println("Aerolinea:");
        aerolinea = input.nextLine();
        System.out.println("Velodicdad de deteccion:");
        velocidadDeteccion = input.nextDouble();
        System.out.println("Distancia de la torre:");
        distanciaTorre = input.nextDouble();

        Avion.getAviones().add( new Avion( codigoVuelo,aerolinea,velocidadDeteccion,distanciaTorre ) );
    }

    private void mostrarAviones(){

        Avion.actualizarVelocidadDistancia();

        for (Avion avion: Avion.getAviones()){
            System.out.println(avion);
        }
    }

    private int showMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("****************************");
        System.out.println("* 1 - Añadir Avion         *");
        System.out.println("* 2 - Mostrar aviones      *");
        System.out.println("* 0 - Salir                *");
        System.out.println("****************************");
        System.out.println("Opción: ");

        option = input.nextInt();

        return option;
    }
}
