package Ejercicio04;

import java.util.concurrent.Semaphore;

public class Principal4 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Relevos r1 = new Relevos("Relevo 1", semaphore);
        Relevos r2 = new Relevos("Relevo 2", semaphore);
        Relevos r3 = new Relevos("Relevo 3", semaphore);
        Relevos r4 = new Relevos("Relevo 4", semaphore);

        r1.start();
        r2.start();
        r3.start();
        r4.start();

        try {
            r1.join();
            r2.join();
            r3.join();
            r4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Mensaje del principal
        System.out.println("Todos los hilos terminaron");
    }
}
