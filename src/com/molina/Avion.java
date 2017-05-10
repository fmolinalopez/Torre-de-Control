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

        Date fechaHoraActual = new Date();

        double res;
        double velocidadKmH;

        for (Avion avion: aviones){
            res = (fechaHoraActual.getTime() - avion.getFechaHoraDeteccion().getTime());
            res = res/(1000*60*60*24);
            velocidadKmH = avion.getVelocidadDeteccion();

            avion.setDistanciaTorre(avion.getDistanciaTorre()-velocidadKmH*res);
        }
    }

    public static void mostrarAviones() {

        actualizarVelocidadDistancia();

        Collections.sort(aviones, comparadorPorDistancia);

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
        this.codigoVuelo = codigoVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public double getVelocidadDeteccion() {
        return velocidadDeteccion;
    }

    public void setVelocidadDeteccion(double velocidadDeteccion) {
        this.velocidadDeteccion = velocidadDeteccion;
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
        this.distanciaTorre = distanciaTorre;
    }

    public static ArrayList<Avion> getAviones() {
        return aviones;
    }
}
