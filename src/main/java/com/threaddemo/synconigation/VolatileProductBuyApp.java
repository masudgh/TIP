package com.threaddemo.synconigation;

import com.threaddemo.demoapp.database.MockData;
import com.threaddemo.demoapp.model.Inventory;
import com.threaddemo.demoapp.model.Product;
import com.threaddemo.demoapp.service.OrderService;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
class BuyProcessor implements Runnable  {
    private String name;
    private  volatile   OrderService order;  // These variable are shared among thread
    private  List<Product> list;   // These variable are shared among thread

    public BuyProcessor(String name,  OrderService  order, List<Product> list) {
        this.name = name;
        this.order = order;
        this.list = list;
    }

    @Override
    public void run() {
        Map<Product,Boolean> map = order.setOrder(list);

        Set<Product> keys =  map.keySet();
        for(Product prod : keys){
            boolean available = map.get(prod);
            System.out.println( "[ "+ name + " ] " + prod.getName() + " : " + available);
        }
    }
}
*/

public class VolatileProductBuyApp {

    private  static volatile  OrderService order;  // These variable are shared among thread

    static class  BuyProcessor implements Runnable  {
        private String name;
        List<Product> list;

        BuyProcessor(String name, List<Product> list) {
            this.name = name;
            this.list =list;
        }

        @Override
        public void run() {
            Map<Product,Boolean> map = order.setOrder(list);

            Set<Product> keys =  map.keySet();
            for(Product product : keys){
                boolean available = map.get(product);
                System.out.println( "[ "+ name + " ] " + product.getName() + " : " + available);
            }
        }
    }

    public static void main( String [] args){
        MockData data;
        Inventory inventory;
        inventory =new Inventory();

        Product prod1 , prod2;
        List<Product> list1, list2, list3;

        //Create data
        prod1 = new Product (1,"book1",10);
        prod2 = new Product (2,"book2",5);

        int noOfMaxItem =1;  // Two of each Item inserted into the inventory
        for(int i=0; i<noOfMaxItem; i++) {
            inventory.insertProduct(prod1);
            inventory.insertProduct(prod2);
        }

        data = new MockData(inventory);
        order = new OrderService(data);

        list1 = new ArrayList<>();
        list1.add(prod1);
        list1.add(prod2);


        list2 = new ArrayList<>();
        list2.add(prod1);
        list2.add(prod2);

        list3 = new ArrayList<>();
        list3.add(prod1);
        list3.add(prod2);


        Thread t1 = new Thread (new BuyProcessor("Thread 1", list1));
        Thread t2 = new Thread (new BuyProcessor("Thread 2", list2));
        Thread t3 = new Thread (new BuyProcessor("Thread 3", list3));

        t1.start();
        t2.start();
        t3.start();

    }
}
