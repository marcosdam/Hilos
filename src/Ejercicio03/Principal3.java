package Ejercicio03;

import java.util.concurrent.Semaphore;

public class Principal3 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);

        Trampas t1 = new Trampas("1", semaphore);
        Trampas t2 = new Trampas("2", semaphore);
        Trampas t3 = new Trampas("3", semaphore);

        t1.start();
        t2.start();
        t3.start();
    }
}
