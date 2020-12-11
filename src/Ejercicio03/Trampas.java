package Ejercicio03;

import java.util.concurrent.Semaphore;

public class Trampas extends Thread{
    // 3. Escribe una clase llamada Trampas que cree tres hilos y fuerce que la escritura del
    //segundo sea siempre anterior a la escritura por pantalla de los otros dos y la del
    //tercero sea anterior a la del primero. Ejemplo de ejecución:
    //Hola, soy el thread número 2
    //Hola, soy el thread número 3
    //Hola, soy el thread número 1

// Sem
    private Semaphore semaphore;
// Constructor con nombre y sem
    public Trampas(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    //Método run
    @Override
    public void run() {
        //super.run();
        if (this.getName().equals("2")){
            System.out.println("Soy el hilo " + this.getName());
            // Libero LAS 2 PLAZAS
            semaphore.release(2);
        }
        if (this.getName().equals("3") ||this.getName().equals("1")){
            try {
                // Bloqueamos al 3 y al 1 (el 2 puede entrar)
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Igualar los 2 hilos
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Mostrar primero el 3 y luego el 1
            if (this.getName().equals("3")){
                System.out.println("Hola soy el hilo " + this.getName());
                semaphore.release();
            }
            if (this.getName().equals("1")){
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hola soy el hilo " + this.getName());
            }
        }
    }
}
