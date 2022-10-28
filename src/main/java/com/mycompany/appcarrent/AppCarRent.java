/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.appcarrent;

import java.util.GregorianCalendar;

/**
 *
 * @author Lalo Guzmán
 */
public class AppCarRent {

    public static void main(String[] args) {
        
        System.out.println("Bienvenido al Sistema de Arriendo de Vehículos Grupo 15");
        System.out.println("=======================================================\n");
        

        //Genero una nueva instancia Cliente
        System.out.println("Prueba a) Instanciar un cliente:");
        Cliente c = new Cliente("10606333-K", "lalo guzman" );
        System.out.println(c.toString() + "\n");
        
        //Genero una nueva instancia vehículo
        System.out.println("Prueba b) Instanciar un vehículo:");
        Vehiculo v = new Vehiculo("XX-yy-23", "kia", "aVellA", 2019);
        System.out.println(v.toString() + "\n");
        
        //Se deshabilita Cliente creado
        System.out.println("Prueba c) deshabiltar Cliente:");
        c.deshabiltaCliente();
        System.out.println(c.toString() + "\n");
        
        //Se asigna vehículo a mantención
        System.out.println("Prueba d) vehículo en mantención:");
        v.vehiculoEnMantencion();
        System.out.println(v.toString() + "\n");
        
        //Se ingresan DOS arriendos
        //Arriendo 1 correcto
        System.out.println("Prueba e) Ingresar dos arriendos");
        System.out.println("Prueba e.1) Ingresar Arriendo Correcto");
        Cliente c1 = new Cliente("88888888-8", "Juan Perez Gonzalez" );
        System.out.println("Cliente 1 instanciado: \n" + c1.toString() + "\n");
        
        Vehiculo v1 = new Vehiculo("XX-ZZ-88", "Toyota", "Yaris", 2022);
        System.out.println("Vehiculo 1 instanciado: " + v1.toString() + "\n");
        
        GregorianCalendar f1 = new GregorianCalendar(2021, 0, 27);
        Arriendo a1 = new Arriendo(1, f1, 5, 35000, v1, c1);
        System.out.println("Estado Vehiculo 1: " + v1.toString() + "\n");
        
        //Arriendo 2 INcorrecto
        System.out.println("Prueba e.2) Ingresar Arriendo INcorrecto");
        Cliente c2 = new Cliente("11111111-1", "José Arredondo C." );
        GregorianCalendar f2 = new GregorianCalendar(2022, 8, 10);
        //intentaremos arrendar el mismo vehiculo que ya se encuentra en arriendo
        Arriendo a2 = new Arriendo(2, f2, 6, 10000, v1, c2);
        System.out.println("Estado Vehiculo 1: " + v1.toString() + "\n");
        
        //Devolución 1 conrrecta
        System.out.println("Prueba f) Ingresar dos devoluciones");
        System.out.println("Prueba f.1) Ingresar Devolucion Correcta");
        GregorianCalendar fd1 = new GregorianCalendar(2022, 1, 27);
        Vehiculo vDevuelta1 = new Vehiculo("XX-ZZ-88", "Toyota", "Yaris", 2022);

        boolean d1 = a1.ingresaDevolucion(fd1, vDevuelta1);        
        System.out.println("Estado Vehiculo 1: " + v1.toString() + "\n");
        
        //Devolucion 2 incorrecta por patente
        // Vuelvo estado a arrriendo de vehiculo 1 para probar error
        v1.setEstado('A');
        Vehiculo vDevuelta2 = new Vehiculo("XX-ZZ-99", "Toyota", "Yaris", 2022);
        boolean d2 = a1.ingresaDevolucion(fd1, vDevuelta2);
        System.out.println("Estado Vehiculo 1: " + v1.toString() + "\n");
    }
}
