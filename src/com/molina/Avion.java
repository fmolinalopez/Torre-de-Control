package com.molina;

import java.util.*;

/**
 * Created by Fran on 03/05/2017.
 */
public class Avion {

    // Atributos
    static ArrayList<Avion> aviones = new ArrayList<>();

    private String codigoVuelo;
    private String aerolinea;
    private double velocidadDeteccion;
    private Date FechaHoraDeteccion;
    private double distanciaTorre;


    // Constructores

    public Avion() {
    }

    public Avion(String codigoVuelo, String aerolinea, double velocidadDeteccion, Date fechaHoraDeteccion, double distanciaTorre) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.velocidadDeteccion = velocidadDeteccion;
        this.FechaHoraDeteccion = fechaHoraDeteccion;
        this.distanciaTorre = distanciaTorre;
    }

    // Metodos

    public static Comparator<Avion> comparadorPorDistancia = new Comparator<Avion>() {
        @Override
        public int compare(Avion avion1, Avion avion2) {
            double res;

            res = avion1.getDistanciaTorre() - avion2.getDistanciaTorre();

            return (int)res;
        }
    };

    public static void detectarAvion(String codigoVuelo, String aerolinea, double velocidadDeteccion, double distanciaTorre) {
        Date fechaHoraActual = new Date();

        Avion avion = new Avion(codigoVuelo, aerolinea, velocidadDeteccion, fechaHoraActual, distanciaTorre);

        aviones.add(avion);

        if (preguntarLista()) mostrarAviones();

    }

    public static void actualizarVelocidadDistancia(){
        final int MILISEGUNDOS_EN_MINUTO = 1000;
        final double METROS_EN_KM = 1000;
        final double SEGUNDOS_EN_HORA = 3600;

        Date fechaHoraActual;

        long periodoDeTiempo;
        double velocidadMetrosSegundos;
        double kmRecorridos;


        for (Avion avion: aviones){

            fechaHoraActual  = new Date();

            periodoDeTiempo = (fechaHoraActual.getTime() - avion.getFechaHoraDeteccion().getTime()) / MILISEGUNDOS_EN_MINUTO;

            avion.setFechaHoraDeteccion(fechaHoraActual);

            velocidadMetrosSegundos = avion.getVelocidadDeteccion() * METROS_EN_KM / SEGUNDOS_EN_HORA;

            kmRecorridos = (velocidadMetrosSegundos * periodoDeTiempo) / METROS_EN_KM;

            avion.setDistanciaTorre(avion.getDistanciaTorre()-kmRecorridos);

        }
            Collections.sort(aviones, comparadorPorDistancia);
    }

    public static void mostrarAviones() {

        actualizarVelocidadDistancia();

        for (Avion avion: aviones) {
            System.out.println(avion);
        }
    }

    public static boolean preguntarLista(){
        Scanner input = new Scanner(System.in);
        char respuesta;

        System.out.println("Avion registrado, ¿quiere mostrar la lista de aviones?Y/N");
        respuesta = input.nextLine().toLowerCase().charAt(0);

        if (respuesta == 'y'){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Avion: " +
                "CodigoVuelo = " + codigoVuelo +
                ", aerolinea = " + aerolinea +
                ", velocidadDeteccion = " + velocidadDeteccion + "km/h" +
                ", FechaHoraDeteccion = " + FechaHoraDeteccion +
                ", distanciaTorre = " + distanciaTorre + "km";
    }

    // Accesores

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        if (this.codigoVuelo.equals("")){
            this.codigoVuelo = "Sin codigo";
        } else {
            this.codigoVuelo = codigoVuelo;
        }
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        if (this.aerolinea.equals("")){
            this.aerolinea = "Vuelo pirata";
        } else {
            this.aerolinea = aerolinea;
        }
    }

    public double getVelocidadDeteccion() {
        return velocidadDeteccion;
    }

    public void setVelocidadDeteccion(double velocidadDeteccion) {
        if (this.velocidadDeteccion < 0){
            this.velocidadDeteccion = 0;
        } else {
            this.velocidadDeteccion = velocidadDeteccion;
        }
    }

    public Date getFechaHoraDeteccion() {
        return FechaHoraDeteccion;
    }

    public void setFechaHoraDeteccion(Date fechaHoraDeteccion) {
        FechaHoraDeteccion = fechaHoraDeteccion;
    }

    public double getDistanciaTorre() {
        return distanciaTorre;
    }

    public void setDistanciaTorre(double distanciaTorre) {
        if (this.distanciaTorre < 0){
            this.distanciaTorre = 0;
        } else {
            this.distanciaTorre = distanciaTorre;
        }
    }

    public static ArrayList<Avion> getAviones() {
        return aviones;
    }
}
