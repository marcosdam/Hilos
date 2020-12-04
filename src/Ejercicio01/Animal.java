package Ejercicio01;
// extends Thread
public class Animal extends Thread {
    //1. Realiza un programa en el que crees una clase llamada Animal y tres objetos de
    // dicha clase: Tortuga, liebre, guepardo. Asigna un hilo a cada uno de ellos de forma
    // que se ejecuten concurrentemente y utiliza la asignación de prioridades para
    // establecer quién llegará el primero. La carrera será mediante un contador de
    // iteraciones y ganará el primero que llegue a 10000 iteraciones.
    private int prioridad;
    private int contador;
    public static int ganador = 0;

    // Constructor con nombre
    public Animal(String name, int prioridad, int contador) {
        super(name);
        this.prioridad = prioridad;
        this.contador = contador;
    }

    // Método run
    @Override
    public void run() {
        //super.run();
        // Controlar que sólo entre 1 un hilo (animal) a la carrera
        System.out.println("Entrando en la carrera " + this.getName());   // Hilo que está entrando

        for (contador = 0; contador < 10000; contador++) {
            System.out.println(this.getName() + " lleva " + contador);
        }
        ganador++;

        if (contador == 10000){
            if (this.ganador == 1){
                System.out.println("GANADOR -> " + this.getName());
            }
        }
        //System.out.println("\n" + this.getName() + " ha quedado " + ganador);

        // FIN
        System.out.println("Salgo de la carrera " + this.getName());    // Hilo que sale

    }
}
