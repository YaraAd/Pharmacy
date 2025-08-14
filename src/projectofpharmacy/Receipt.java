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
import java.util.List;

public class Receipt {
    private User user;
    private List<Product> purchasedProducts;
    private double total;

    public Receipt(User user, List<Product> purchasedProducts) {
        this.user = user;
        this.purchasedProducts = purchasedProducts;
        calculateTotal();
    }

    private void calculateTotal() {
        for (Product product : purchasedProducts) {
            total += product.getPrice();
        }
        if (user.hasDiscount()) {
            total *= 0.9; // 10% discount
        }
    }

    public void printReceipt() {
        System.out.println("Receipt for " + user.getName());
        for (Product product : purchasedProducts) {
            System.out.println(product.getName() + ": $" + product.getPrice());
        }
        System.out.println("Total: $" + total);
    }
}