/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oniytest;

import java.io.Serializable;

/**
 *
 * @author yarab
 */

 public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private int quantity;
   // private String category;
    private  String category;

    public Product(int id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
       this.category = category;
    }

    

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }
}
