package com.system;

import java.util.Scanner;

public class Entry {
    Scanner input = new Scanner(System.in);
    static Info info = new Info();

    public void welcomeUser(){
        System.out.println("\nWelcome to Disc Information Management. What do you want to do?\n");
        System.out.println("1. Add New Music CD.");
        System.out.println("2. Add New Game Disc.");
        System.out.print("\nEnter your choice: ");
        boolean validInput = false;
        boolean DiscIsMusic;
        while (!validInput) {
            String userInput = input.nextLine();
            switch (userInput) {
                case "1":
                    info.addNewDisc(input, DiscIsMusic=true);
                    validInput = true;
                    break;
                case "2":
                    info.addNewDisc(input, DiscIsMusic=false);
                    validInput = true;
                    break;
                default: System.out.print("Invalid input. Please try again: ");
            }
        }
        info.launchMenu(input);
    }
}