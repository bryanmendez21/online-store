package com.pluralsight;

import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("----------Welcome to The Store----------");
        System.out.println("(1) Display All Products");
        System.out.println("(2) Display Cart");
        System.out.println("(0) Exit");
        System.out.print("Pick from the options above by entering a numerical value: ");
        int userOption = userInput.nextInt();
        userInput.nextLine();

    }

}
