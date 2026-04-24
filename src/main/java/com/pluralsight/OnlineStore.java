package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class OnlineStore {
    static HashMap<String, Product> cart = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);

        // For the do while loop
        boolean running = true;
        String goBack;

        do{
            System.out.println("----------Welcome to The Store----------");
            System.out.println("(1) Display All Products");
            System.out.println("(2) Display Cart");
            System.out.println("(0) Exit");
            System.out.print("Pick from the options above by entering a numerical value: ");
            int userOption = userInput.nextInt();
            userInput.nextLine();

            switch (userOption){
                case 1 -> {
                    System.out.println("----- Product Display-----");
                    System.out.println("(1) See all available products");
                    System.out.println("(2) looking for specific product");
                    System.out.println("(3) Go back to main menu");
                    System.out.print("Pick using numerical values: ");
                    int userOptionDisplay = userInput.nextInt();
                    userInput.nextLine();

                    switch (userOptionDisplay){
                        case 1 ->{
                            Product.AllProducts();
                            System.out.print("Add Product to cart type SKU or type back to return to main menu: ");
                            String addBySku = userInput.nextLine();
                            if(addBySku.equalsIgnoreCase("back")){
                                continue;
                            }

                            break;
                        }
                        case 2 ->{
                            HashMap<String, Product> products = productSearched();
                            System.out.println("---Category names---");
                            System.out.println("Audio Video\nComputers\nGames\nElectronics");
                            System.out.print("what product or category are you looking for: ");

                            String productSearch = userInput.nextLine();
                            for(Product p : products.values()) // loops through products
                                if (p.getProductName().equalsIgnoreCase(productSearch) || p.getDepartment().equalsIgnoreCase(productSearch)){
                                    System.out.println(p.getSku() + " | " + p.getProductName());

                                    System.out.print("Add Product to cart type SKU:");
                                    String addBySku = userInput.nextLine();
                                    if (products.containsValue(addBySku)){
                                        Product selected = products.get(addBySku);
                                        cart.put(addBySku,selected);
                                    }
                                    else{
                                        System.out.println("Product Not Found");
                                    }

                                }

                            break;

                        }
                        case 3 -> {
                            continue;
                        }
                        default ->{
                            System.out.println("Invalid Option");
                        }
                    }

                    break;
                }
                case 2 ->{
                    System.out.println("Cart");
                    break;
                }
                case 0 ->{
                    running = false;
                    continue;
                }
                default -> {
                    System.out.println("Invalid Choice");
                }
            }


            System.out.print("Would you want to go back (yes/no): ");
            goBack = userInput.nextLine();

            if (goBack.equalsIgnoreCase("no")){
                running = false;
            }

        }
        while (running);

        System.out.println("Good Bye");
        userInput.close();

    }

    // Method
    public static HashMap<String, Product> productSearched (){
        HashMap<String, Product> products = new HashMap<>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));

            String itemsInProduct; // For the file reader
            bufReader.readLine(); // skips first line
            while ((itemsInProduct = bufReader.readLine()) != null) {
                String [] splitProducts = itemsInProduct.split(Pattern.quote("|"));

                // parse items
                String sku = splitProducts[0];
                String productName = splitProducts[1];
                double price = Double.parseDouble(splitProducts[2]);
                String department = splitProducts[3];

                Product product = new Product(sku, productName, price,department);
                products.put(sku,product);
            }

            bufReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }


}
