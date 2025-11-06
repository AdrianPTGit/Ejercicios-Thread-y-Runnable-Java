package Ejercicio_3;

// Clase que extiende Thread para crear hilos personalizados
public class U3S2_ThreadMethodsExample  implements Runnable{
    private String threadName;
    private ThreadGroup threadGroup;

    // Constructor que recibe un ThreadGroup y un nombre para el hilo
    U3S2_ThreadMethodsExample(ThreadGroup group, String name) {
        this.threadGroup = group;
        this.threadName = name; // Llama al constructor de Thread para asignar el grupo y nombre
    }

    @Override
    public void run() {
        // Obtiene el nombre del hilo actual
        String threadName = Thread.currentThread().getName();

        // Imprime que el hilo está dentro del método run
        System.out.println("[" + threadName + "] " + "Inside the thread");

        // Imprime la prioridad del hilo
        System.out.println("[" + threadName + "] " + "Priority: "
                + Thread.currentThread().getPriority());

        // Sugiere al scheduler ceder CPU a otro hilo
        Thread.yield();

        // Imprime el ID del hilo
        System.out.println("[" + threadName + "] " + "Id: "
                + Thread.currentThread().getId());

        // Imprime el nombre del grupo al que pertenece el hilo
        System.out.println("[" + threadName + "] " + "ThreadGroup: "
                + Thread.currentThread().getThreadGroup().getName());

        // Imprime la cantidad de hilos activos en el grupo actual
        System.out.println("[" + threadName + "] " + "ThreadGroup count: "
                + Thread.currentThread().getThreadGroup().activeCount());
    }


}