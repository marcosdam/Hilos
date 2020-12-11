package Ejercicio04;

import java.util.concurrent.Semaphore;

public class Relevos extends Thread{
    /* 4. Escribe una clase llamada Relevos que simule una carrera de relevos de la siguiente
    forma:
    - Cree 4 threads. Una vez creados los threads, se indicará que comience la
    carrera, con lo que uno de los threads deberá empezar a correr.

    - Cada thread escribirá por pantalla que está corriendo y correrá un par de
    segundos, después terminará pasando el testigo a otro de los hilos para que
    comience a correr, y terminando su ejecución (la suya propia).

    - Cuando el último thread termine de correr, el padre mostrará un mensaje
    indicando que todos los hijos han terminado.

    Ejemplo de ejecución:

    Todos los hilos creados
    Doy la salida !!!
    soy el Hilo 1, corriendo ...
    Terminé. Paso el testigo
    soy el Hilo 2, corriendo ...
    Terminé. Paso el testigo
    soy el Hilo 3, corriendo ...
    Terminé. Paso el testigo
    soy el Hilo 4, corriendo ...
    Terminé la carrera, soy el último
    Todos los hilos terminaron !!! */

    // sem
    private Semaphore semaphore;

    // Constructor con nombre
    public Relevos(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    // run
    @Override
    public void run() {
        //super.run();
        // 1. Avisar
        System.out.println("El hilo " + this.getName() + " va a empezar la carrera");
        // 2. Gestionar (semáforo)
        try {
            semaphore.acquire();    // Entra 1 (en el principal -> permits 1)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 3. Comienza a correr durante 2 segundos
        System.out.println("Soy " + this.getName() + " corriendo...");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 4. Pasa el relevo (libera el semáforo)
        System.out.println("Soy " + this.getName() + " y paso el testigo");
        semaphore.release();

    }
}
