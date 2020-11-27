package Semaforos.Hilos;

import java.util.concurrent.Semaphore;
// extends Thread
public class HiloSemaforo extends Thread{
    // Semáforo y contador
    Semaphore sem;
    public static int contador = 0;


    // Constructo con nombre y semáforo
    public HiloSemaforo(String name, Semaphore sem) {
        super(name);
        this.sem = sem;
    }

    // Método run()
    @Override
    public void run() {
        //super.run();
        // Primero vamos a detectar el hilo de nombre A
        if (this.getName().equalsIgnoreCase("A")){
            System.out.println("Empezando " + this.getName());
            System.out.println(this.getName() + ". Voy a pedir permiso para entrar en el semáforo");
            // Pedir permiso para entrar en el semáforo
            try {
                // Pide el acceso al hilo
                // (si el semáforo tiene plazas libres, el hilo entrará y continuará ejecutando su código)
                // Si al semáforo no le quedan plazas libres, el hilo se bloqueará hasta que hayan plazas libres
                sem.acquire();

                // Una vez pasado el acquire, me encuentro la ZONA CRÍTICA
                // (la parte del código vulnerable a condiciones de carrera)
                System.out.println("Soy el hilo " + this.getName() + " y he entrado");

                // Ahora accedemos al recurso compartido
                for (int i = 0; i < 5; i++) {
                    contador++;
                    System.out.println(this.getName() + ": " + contador);
                }

                // Uso sleep para suspender el hilo unos milisegundos   ->  1000 milisegundos = 1 segundo
                sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Una vez terminada mi zona crítica libero el semáforo
            System.out.println(this.getName() + " libero el semáforo");
            sem.release();
        }
        else {  // contador-- en el bucle
            if (this.getName().equalsIgnoreCase("B")){
                System.out.println("Empezando " + this.getName());
                System.out.println(this.getName() + ". Voy a pedir permiso para entrar en el semáforo");
                // Pedir permiso para entrar en el semáforo
                try {
                    // Pide el acceso al hilo
                    // (si el semáforo tiene plazas libres, el hilo entrará y continuará ejecutando su código)
                    // Si al semáforo no le quedan plazas libres, el hilo se bloqueará hasta que hayan plazas libres
                    sem.acquire();

                    // Una vez pasado el acquire, me encuentro la ZONA CRÍTICA
                    // (la parte del código vulnerable a condiciones de carrera)
                    System.out.println("Soy el hilo " + this.getName() + " y he entrado");

                    // Ahora accedemos al recurso compartido
                    for (int i = 0; i < 5; i++) {
                        contador--;
                        System.out.println(this.getName() + ": " + contador);
                    }

                    // Uso sleep para suspender el hilo unos milisegundos   ->  1000 milisegundos = 1 segundo
                    sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Una vez terminada mi zona crítica libero el semáforo
                System.out.println(this.getName() + " libero el semáforo");
                sem.release();
            }
        }

    }
}
