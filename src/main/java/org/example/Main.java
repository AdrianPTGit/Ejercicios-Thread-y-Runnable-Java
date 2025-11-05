package org.example;


public class Main {
    public static void main(String[] args) {
        Runnable myRunnable =
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Hola mundo");
                    }
                };
    }
}