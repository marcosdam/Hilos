package Ejercicio01;

public class Carrera {
    public static void main(String[] args) {
        // Hilos
        Animal tortuga = new Animal("Tortuga",1, 0);
        Animal liebre = new Animal("Liebre",2, 0);
        Animal guepardo = new Animal("Guepardo",3, 0);

        // Comenzar hilos
        tortuga.start();
        liebre.start();
        guepardo.start();
    }
}
