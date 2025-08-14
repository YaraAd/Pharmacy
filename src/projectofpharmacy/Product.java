/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofpharmacy;

/**
 *
 * @author yarab
 */

public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Cosmetic extends Product {
    public Cosmetic(String name, double price) {
        super(name, price);
    }
}

class Medicine extends Product {
    public Medicine(String name, double price) {
        super(name, price);
    }
}