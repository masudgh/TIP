package com.threaddemo.demoapp.service;

import com.threaddemo.demoapp.database.MockData;
import com.threaddemo.demoapp.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuyService {


    private  OrderService order;

    public BuyService() {
    }

    public void setOrder(OrderService order) {
        this.order = order;
    }

    public void BuyProduct(List<Product> products, String threadName){
        Map<Product,Boolean> map = order.setOrder(products);
        Set<Product> keys =  map.keySet();
        for(Product product : keys){
            boolean available = map.get(product);
            System.out.println( threadName + ": Product Name : "+ product.getName() + " isAvailable : " + available);
        }
    }
}
