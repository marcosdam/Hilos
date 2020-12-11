package Ejercicio01;

// extends Thread
public class Animal extends Thread {
    //1. Realiza un programa en el que crees una clase llamada Animal y tres objetos de
    // dicha clase: Tortuga, liebre, guepardo. Asigna un hilo a cada uno de ellos de forma
    // que se ejecuten concurrentemente y utiliza la asignación de prioridades para
    // establecer quién llegará el primero. La carrera será mediante un contador de
    // iteraciones y ganará el primero que llegue a 10000 iteraciones.

    // Para saber en qué posición termina
    public static int posicionFinal = 1;

    // Constructor con nombre
    public Animal(String name, int prioridad) {
        super(name);
        this.setPriority(prioridad);
    }

    // Método run
    @Override
    public void run() {
        //super.run();
        // Hilo que está entrando
        System.out.println("\nEntrando en la carrera " + this.getName());

        for (int i = 0; i < 10000; i++) {
            System.out.println(this.getName() + " lleva " + i);
        }
        // Fin de la carrera
        System.out.println("\n"+this.getName() + " ha terminado " + posicionFinal++ + "\n");
    }
}
