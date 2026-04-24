package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);
        BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));

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

                    System.out.println(bufReader);
                    System.out.println("All Products");
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

}
