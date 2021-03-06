package com.threaddemo.synconigation.consumerproducer;

public class App2 {



    public static void main (String [] args){

        final Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    processor.producer();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable( ) {
            @Override
            public void run() {

                try{
                    processor.consumer();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
