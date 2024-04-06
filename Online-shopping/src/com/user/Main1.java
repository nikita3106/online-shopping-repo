package com.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main1
{
    private static Map<String, User> users = new HashMap<>();
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) 
    {
    	Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. User view Product item as Sorted Order");
            System.out.println("4. Buy Product");
            System.out.println("5. View Cart");
            System.out.println("6. Purchase the item");
           // System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    buyProduct(scanner);
                    break;
                case 5:
                    viewCart(null);
                    break;
                case 6:
                    purchaseItems(null);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


	 static void registerUser(Scanner scanner) 
	{
		System.out.println("User Login");

        System.out.print("Enter username: ");
        String username = scanner.next();

        if (!users.containsKey(username))
        {
            System.out.println("User not found. Please login first.");
   
        }

        User user = users.get(username);

        System.out.print("Enter password: ");
        String password = scanner.next();

        if (!user.getPassword().equals(password)) 
        {
            System.out.println("Incorrect password. Please try again.");
           
        }

        System.out.println("Login successful!");
	}
	 static void loginUser(Scanner scanner)
	{
		// TODO Auto-generated method stub
		System.out.println("User Registration");

        System.out.print("Enter username: ");
        String username = scanner.next();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose another one.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.next();

        User newUser = new User(username, password);
        users.put(username, newUser);

        System.out.println("User registered successfully!");	
	}
	 static void viewProducts()
	{
		// TODO Auto-generated method stub
		System.out.println("Viewing Products");

        Collections.sort(products, Comparator.comparing(Product::getName));

        System.out.println("Products:");

        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
		
	}
	 static void buyProduct(Scanner scanner) 
	{
		viewProducts(); 

        System.out.print("Enter the name of the product you want to buy: ");
        String productName = scanner.next();

     
        Product productToBuy = null;
        for (Product product : products) 
        {
            if (product.getName().equalsIgnoreCase(productName)) 
            {
                productToBuy = product;
                break;
            }
        }
	}
	
	 static void viewCart(User user) 
	{
		System.out.println("Viewing Cart");

        List<Product> cart = user.getCart();

        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Cart Contents:");

        for (Product product : cart) 
        {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
		
	}

	 static void purchaseItems(User user)
	{
		List<Product> cart = user.getCart();

        if (cart.isEmpty()) 
        {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Purchasing Items:");

        double totalPrice = 0;

        for (Product product : cart) 
        {
            System.out.println(product.getName() + " - " + product.getPrice());
            totalPrice += product.getPrice();
        }
        
        System.out.println("Total Price: $" + totalPrice);

        cart.clear();
        System.out.println("Purchase successful. Your cart is now empty.");
    }
		
}

