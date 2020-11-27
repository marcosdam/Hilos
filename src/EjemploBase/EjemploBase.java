package EjemploBase;

import EjemploBase.Hilos.HiloRunnable;
import EjemploBase.Hilos.HiloThread;

public class EjemploBase {
    public static void main(String[] args) {
        // Creamos los hilos (HiloThread)
        // Las prioridades van de 1 a 10 (1 la más lenta, 10 la más rápida)
        HiloThread hiloThread1 = new HiloThread("Hilo T1");
        HiloThread hiloThread2 = new HiloThread("Hilo T1", 10);
        HiloThread hiloThread3 = new HiloThread();

        hiloThread3.setName("Hilo T3");
        hiloThread3.setPriority(1);

        // Creamos los hilos (HiloRunnable)
        HiloRunnable hiloRunnable1 = new HiloRunnable("Hilo R1");
        HiloRunnable hiloRunnable2 = new HiloRunnable("Hilo R2", 10);

        // Los hilosThread tenemos que iniciarlos en Main (los Runnable en los constructores de su clase)
        hiloThread1.start();
        hiloThread2.start();
        hiloThread3.start();

        System.out.println("Soy el hilo principal y he terminado");


    }
}
