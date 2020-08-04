package com.threaddemo.demoapp.model;

import java.util.*;

public class Inventory {
    private volatile Map<Product, Integer> productAvailable = new HashMap<>();

    public void insertProduct (Product prod) {
        productAvailable.put(prod,productAvailable.getOrDefault(prod, 0) + 1);
    }

    public boolean deleteProduct (Product prod) {

        Set<Product> products  = productAvailable.keySet();
        for(Product product: products){
            if(product.getId() == prod.getId()){
                int count =  productAvailable.get(prod);
                productAvailable.remove(prod);
                if(count ==0) {
                    productAvailable.put(prod, 0);
                    return false;
                }
                else  if(count > 0) {
                    productAvailable.put(prod, count - 1);
                    return true;
                }
            }

        }
        return false;
        //productAvailable.put(prod,productAvailable.getOrDefault(prod, 0) - 1);
    }

    public int getProductCount (Product product) {
        //int prodId = prod.getId();
       // Set<Product> products  = productAvailable.keySet();

        int nofOfProduce = productAvailable.getOrDefault(product, 0);

        return nofOfProduce;

    }

    public Set<Product> getProductList (Product prod) {
        Set<Product> products =new HashSet<>();
        products =productAvailable.keySet();
        return products;
    }
}
