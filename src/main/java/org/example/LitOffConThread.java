package org.example;

/**
 * Esta clase extiende Thread y representa una tarea que realiza una cuenta atrás
 * antes de mostrar un mensaje de "Lanzamiento".
 *
 * A diferencia del ejemplo con Runnable, aquí se hereda directamente de Thread,
 * por lo que cada objeto puede iniciarse con el método .start() para ejecutarse
 * en un hilo independiente.
 */
public class LitOffConThread extends Thread {

    // Valor inicial de la cuenta atrás (por defecto 10)
    private int countDown = 10;

    // Contador estático compartido por todas las instancias (no se usa activamente aquí)
    private static int taskCount = 0;

    // Identificador de cada hilo (asignado manualmente en el constructor)
    private int id = taskCount;

    // Constructor por defecto
    public LitOffConThread() {
    }

    // Constructor que permite definir la cuenta atrás inicial
    public LitOffConThread(int countDown) {
        this.countDown = countDown;
    }

    // Constructor que permite definir la cuenta atrás y el identificador del hilo
    public LitOffConThread(int countDown, int id) {
        this.countDown = countDown;
        this.id = id;
    }

    /**
     * Método que define lo que hará el hilo al ejecutarse.
     * En este caso, realiza una cuenta atrás mostrando el id y el valor actual.
     */
    @Override
    public void run() {
        while (countDown > 0) {
            System.out.println("#" + id + " (" + countDown + ")");
            countDown--;
        }
        System.out.println("Lanzamiento (" + id + ")");
    }

    public static void main(String[] args) throws InterruptedException {

        // Creación de varias instancias de LitOffConThread, cada una con su cuenta atrás y su id.
        LitOffConThread launch = new LitOffConThread(50, 0);
        LitOffConThread l1 = new LitOffConThread(40, 1);
        LitOffConThread l2 = new LitOffConThread(30, 2);
        LitOffConThread l3 = new LitOffConThread(20, 3);
        LitOffConThread l4 = new LitOffConThread(10, 4);

        // Mensaje previo a la ejecución concurrente
        System.out.println("Comienza la cuenta atrás! con Thread y .start()");

        // Inicio de los hilos (cada uno se ejecuta de forma concurrente)
        l1.start();
        l2.start();
        l3.start();
        l4.start();
        launch.start();

        /**
         * IMPORTANTE:
         * - Cuando se usa .start(), cada hilo comienza su ejecución en paralelo (según el planificador del sistema operativo).
         * - El orden de ejecución de los mensajes en consola puede variar en cada ejecución.
         */

        // Asignación de prioridades a cada hilo (1 = baja, 10 = alta)
        l1.setPriority(1);  // prioridad mínima
        int prioridad = l1.getPriority();

        l2.setPriority(2);
        int prioridad2 = l2.getPriority();

        l3.setPriority(3);
        int prioridad3 = l3.getPriority();

        l4.setPriority(4);
        int prioridad4 = l4.getPriority();

        // launch mantiene la prioridad por defecto (normalmente 5)

        /**
         * Las líneas .join() están comentadas.
         * Si se activaran, el hilo principal esperaría a que cada hilo terminara
         * antes de continuar con el siguiente. Esto elimina la concurrencia.
         *
         * Ejemplo:
         * l1.join();  // Espera a que l1 termine antes de continuar
         */

        // Mostrar las prioridades asignadas a cada hilo
        System.out.println("getPriority l1: " + prioridad);
        System.out.println("getPriority l2: " + prioridad2);
        System.out.println("getPriority l3: " + prioridad3);
        System.out.println("getPriority l4: " + prioridad4);

        /**
         * ➤ Observaciones:
         * - Como se usa .start(), todos los hilos se ejecutan simultáneamente (multihilo).
         * - El orden de los mensajes cambia en cada ejecución.
         * - Las prioridades influyen en la posibilidad de que un hilo obtenga más tiempo de CPU,
         *   pero no garantizan un orden fijo.
         * - Si se usara .run() en lugar de .start(), los hilos se ejecutarían uno tras otro
         *   en el mismo hilo principal (monohilo).
         */
    }
}