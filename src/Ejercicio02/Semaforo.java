package Ejercicio02;

import Semaforos.Hilos.HiloSemaforo;

import java.util.concurrent.Semaphore;

public class Semaforo {
    public static void main(String[] args) {
        // Semáforo que permite sólo 1 hiloe n la zona crítica
        Semaphore sem = new Semaphore(1);

        // Crear hilos
        HiloSemaforo hilo1 = new HiloSemaforo("hilo1", sem);
        HiloSemaforo hilo2 = new HiloSemaforo("hilo2", sem);
        HiloSemaforo hilo3 = new HiloSemaforo("hilo3", sem);
        HiloSemaforo hilo4 = new HiloSemaforo("hilo4", sem);
        HiloSemaforo hilo5 = new HiloSemaforo("hilo5", sem);

        // Iniciar hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        // Una vez terminan puedo ver el resultado final de la variable global
        System.out.println("Cantidad vocales: " + HiloSem.contador);

    }
}
