package Ejercicio05;

import java.util.concurrent.Semaphore;

public class Banco extends Thread{
    /* 5. Crear un programa en java que gestione la entrada de los hilos en secciones críticas
    con semáforos. En nuestras secciones críticas solo puede entrar un hilo.
    Para este programa tendremos 4 hilos y unas cantidades asociadas (Andrea 5000,
    Leonardo 4000, Sansón 6000, Sara 7000). El banco tendrá una variable global
    “dinero” que representará el dinero global que tiene el banco. Los hilos entrarán a las
    cámaras acorazadas(secciones críticas) y harán operaciones.

    Los hilos deberán ejecutarse y hacer lo siguiente:
    - Avisar de la entrada en el banco.
    - Avisar que va a solicitar entrada a la cámara acorazada.

    Dentro de la primera zona crítica:
    - Avisar la entrada en la cámara acorazada.
    - Sumar la cantidad del hilo 2 veces al dinero del banco.
    - Sumarle 1000 al dinero del banco.
    - Avisar de la salida de la cámara acorazada.

    Dentro de la segunda zona crítica:
    - Avisar de la entrada en la cámara acorazada PLUS.
    - Multiplicar por 2 la cantidad del banco.
    - Restar la cantidad del hilo a la del banco.
    - Avisar de la salida de la cámara acorazada PLUS.

    Todos los hilos avisarán de su nombre al entrar y salir del banco, así como cada vez
    que realicen una operación.
    El hilo principal deberá decir cuánto dinero queda al final en la cámara acorazada
    después del paso de todos los hilos. */

    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        Cliente Andrea = new Cliente("Andrea", 5000, semaphore1, semaphore2);
        Cliente Leonardo = new Cliente("Leonardo", 4000, semaphore1, semaphore2);
        Cliente Sansón = new Cliente("Sansón", 6000, semaphore1, semaphore2);
        Cliente Sara = new Cliente("Sara", 7000, semaphore1, semaphore2);

        Andrea.start();
        Leonardo.start();
        Sansón.start();
        Sara.start();

        try {
            Andrea.join();
            Leonardo.join();
            Sansón.join();
            Sara.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El dinero de la cámara acorazada al final del día es " + CajaFuerte.dineroBanco);
    }
}
