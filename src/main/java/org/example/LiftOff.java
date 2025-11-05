package org.example;

/**
 * Este programa define una clase llamada LiftOff que simula una cuenta atrás de lanzamiento.
 * La clase implementa Runnable, por lo que puede ejecutarse dentro de un hilo.
 *
 * ➤ Preguntas y observaciones:
 *
 *  - ¿Qué está pasando con la ejecución del programa?
 *      Cada instancia de LiftOff realiza una cuenta regresiva desde un número indicado
 *      (countDown) hasta 0, mostrando en consola su identificador y el número actual.
 *
 *  - ¿El mensaje "Comienza la cuenta atrás!" está puesto en el sitio correcto?
 *      No, porque al ejecutar .run() directamente, todo el código se ejecuta de forma secuencial.
 *      Por tanto, el mensaje se muestra **después** de completar la primera cuenta atrás,
 *      no antes ni durante la ejecución concurrente.
 *
 *  - ¿Qué ocurre al crear más instancias de LiftOff y ejecutarlas?
 *      Se ejecutan todas una detrás de otra, de forma secuencial, ya que se llama a .run()
 *      directamente en lugar de .start().
 *
 *  - ¿Hace algo diferente a una aplicación monohilo?
 *      No, porque al usar .run() se ejecutan todas las tareas en el mismo hilo principal.
 *      Si se usara `new Thread(liftOff).start()`, entonces sí habría ejecución concurrente
 *      y el orden de salida sería diferente.
 */

public class LiftOff implements Runnable {

    // Valor inicial de la cuenta atrás
    private int countDown = 10;

    // Contador estático (compartido entre instancias)
    private static int taskCount = 0;

    // Identificador único para cada tarea
    private int id = taskCount;

    // Constructor por defecto
    public LiftOff() {
    }

    // Constructor con cuenta atrás personalizada
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    // Constructor con cuenta atrás e id personalizados
    public LiftOff(int countDown, int id) {
        this.countDown = countDown;
        this.id = id;
    }

    @Override
    public void run() {
        // Bucle que imprime la cuenta atrás desde countDown hasta 1
        while (countDown > 0) {
            System.out.println("#" + id + " (" + countDown + ")");
            countDown--;
        }
        // Mensaje final cuando termina la cuenta atrás
        System.out.println("Lanzamiento (" + id + ")");
    }

    public static void main(String[] args) {
        // Se crea y ejecuta la primera instancia directamente con run()
        LiftOff launch = new LiftOff(50, 0);
        launch.run(); // Se ejecuta en el hilo principal

        // Este mensaje se muestra DESPUÉS de terminar la primera ejecución
        System.out.println("Comienza la cuenta atrás! con .run()");

        // Otras instancias también se ejecutan secuencialmente
        LiftOff l1 = new LiftOff(40, 1);
        l1.run();

        LiftOff l2 = new LiftOff(30, 2);
        l2.run();

        LiftOff l3 = new LiftOff(20, 3);
        l3.run();

        LiftOff l4 = new LiftOff(10, 4);
        l4.run();

        // ➤ Todas las ejecuciones son secuenciales y no hay paralelismo.
        // Para observar concurrencia real, se debería reemplazar cada
        // llamada a .run() por algo como:
        // new Thread(new LiftOff(50, 0)).start();
    }
}