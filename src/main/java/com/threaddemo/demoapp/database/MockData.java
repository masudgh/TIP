package com.threaddemo.demoapp.database;

import com.threaddemo.demoapp.model.Inventory;
import com.threaddemo.demoapp.model.Product;

public class MockData {
    Inventory inventory ;

    public MockData(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isProductAvailable(Product prod){
        int count = inventory.getProductCount(prod);
        if (count >0 ) return true;
        return false;
    }

    public void addProduct(Product prod){
        inventory.insertProduct(prod);
    }

    public boolean deleteProduct(Product prod){
        return inventory.deleteProduct(prod);
    }

    public int  getProductCount(Product prod){
        return inventory.getProductCount(prod);
    }

}
