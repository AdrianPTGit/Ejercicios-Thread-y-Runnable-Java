package Ejercicio_3;

public class MainEj3 {
    public static void main(String[] args) {
        // main thread
        Thread.currentThread().setName("Main");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        ThreadGroup even = new ThreadGroup("Even threads");
        ThreadGroup odd = new ThreadGroup("Odd threads");
        Thread lastThread = new Thread();
        // Thread lastThread = null; // dentro del bucle no se puede utilizar join() fuera del bucle


        for (int i = 0; i < 10; i++) {
            U3S2_ThreadMethodsExample task = new U3S2_ThreadMethodsExample(
                    (i % 2 == 0) ? even : odd,
                    "Thread" + i
            );
/**
 * 1. Qué constructor se está usando
 * * Mira los tipos de parámetros:
 *
 * (i % 2 == 0) ? even : odd → es un ThreadGroup
 * * task → es un Runnable (U3S2_ThreadMethodsExample extiende Thread, pero Java permite pasarlo como Runnable)
 * * "Thread" + i → es un String, el nombre del hilo
 * * Entonces coincide exactamente con este constructor de Thread:
 * Thread(ThreadGroup group, Runnable target, String name)
 */
            lastThread = new Thread((i % 2 == 0) ? even : odd, // parametro: ThreadGroup
                    task,  /*
                    1. task es un objeto de tipo U3S2_ThreadMethodsExample.
                    2. Tu clase implementa Runnable, así que Java lo permite como parámetro donde se espera un Runnable.
                          -  Constructor usado: Thread(ThreadGroup group, Runnable target, String name)
💡                   Importante: Aunque tu clase no extienda Thread, se ejecuta en un hilo porque se pasa como
                     Runnable a un objeto Thread.

                     3. Qué ocurre al ejecutar lastThread.start()
                            1. Se crea un hilo lastThread asociado al grupo (i % 2 == 0) ? even : odd.
                            2. lastThread tiene nombre "Thread" + i.
                            3. Cuando haces lastThread.start(), internamente Java llama a: task.run();
                                 Es decir, el método run() de tu clase U3S2_ThreadMethodsExample se ejecuta en el hilo
                                 lastThread, no en task directamente.
                    */

                    "Thread" + i //String con el nombre del hilo

            );
            lastThread.setPriority(i + 1);
            lastThread.start();
        }

        try {
            /**
             * Esto permite que el hilo principal (main) espere a que el último hilo creado termine antes de continuar.
             * Evita que el main termine y muestre "Main thread ending" antes de que todos los hilos hayan terminado.
             */
            if (lastThread != null) {
                lastThread.join(); // Espera a que termine el último hilo
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.err.println("The main thread was interrupted while waiting for "
                    + lastThread.toString() + " to finish");
        }

        System.out.println("Main thread ending");
    }
}

//4. Diferencia entre Thread y Runnable
//----------------------------------------------------------------------------------------------------------------------
//Caso	                        Qué se pasa	                                    Qué se ejecuta
//Extender Thread	            new MiHilo()	                                miHilo.start() llama a run()
//Implementar Runnable	        new Thread(miRunnable)	                        thread.start() llama a miRunnable.run()

//En el código, task es Runnable, y lastThread es Thread que ejecuta a task.