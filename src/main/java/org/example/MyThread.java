package org.example;

/**
 * Esta clase define un hilo simple llamado MyThread.
 *
 * Extiende directamente de la clase Thread, lo que significa
 * que puede ejecutarse de forma concurrente usando el método .start().
 */
public class MyThread extends Thread {

    /**
     * Método run():
     *
     * - Este método contiene el código que se ejecutará cuando el hilo comience.
     * - Se llama automáticamente cuando invocamos .start() sobre una instancia de esta clase.
     * - Si se llama directamente a .run(), no se crea un nuevo hilo, sino que se ejecuta
     *   en el mismo hilo principal.
     */
    @Override
    public void run() {
        // Mensaje simple para indicar que el hilo está en ejecución
        System.out.println("MyThread running");
    }

}