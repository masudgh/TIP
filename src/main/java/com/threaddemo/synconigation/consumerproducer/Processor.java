package com.threaddemo.synconigation.consumerproducer;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Processor {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);



    public void producer()  throws InterruptedException{
        Random random = new Random();
        synchronized(this){
            queue.put(100);

            System.out.println(" Producer thread is running ...");
            System.out.println("Initial value.."+ 100);
            wait();

            System.out.println("Resume Producer ..");
            Integer val = queue.poll();
            System.out.println("Recalculated value.."+ val);

        }


    }

    public void consumer() throws InterruptedException{

        Scanner  scanner = new Scanner(System.in);

        Thread.sleep(100);

        synchronized(this){
            Integer cal = queue.poll();
            cal = cal-9+32;
            queue.put(cal);
            System.out.println(" waiting for return key");
            scanner.nextLine();

            System.out.println("Return Key");
            notify();
        }

    }
}
