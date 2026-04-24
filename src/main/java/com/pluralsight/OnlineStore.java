package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class OnlineStore {
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
                        case 1 -> AllProducts();
                        case 2 ->{
                            System.out.print("what product are you looking for: ");
                            String productSearch = userInput.nextLine();

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

    // Methods
    public static void AllProducts() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));
            // For the file reader
            String allPro;

            System.out.println("Display all products");
            while ((allPro = bufReader.readLine()) != null) {
                System.out.println(allPro);
            }
            bufReader.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
