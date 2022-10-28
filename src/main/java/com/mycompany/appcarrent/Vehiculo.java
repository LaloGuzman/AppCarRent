/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appcarrent;

import java.time.LocalDate;


/**
 *
 * @author Lalo Guzmán
 */
public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int annoFabricacion;
    private char estado;
    
    public Vehiculo(String patente, String marca, String modelo, int annoFabricacion){
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnnoFabricacion(annoFabricacion);
        setEstado('D');
    }

    /**
     * @return the patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * @param patente the patente to set
     */
    public void setPatente(String patente) {
        if (patente.length() != 8) {
            msjError("EL LARGO DE LA PATENTE DEBE SER DE 8");
        }
        this.patente = patente.toUpperCase();
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca.toUpperCase();
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo.toUpperCase();
    }

    /**
     * @return the annoFabricacion
     */
    public int getAnnoFabricacion() {
        return annoFabricacion;
    }

    /**
     * @param annoFabricacion the annoFabricacion to set
     */
    public void setAnnoFabricacion(int annoFabricacion) {
        LocalDate current_date = LocalDate.now();
        int current_Year = current_date.getYear();
        if (annoFabricacion < 2000 || annoFabricacion > current_Year) {
            msjError("EL AÑO DE FABRICACIÓN DEBE SER MAYOR O IGUAL AL AÑO 2000 Y MENOR IGUAL AL ACTUAL");
        }
        this.annoFabricacion = annoFabricacion;
    }

    /**
     * @return the estado
     */
    public char getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(char estado) {
        if (estado != 'A' && estado != 'D' && estado != 'M') {
            msjError("EL ESTADO DEL VEHÍCULO NO ES VÁLIDO");
        }
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "PATENTE   : " + getPatente() + "\n" +
                "MODELO   : " + getModelo() + "\n" +
                "MARCA    : " + getMarca() + "\n" +
                "ANHO     : " + getAnnoFabricacion() + "\n" +
                "CONDICION: " + getEstado();
    }
    
    public void vehiculoEnMantencion() {
        if (getEstado() != 'A') {
            setEstado('M');
        }else{
            msjError("VEHICULO EN ARRIENDO, NO PUEDE IR A MANTENCION");
        }
        
    }
    
    private void msjError(String msj) {
        throw new IllegalArgumentException(msj);
    }
}
