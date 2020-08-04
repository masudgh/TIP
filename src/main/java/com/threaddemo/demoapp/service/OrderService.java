package com.threaddemo.demoapp.service;

import com.threaddemo.demoapp.database.MockData;
import com.threaddemo.demoapp.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderService {
    private volatile MockData  data;

    public OrderService(MockData data) {
        this.data = data;
    }

    public Map<Product, Boolean> setOrder(List<Product> plist){
        //Check inventory and return confirmation;
        Map<Product, Boolean> map = new HashMap<>();
        for(Product prod: plist) {
            if (data.isProductAvailable(prod))
            {
                if (data.deleteProduct(prod))
                    map.put(prod,true);
                else
                    map.put(prod, false);
            }
            else {
                map.put(prod, false);
            }
        }
        return map;
    }
}
