package com.threaddemo.synconigation.consumerproducer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    private static BlockingQueue <Integer> queue = new ArrayBlockingQueue<>(10);


    public static void producer () throws InterruptedException{
        Random random = new Random();
        while(true){

            queue.put(random.nextInt(100));
        }
    }

    public static void consumer () throws InterruptedException{
        Random random = new Random();

        while(true){
            Thread.sleep(100);
         //   if(random.nextInt() ==0){
                Integer val = queue.take();
                System.out.println(" Take value: "+ val + " Queue size: "+ queue.size());
        //    }
        }

    }


    public static void main (String [] args){



        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    producer();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    consumer();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
