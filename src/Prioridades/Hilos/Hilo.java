package Prioridades.Hilos;
// extends Thread
public class Hilo extends Thread{

    // Constructor vacío
    public Hilo() {
    }

    // Constructor con nombre
    public Hilo(String name) {
        super(name);
    }

    // Constructor con nombre y prioridad
    public Hilo(String name, int prioridad) {
        super(name);
        this.setPriority(prioridad);
    }

    // Método run
    @Override
    public void run() {
        // super.run();
        int contador = 0;
        int vueltas = 0;
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (contador == 1000){
                contador = 0;
                vueltas++;
            }
            System.out.println(this.getName() + ": Vueltas: " + vueltas + " --> " + contador++);
        }
    }
}
