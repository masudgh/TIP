package com.threaddemo.synconigation.deadlock;


public class App {

    public static void main (String [] args){

       final Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    runner.firstThread();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try

        {
            t1.join();
            t1.join();
            runner.finished();
        }catch( InterruptedException e)

        {
            e.printStackTrace();
        }
    }

}
