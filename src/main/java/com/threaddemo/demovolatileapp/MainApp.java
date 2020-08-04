package com.threaddemo.demovolatileapp;


import java.util.concurrent.atomic.AtomicInteger;




public class MainApp {




    public static  int cache = 0;
    private static volatile AtomicInteger count = new AtomicInteger(0);


    static class  BuyProcessor implements Runnable  {
        private String name;



        BuyProcessor(String name ) {
            this.name = name;
        }

        @Override
        public void run() {

     /*   try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
             for( int j=0; j<1000; j++) {
                 //int i = count.incrementAndGet();
                // System.out.println(" Thread " + name + " : " + " count " + i + " Time  " + LocalDateTime.now());
                  cache++;
                //  System.out.println(" Thread "+ name + " : " + " cache "+ cache + " Time  "  + LocalDateTime.now());
             }


        }
    }


    public static void main( String [] args){


        MainApp app =new MainApp();

        Thread t1 = new Thread (new BuyProcessor("Thread 1"));
        Thread t2 = new Thread (new BuyProcessor("Thread 2"));
        Thread t3 = new Thread (new BuyProcessor("Thread 3"));

        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        }catch(Exception e){
            System.out.println( e.getMessage());
        }

        System.out.println(cache);
    }
}
