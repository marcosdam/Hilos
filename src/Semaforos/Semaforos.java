package Semaforos;

import Semaforos.Hilos.HiloSemaforo;

import java.util.concurrent.Semaphore;

public class Semaforos {
    public static void main(String[] args) {
        // Crear e inicializar semáforo en el main y pasarlo a los hilos en el constructor
        // para que los hilos compartan el semáforo
        Semaphore sem = new Semaphore(1);   // Posiciones libres con las que empieza el sem (1)
        // Solo 1 hilo podrá entrar en la zona crítica, el resto se bloquearán al no haber espacio
        HiloSemaforo hiloA = new HiloSemaforo("A", sem);
        HiloSemaforo hiloB = new HiloSemaforo("B", sem);

        // Iniciar hilos
        hiloA.start();
        hiloB.start();

        // Decir al padre (hilo Principal) que espere a que los hilos terminen para continuar su ejecución
        try {
            // JOIN     ->      hilo.join()
            hiloA.join();
            hiloB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Una vez terminan puedo ver el resultado final de la variable global
        System.out.println("El resultado final de la variable global es: " + HiloSemaforo.contador);
    }
}
