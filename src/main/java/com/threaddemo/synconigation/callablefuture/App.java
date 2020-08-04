package com.threaddemo.synconigation.callablefuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {


    public static void main (String [] args){

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future =  executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception{

                Random random = new Random();
                int duration = random.nextInt(100);

                if(duration >80){
                    throw new IOException( " sleeping too long");
                }

                System.out.println("Starting ....");

                try{
                    Thread.sleep(duration);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Finished ....");
                return duration;
            }

        });

        executor.shutdown();

        try {
            System.out.println("Result is :" + future.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e1){

        }
    }
}
