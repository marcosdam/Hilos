package Ejercicio01;

public class Carrera {
    public static void main(String[] args) {
        // Hilos
        Animal tortuga = new Animal("Tortuga",1);
        Animal liebre = new Animal("Liebre",5);
        Animal guepardo = new Animal("Guepardo",10);

        // Comenzar hilos
        tortuga.start();
        liebre.start();
        guepardo.start();

        // Esperar a que un hilo termine para que el hilo principal avise
        try {
            guepardo.join();
            tortuga.join();
            liebre.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Soy el hilo principal y el resto han terminado");
    }
}
