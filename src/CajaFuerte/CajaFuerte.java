package CajaFuerte;

import CajaFuerte.Hilos.Persona;

import java.util.concurrent.Semaphore;

/*
CAJA INICIAL -> 12.700€

*  PEPE -> Introducir 3.000€
*  MARIA -> Sacar 2.500€
*  JOSE -> Sacar 1.200€
*  LAURA -> Introducir 1.700€

Entran al banco, piden permiso para entrar, entran a la caja fuerte, piden permiso para depositar, lo hacen
* */
public class CajaFuerte {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Persona Pepe = new Persona("Pepe", semaphore, 3000);
        Persona Maria = new Persona("Maria", semaphore, -2500);
        Persona Jose = new Persona("Jose", semaphore, -1200);
        Persona Laura=  new Persona("Laura", semaphore, 1700);

        Pepe.start();
        Maria.start();
        Jose.start();
        Laura.start();

        // Avisar de que han terminado (join)
        try {
            Pepe.join();
            Maria.join();
            Jose.join();
            Laura.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Decir cuánto dinero queda en el banco
        System.out.println( "El banco tiene al final del día" + Persona.cantidadBanco);
    }

}
