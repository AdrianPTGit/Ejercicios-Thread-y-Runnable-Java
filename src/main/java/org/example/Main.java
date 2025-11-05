package org.example;

/**
 * Clase principal del programa.
 *
 * Aquí se demuestra cómo crear y ejecutar un hilo usando la clase MyThread,
 * que extiende de Thread.
 */
public class Main {

    public static void main(String[] args) {

        // Se crea una nueva instancia de MyThread.
        // En este momento el hilo está en estado "nuevo" (NEW),
        // es decir, aún no ha comenzado su ejecución.
        MyThread t1 = new MyThread();

        // Se inicia el hilo llamando a .start().
        // Esto provoca que la JVM cree un nuevo hilo de ejecución
        // y llame internamente al método run() de la clase MyThread.
        // La ejecución de run() ocurrirá de forma concurrente con el hilo principal.
        t1.start();

        /**
         * Si en lugar de start() se usara t1.run(),
         * el método run() se ejecutaría en el mismo hilo principal
         * (sin concurrencia), por lo que no habría ejecución paralela.
         */
    }
}