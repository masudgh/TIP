package com.threaddemo.synconigation;

import java.util.Scanner;

class Processor extends Thread {
    private boolean running =true;


    public void run() {

        while(running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            }catch(Exception e){

            }
        }
    }

    public void shutdown(){
        running = false;
    }

}

public class VolatileApp {

    public static void main( String [] args){
        Processor p1 = new Processor();
        p1.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        p1.shutdown();

    }
}
