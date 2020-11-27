package EjemploBase.Hilos;
// extends Thread
public class HiloThread extends Thread{

    // Constructor vacío
    public HiloThread() {
    }

    // Generamos constructor con nommbre
    public HiloThread(String name) {
        super(name);
    }

    // Generamos constructor con nombre y prioridad
    public HiloThread(String name, int prioridad) {
        super(name);
        this.setPriority(prioridad);
    }

    // Método run (ejecutará el hilo)
    @Override
    public void run() {
        //super.run();
        System.out.println("Soy el hilo de tipo Thread " + this.getName() + " y mi prioridad es " + this.getPriority());
    }
}
