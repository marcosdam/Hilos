package EjemploBase.Hilos;
// implements Runnable
public class HiloRunnable implements Runnable{
    // Declarar Thread
    Thread t;

    // Crear constructor con nombre
    public  HiloRunnable (String nombre){
        t = new Thread(this, nombre);
        t.start();
    }

    // Crear constructor con nombre y prioridad
    public  HiloRunnable (String nombre, int prioridad){
        t = new Thread(this, nombre);
        t.setPriority(prioridad);
        t.start();
    }

    // implementar método run()
    @Override
    public void run() {
        System.out.println("Soy el Hilo de tipo Runnable " + t.getName() + " y mi prioridad es " + t.getPriority());
    }
}
