package com.molina.model;

import java.util.*;

/**
 * Created by Fran on 03/05/2017.
 */
public class Avion implements Comparable<Avion>, Comparator<Avion> {

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

    public Avion(String codigoVuelo, String aerolinea, double velocidadDeteccion, double distanciaTorre) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.velocidadDeteccion = velocidadDeteccion;
        this.distanciaTorre = distanciaTorre;
    }

    public Avion(String codigoVuelo, String aerolinea, double velocidadDeteccion, Date fechaHoraDeteccion, double distanciaTorre) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.velocidadDeteccion = velocidadDeteccion;
        this.FechaHoraDeteccion = fechaHoraDeteccion;
        this.distanciaTorre = distanciaTorre;
    }

    // Metodos


    @Override
    public int compareTo(Avion avion) {

        double res;

        res = this.getDistanciaTorre() - avion.getDistanciaTorre();

        return (int)res;
    }

    @Override
    public int compare(Avion av1, Avion av2) {
        int res;

        res = av1.getAerolinea().compareTo(av2.getAerolinea());

        if (res != 0){
            return res;
        }

        return (int)(av1.getDistanciaTorre() - av2.getDistanciaTorre());
    }

//      public static Comparator<Avion> comparadorPorVelocidad = new Comparator<Avion>() {
//        @Override
//        public int compare(Avion avion1, Avion avion2) {
//
//            return (int)(avion1.getVelocidadDeteccion() - avion2.getVelocidadDeteccion());
//        }
//    };

    public static void detectarAvion(String codigoVuelo, String aerolinea, double velocidadDeteccion, double distanciaTorre) {
        Date fechaHoraActual = new Date();

        Avion avion = new Avion(codigoVuelo, aerolinea, velocidadDeteccion, fechaHoraActual, distanciaTorre);

        aviones.add(avion);
    }

    public static void actualizarVelocidadDistancia(){
        Iterator<Avion> itAviones = aviones.iterator();

        final int MILISEGUNDOS_EN_MINUTO = 1000;
        final double METROS_EN_KM = 1000;
        final double SEGUNDOS_EN_HORA = 3600;

        Date fechaHoraActual;

        long periodoDeTiempo;
        double velocidadMetrosSegundos;
        double kmRecorridos;

        while ( itAviones.hasNext() ){

            Avion avion = itAviones.next();

            fechaHoraActual  = new Date();

            periodoDeTiempo = (fechaHoraActual.getTime() - avion.getFechaHoraDeteccion().getTime()) / MILISEGUNDOS_EN_MINUTO;

            velocidadMetrosSegundos = avion.getVelocidadDeteccion() * METROS_EN_KM / SEGUNDOS_EN_HORA;

            kmRecorridos = (velocidadMetrosSegundos * periodoDeTiempo) / METROS_EN_KM;

            avion.setDistanciaTorre(avion.getDistanciaTorre()-kmRecorridos);

            avion.setFechaHoraDeteccion(fechaHoraActual);

            if (avion.getDistanciaTorre() <= 0 ) {
                System.out.println("Avion borrado.");
                itAviones.remove();
            }
        }
            Collections.sort(aviones);
    }

    public void ordernar(){
        Collections.sort(aviones,new Avion());
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
