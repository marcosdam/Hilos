package Ejercicio02;

import java.util.concurrent.Semaphore;
// extends Thread
public class Vocal extends Thread{
    // 2. Crea una clase Java que utilice 5 hilos para contar el número de vocales que hay en
    // un determinado texto.
    // Cada hilo se encargará de contar una vocal diferente,
    // actualizando todos los hilos la misma variable común
    // que representa el número de vocales totales.
    // Para evitar condiciones de carrera se deben utilizar semáforos.

    private Semaphore semaphore;
    private int numVocal;   // Cuenta las vocales de ÉSTE HILO
    public static int numVocalTotal = 0;    // Cuenta todas las vocales de TODOS LOS HILOS
    private char letra;
    private String frase;

    // (el semáforo lo inicializo en el principal, para que todos los hilos compartan semáforo)
    // Constructor con sem, char y String
    public Vocal(Semaphore semaphore, char letra, String frase) {
        this.semaphore = semaphore;
        this.letra = letra;
        this.frase = frase;
    }

    // Método run()
    @Override
    public void run() {
        // Comparar char con cada aracter de mi frase
        for (int i = 0; i < frase.length(); i++) {
            if(frase.charAt(i) == letra){
                numVocal++;
                // ZONA CRÍTICA
                try {
                    // 1 hilo entra al semáforo ("coge la plaza")
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                numVocalTotal++;    // Añade al total
                // SALE
                semaphore.release();    // "Libera la plaza"
            }
        }
        System.out.println("El número de " + letra + "s es " + numVocal);
    }
}
