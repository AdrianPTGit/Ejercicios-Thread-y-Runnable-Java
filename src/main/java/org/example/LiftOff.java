package org.example;

/**
 * ¿Qué está pasando con la ejecución del programa?
 *
 *  - Tras ejecutarlo, ¿el mensaje "Comienza la cuenta atrás!" está puesto en el sitio correcto?
 *      No aparece despues de la ejecucion del hilo con id = 0
 *
 *  - intenta crear más instancias del la clase LiftOff y haz que se ejecuten todas (dentro del main)
 *
 *  - Si observas la salida de aplicación, ¿está haciendo algo diferente a una aplicación monohilo? ¿Qué puedes extraer de la
 *    salida del programa?
 *
 *      con start() y Thread si cambia el orden de ejecucion y final.
 *      con run() todo se ejecuta en el orden de las instancias.
 */
public class LiftOff implements  Runnable{

    private int countDown = 10;
    private static int taskCount = 0;
    private int id = taskCount;

    public LiftOff() {

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff(int countDown, int id) {
        this.countDown = countDown;
        this.id=id;
    }

    @Override
    public void run() {
        while (countDown > 0) {
            System.out.println("#" + id + " (" + countDown + ")" );
            countDown--;
        }
        System.out.println("Lanzamiento (" + id + ")");
    }

    public static void main(String[] args) {
        LiftOff launch = new LiftOff(50, 0); //10
        launch.run();

        System.out.println("Comienza la cuenta atrás! con .run()");

        LiftOff l1 = new LiftOff(40, 1);//25
        l1.run();
        LiftOff l2 = new LiftOff(30, 2);//30
        l2.run();
        LiftOff l3 = new LiftOff(20, 3);//25
        l3.run();
        LiftOff l4 = new LiftOff(10, 4);//50
        l4.run();


    }
}
