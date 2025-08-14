/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofpharmacy;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author yarab
 */



public class Inventory {
    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public boolean isAvailable(Product product, int quantity) {
        return products.getOrDefault(product, 0) >= quantity;
    }

    public void reduceProduct(Product product, int quantity) {
        if (isAvailable(product, quantity)) {
            products.put(product, products.get(product) - quantity);
        }
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}