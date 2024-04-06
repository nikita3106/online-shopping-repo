package com.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User
{
    private String username;
    private String password;
    private List<Product> cart;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }
    
   

}


