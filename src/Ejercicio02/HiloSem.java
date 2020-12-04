package Ejercicio02;

import java.util.concurrent.Semaphore;
// extends Thread
public class HiloSem extends Thread{
    // 2. Crea una clase Java que utilice 5 hilos para contar el número de vocales que hay en
    // un determinado texto.
    // Cada hilo se encargará de contar una vocal diferente,
    // actualizando todos los hilos la misma variable común
    // que representa el número de vocales totales.
    // Para evitar condiciones de carrera se deben utilizar semáforos.

    // Semáforo y contador
    Semaphore semaphore;
    public static int contador = 0;

    // Constructor con nombre y semáforo
    public HiloSem(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    // Método run()
    @Override
    public void run() {
        // ??????
    }
}
