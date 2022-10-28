/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appcarrent;

import java.util.Arrays;

/**
 *
 * @author Lalo Guzmán
 */
public class Cliente {
    private String rutCliente;
    private String nombreCliente;
    private boolean vigenteCliente;
    
    public Cliente(String rutCliente, String nombreCliente){
        setRutCliente(rutCliente);
        setNombreCliente(nombreCliente);
        setVigenteCliente(true);
    }

    /**
     * @return the rutCliente
     */
    public String getRutCliente() {
        return rutCliente;
    }

    /**
     * @param rutCliente the rutCliente to set
     */
    public void setRutCliente(String rutCliente) {
        if (rutCliente.length() != 10) {
            msjError("EL LARGO DE RUT DEBE SER DE 10");
        }else{
            if (rutCliente.charAt(8) != '-'){
                msjError("EL RUT DEBE CONTENER UN GUION EN LA PENULTIMA POSICION");
            }else{
                String[] partesRut = rutCliente.split("-");
                String parteRut2 = partesRut[1];
                if( !Arrays.asList("0","1","2","3","4","5","6","7","8","9","k","K").contains(parteRut2)){
                    msjError("EL DIGITO FINAL DEBE SER UN NUMERO DE 0 A 9 o K");
                }
            }
        }
        this.rutCliente = rutCliente;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the vigenteCliente
     */
    public boolean isVigenteCliente() {
        return vigenteCliente;
    }

    /**
     * @param vigenteCliente the vigenteCliente to set
     */
    public void setVigenteCliente(boolean vigenteCliente) {
        this.vigenteCliente = vigenteCliente;
    }
    
    @Override
    public String toString() {
        return "RUT: " + getRutCliente() + " NOMBRE: " + getNombreCliente() + " VIGENTE: " + isVigenteCliente();
    }
    
    public void deshabiltaCliente(){
        setVigenteCliente(false);
    }
    
    private void msjError(String msj) {
        throw new IllegalArgumentException(msj);
    }
    
    // Este método no se solicita en el ejercicio pero se crea para poder volver a habilitar cliente después de pruebas de deshabilitación
    public void habiltaCliente(){
        setVigenteCliente(true);
    }
}
