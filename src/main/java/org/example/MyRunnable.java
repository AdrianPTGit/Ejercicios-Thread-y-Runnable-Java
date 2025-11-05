package org.example;

/**
 * Esta clase implementa la interfaz Runnable.
 *
 * Runnable es una forma alternativa de crear hilos en Java
 * sin extender directamente la clase Thread.
 *
 * Ventaja: Permite que la clase herede de otra (ya que Java no admite herencia múltiple),
 * y separa claramente la tarea que el hilo debe ejecutar (run) del propio hilo (Thread).
 */
public class MyRunnable implements Runnable {

    /**
     * Método run():
     *
     * - Este método contiene el código que se ejecutará cuando el hilo inicie.
     * - Al igual que con la clase Thread, se ejecuta automáticamente cuando
     *   el objeto Runnable se pasa a un Thread y se llama a .start().
     */
    @Override
    public void run() {
        // Mensaje que se muestra cuando el hilo comienza su ejecución
        System.out.println("Runnable en ejecución");
    }
}