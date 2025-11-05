package org.example;

public class LitOffConThread extends Thread{
    private int countDown = 10;
    private static int taskCount = 0;
    private int id = taskCount;

    public LitOffConThread() {

    }

    public LitOffConThread(int countDown) {
        this.countDown = countDown;
    }

    public LitOffConThread(int countDown, int id) {
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

    public static void main(String[] args) throws InterruptedException {
        LitOffConThread launch = new LitOffConThread(50, 0); //10




//        System.out.println("Comienza la cuenta atrás! con .run()");
//
        LitOffConThread l1 = new LitOffConThread(40, 1);//25

        LitOffConThread l2 = new LitOffConThread(30, 2);//30

        LitOffConThread l3 = new LitOffConThread(20, 3);//25

        LitOffConThread l4 = new LitOffConThread(10, 4);//50


        System.out.println("Comienza la cuenta atrás! con Thread y .start()");


        l1.start();

        l1.setPriority(1);
        int prioridad = l1.getPriority();
        //l1.join();

        l2.start();
        //l2.join(); // espera a que termine t0

        l2.setPriority(2);
        int prioridad2 = l2.getPriority();
        l3.start();
        //l3.join(); // espera a que termine t1

        l3.setPriority(3);
        int prioridad3 = l3.getPriority();

        l4.start();
        //l4.join(); // espera a que termine t2

        l4.setPriority(4);
        int prioridad4 = l4.getPriority();

        launch.start();
        //launch.join(); // espera a que termine t3

        System.out.println("getPriority l1:"+prioridad);
        System.out.println("getPriority l2:"+prioridad2);
        System.out.println("getPriority l3:"+prioridad3);
        System.out.println("getPriority l4:"+prioridad4);
    }
}
