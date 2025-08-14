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

public class User {
    private String name;
    private boolean hasDiscount;

    public User(String name, boolean hasDiscount) {
        this.name = name;
        this.hasDiscount = hasDiscount;
    }

    public String getName() {
        return name;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }
}