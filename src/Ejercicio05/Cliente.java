package Ejercicio05;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread{
    private int dinero;
    Semaphore sem1;
    Semaphore sem2;

    public Cliente(String name, int dinero, Semaphore sem1, Semaphore sem2) {
        super(name);
        this.dinero = dinero;
        this.sem1 = sem1;
        this.sem2 = sem2;
    }

    @Override
    public void run() {
        //super.run();
        System.out.println("Soy " + this.getName() + " y entro en el banco");
        System.out.println("Soy " + this.getName() + " y pido permiso para entrar en la cámara acorazada");

        // Entro al sem1
        try {
            sem1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Soy " + this.getName() + " e ingreso en el banco " + (dinero*2));
        CajaFuerte.dineroBanco += dinero*2;
        System.out.println("Soy " + this.getName() + " e ingreso en el banco 1000");
        CajaFuerte.dineroBanco += 1000;
        System.out.println("Soy " + this.getName() + " y salgo de la cámara acorazada");

        // Libero el sem1
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem1.release();

        ////////////////////////////////////////////////////
        // Segunda Zona Crítica
        try {
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Soy " + this.getName() + " y entro en la cámara acorazada PLUS");
        CajaFuerte.dineroBanco *= 2;
        System.out.println("Soy el hilo " + this.getName() + " y retiro " + dinero);
        CajaFuerte.dineroBanco -= dinero;
        System.out.println("Soy " + this.getName() + " y salgo de la cámara acorazada PLUS");

        // Libero el sem2
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem2.release();

        System.out.println("Soy " + this.getName() + " y salgo del banco");
    }
}
