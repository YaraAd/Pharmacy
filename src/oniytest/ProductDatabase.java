/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oniytest;

/**
 *
 * @author yarab
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase implements Serializable{
    public List<Product> products;

    public ProductDatabase(){
        products = loadProducts(); // Load saved products from file
        if (products == null) {
            products = new ArrayList<>(); // If no saved data, start with an empty list
        }
       
        // Preload some products into the database
//        products.add(new Product(1, "Aspirin", 50, 100, "Medicine"));
//        products.add(new Product(2, "Lipstick", 9.99, 50,"Cosmetic"));
//        products.add(new Product(3, "Band-Aid", 20, 200, "Medicine"));
//        products.add(new Product(4, "Shampoo", 100, 80, "Cosmetic"));
//        products.add(new Product(5, "Cough Syrup", 60, 30, "Medicine"));
//        products.add(new Product(6, "Paracetamol", 50, 150, "Medicine"));
//        products.add(new Product(7, "Lipstickluna", 99, 50, "Cosmetic"));
//        products.add(new Product(8, "Face Cream", 99, 30, "Cosmetic"));
    }
    
 public void addProduct(Product product) {
        products.add(product);
        saveProducts(); // Save data after adding a product
    }
 public void removeProduct(Product product) {
        products.remove(product);
        saveProducts(); // Save data after removing a product
    }

    public List<Product> getProducts() {
        return products;
    }
 private void saveProducts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.dat"))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     private List<Product> loadProducts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.dat"))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
