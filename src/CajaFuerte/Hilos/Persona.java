package CajaFuerte.Hilos;

import java.util.concurrent.Semaphore;

// extends Thread
public class Persona extends Thread{
    Semaphore sem;
    private int cantidadPersona;
    public static int cantidadBanco = 12700;

    // Constructor con nombre
    public Persona(String name, Semaphore sem, int cantidadPersona) {
        super(name);
        this.sem = sem;
        this.cantidadPersona = cantidadPersona;
    }

    // Método run
    @Override
    public void run() {
        //super.run();
        // Controlar que sólo entre 1 un hilo (persona) al banco
        System.out.println("Entrando en el banco " + this.getName());   // Hilo que está entrando

        // COMIENZO ZONA CRÍTICA (sem.acquire())
        try {
            sem.acquire();
            //DENTRO ZONA CRÍTICA
            System.out.println("Soy " + this.getName() + " y estoy dentro de la caja fuerte");

            cantidadBanco += cantidadPersona;
            sleep(200);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
        // FIN ZONA CRÍTICA (sem.release())

        System.out.println("Salgo del banco " + this.getName());    // Hilo que sale

    }
}
