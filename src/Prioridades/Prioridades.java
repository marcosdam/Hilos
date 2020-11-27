package Prioridades;

import Prioridades.Hilos.Hilo;

public class Prioridades {
    public static void main(String[] args) {
        // Crear hilo
        Hilo contador1 = new Hilo("Contador 1", 1);
        Hilo contador2 = new Hilo("Contador 2", 3);
        Hilo contador3 = new Hilo("Contador 3", 5);
        Hilo contador4 = new Hilo("Contador 4", 7);
        Hilo contador5 = new Hilo("Contador 5", 9);
        Hilo contador6 = new Hilo("Contador 6", 10);

        // Ponerlos en marcha
        contador1.start();
        contador2.start();
        contador3.start();
        contador4.start();
        contador5.start();
        contador6.start();
    }
}
