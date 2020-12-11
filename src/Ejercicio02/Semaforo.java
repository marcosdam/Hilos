package Ejercicio02;

import Semaforos.Hilos.HiloSemaforo;

import java.util.concurrent.Semaphore;

public class Semaforo {
    public static void main(String[] args) {
        // Semáforo que permite sólo 1 hilo en la zona crítica
        Semaphore sem = new Semaphore(1);

        // Crear hilos
        String frase = "Cyberpunk está guapísimo";
        Vocal aVocal = new Vocal(sem, 'a', frase);
        Vocal eVocal = new Vocal(sem, 'e', frase);
        Vocal iVocal = new Vocal(sem, 'i', frase);
        Vocal oVocal = new Vocal(sem, 'o', frase);
        Vocal uVocal = new Vocal(sem, 'u', frase);

        // Iniciar hilos
        aVocal.start();
        eVocal.start();
        iVocal.start();
        oVocal.start();
        uVocal.start();

        try {
            aVocal.join();
            eVocal.join();
            iVocal.join();
            oVocal.join();
            uVocal.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Una vez terminan puedo ver el resultado final de la variable global
        System.out.println("Número total de vocales: " + Vocal.numVocalTotal);

    }
}
