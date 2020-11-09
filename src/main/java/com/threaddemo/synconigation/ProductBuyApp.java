package com.threaddemo.synconigation;

import com.threaddemo.demoapp.database.MockData;
import com.threaddemo.demoapp.model.Inventory;
import com.threaddemo.demoapp.model.Product;
import com.threaddemo.demoapp.service.BuyService;
import com.threaddemo.demoapp.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ProductBuyApp {

    private OrderService order;  // These variable are shared among thread
    private BuyService buyService;

    public ProductBuyApp() {
        this.order = new OrderService();
        this.buyService = new BuyService();
    }

    public class  BuyProcessor implements Runnable  {
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

        List<Product> user1ProductList;
        List<Product> user2ProductList;

        //Create Inventory Data
        Product prod1 = new Product (1,"book1",10);
        Product prod2 = new Product (2,"book2",5);
        Product prod3 = new Product (3,"book3",15);
        Product prod4 = new Product (4,"book4",40);

        Inventory inventory =new Inventory();
        inventory.insertProduct(prod1);
        inventory.insertProduct(prod2);
        inventory.insertProduct(prod3);
        inventory.insertProduct(prod4);

        MockData data = new MockData(inventory);

        ProductBuyApp app = new ProductBuyApp();
        app.order.setData(data);

        user1ProductList = new ArrayList<>();
        user1ProductList.add(prod1);
        user1ProductList.add(prod2); //This product is common
        user1ProductList.add(prod3);

        user2ProductList = new ArrayList<>();
        user2ProductList.add(prod2); //This product is common
        user2ProductList.add(prod4);

        app.buyService.setOrder(app.order);

      //  BuyProcessor buyProcessor = new BuyProcessor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    app.buyService.BuyProduct(user1ProductList, "#1 User buy ");
                    Thread.sleep(100);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    app.buyService.BuyProduct(user2ProductList, "#2 User buy ");
                    Thread.sleep(100);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
