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

    public OrderService() {
    }

    public void setData(MockData data) {
        this.data = data;
    }

    public Map<Product, Boolean> setOrder(List<Product> productList){
        //Check inventory and return confirmation;
        Map<Product, Boolean> map = new HashMap<>();
        for(Product product: productList) {
            if (data.isProductAvailable(product))
            {
                if (data.deleteProduct(product))
                    map.put(product,true);
                else
                    map.put(product, false);
            }
            else {
                map.put(product, false);
            }
        }
        return map;
    }
}
