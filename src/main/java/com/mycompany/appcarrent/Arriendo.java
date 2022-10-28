/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appcarrent;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lalo Guzmán
 */
public class Arriendo {
    private int numeroArriendo;
    private GregorianCalendar fechaArriendo;
    private int nroDiasArriendo;
    private int montoArriendo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Devolucion devolucion;
    
    public Arriendo(int numeroArriendo, GregorianCalendar fechaArriendo, int nroDiasArriendo, int montoArriendo, Vehiculo vehiculo, Cliente cliente){
        setNumeroArriendo(numeroArriendo);
        setFechaArriendo(fechaArriendo);
        setNroDiasArriendo(nroDiasArriendo);
        setMontoArriendo(montoArriendo);
        setVehiculo(vehiculo);
        setCliente(cliente);

        ingresarArriendo();

    }
    
    /**
     * @return the numeroArriendo
     */
    public int getNumeroArriendo() {
        return numeroArriendo;
    }

    /**
     * @param numeroArriendo the numeroArriendo to set
     */
    public void setNumeroArriendo(int numeroArriendo) {
        this.numeroArriendo = numeroArriendo;
    }

    /**
     * @return the fechaArriendo
     */
    public GregorianCalendar getFechaArriendo() {
        return fechaArriendo;
    }

    /**
     * @param fechaArriendo the fechaArriendo to set
     */
    public void setFechaArriendo(GregorianCalendar fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    /**
     * @return the nroDiasArriendo
     */
    public int getNroDiasArriendo() {
        return nroDiasArriendo;
    }

    /**
     * @param nroDiasArriendo the nroDiasArriendo to set
     */
    public void setNroDiasArriendo(int nroDiasArriendo) {
        if (nroDiasArriendo < 1 || nroDiasArriendo > 10) {
            msjError("LA CANTIDAD DE DIAS DE ARRIENDO DEBE ESTAR ENTRE 1 Y 10 DIAS");
        }
        this.nroDiasArriendo = nroDiasArriendo;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the devolucion
     */
    public Devolucion getDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }
    
        /**
     * @return the montoArriendo
     */
    public int getMontoArriendo() {
        return montoArriendo;
    }

    /**
     * @param montoArriendo the montoArriendo to set
     */
    public void setMontoArriendo(int montoArriendo) {
        this.montoArriendo = montoArriendo;
    }
    
    private boolean evaluarArriendo() {
        // Validar estado del Vehiculo
        if ((getVehiculo().getEstado() != 'D') || (!getCliente().isVigenteCliente())) {
            //SOLO EN ESTE CASO ENVIAREMOS MENSAJE POR CONSOLA (SIN GENERAR EXCPETION) PARA PODER SERGUIR CON PRUEBA DE DEVOLUCION
            //msjError("VEHICULO Ó CLIENTE INVÁLIDOS");
            System.out.println("VEHICULO O CLIENTE INVALIDO, NO SE GENERA ARRIENDO");
            return false;
        }

        return true;
    }
    
    public boolean evaluarDevolucion(GregorianCalendar fechaDevol){
        if (getFechaArriendo().after(fechaDevol)){
            return false;
        }
        return true;
    }
    
    public boolean comparaVehiculos(Vehiculo vehiculoDevuleto){
        if (!getVehiculo().getPatente().equals(vehiculoDevuleto.getPatente())){
            return false;
        }
        if (!getVehiculo().getMarca().equals(vehiculoDevuleto.getMarca())){
            return false;
        }
        if (!getVehiculo().getModelo().equals(vehiculoDevuleto.getModelo())){
            return false;
        }
         if (getVehiculo().getAnnoFabricacion() != vehiculoDevuleto.getAnnoFabricacion()){
            return false;
        }
        return true;
    }
    
    public boolean ingresaDevolucion(GregorianCalendar fechaDevol, Vehiculo vehiculoDevuleto){
        if (!evaluarDevolucion(fechaDevol)) {
            msjError("FECHA DE DEVOLUCION DEBE SER POSTERIOR A LA FECHA DE ARRIENDO");
        }
        if (!comparaVehiculos(vehiculoDevuleto)){
            System.out.println("DATOS DEL VEHICULO DEVUELTO  NO CORRESPONDE AL ARRENDADO");
        } else {
            Devolucion devol = new Devolucion (fechaDevol);
            setDevolucion(devol);
            vehiculo.setEstado('D');
            System.out.println("DEVOLUCION GENERADA CON EXITO");
        }
        return true;
    }
    
    private boolean ingresarArriendo(){
        if (evaluarArriendo()){
            vehiculo.setEstado('A');
            generarTicket();
            return true;
        }
        return false;
    }
    
    private int montoPagar(){
        return (getNroDiasArriendo() * getMontoArriendo());
    }
    
    private void generarTicket(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");   
        System.out.println("\n\n" + "___________________________________________________________________________________________________\n"+
                "\t\tT I C K E T   A R R I E N D O   D E   V E H I C U L O" + "\n\n" +
                "\t\tNUMERO DE ARRIENDO: " + getNumeroArriendo() + "\n" +
                "\t\tVEHICULO          : " + getVehiculo().getPatente() + " " + getVehiculo().getMarca() + " " + getVehiculo().getModelo() + "\n" +
                "\t\tPRECIO DIARIO     : " + getMontoArriendo() + "\n\n" +
                "\t\tFECHA \t\tCLIENTE \t\t\tDIAS \tA PAGAR" + "\n" +
                "\t\t-----------------------------------------------------------------" + "\n" +
                "\t\t" + sdf.format(getFechaArriendo().getTime()) + 
                "\t" + getCliente().getRutCliente() + "/" + getCliente().getNombreCliente() +
                "\t" + getNroDiasArriendo() + " dias" +
                "\t$ " + montoPagar() +
                "\n\n\n\n\t\t\t\t\t\t" + "-----------------------" + "\n" +
                "\t\t\t\t\t\t\t" + "FIRMA" +
                "\n" + "___________________________________________________________________________________________________\n"
                );
        
    }
    private void msjError(String msj) {
        throw new IllegalArgumentException(msj);
    }

}
