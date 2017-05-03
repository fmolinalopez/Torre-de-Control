package com.molina;

import java.util.Date;

/**
 * Created by Fran on 03/05/2017.
 */
public class Avion {

    // Atributos
    private String codigoVuelo;
    private String aerolinea;
    private int velocidadDeteccion;
    private Date FechaHoraDeteccion;
    private double distanciaTorre;


    // Constructores

    public Avion() {
    }

    public Avion(String codigoVuelo, String aerolinea, int velocidadDeteccion, Date fechaHoraDeteccion, double distanciaTorre) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.velocidadDeteccion = velocidadDeteccion;
        FechaHoraDeteccion = fechaHoraDeteccion;
        this.distanciaTorre = distanciaTorre;
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

    public int getVelocidadDeteccion() {
        return velocidadDeteccion;
    }

    public void setVelocidadDeteccion(int velocidadDeteccion) {
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
}