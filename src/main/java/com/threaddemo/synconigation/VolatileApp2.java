package com.threaddemo.synconigation;

public class VolatileApp2 {


    public static void main (String [] args){
        VolatileApp2 app =new VolatileApp2();
        app.process();
    }

    public  long cache =0;
    public synchronized void  increament (){
        cache++;
    }

    public void process(){

        Thread t1 = new Thread( new Runnable(){

            @Override
            public void run() {

                for(int i=0; i<10000; i++){
                    increament();
                }

            }
        } );


        Thread t2 = new Thread( new Runnable(){

            @Override
            public void run() {
                for(int i=0; i<10000; i++){
                    increament();
                }

            }
        } );


        t1.start();
        t2.start();


        try{
            t1.join();
            t2.join();
        }catch(Exception e){

        }


        System.out.println(cache);

    }



}

