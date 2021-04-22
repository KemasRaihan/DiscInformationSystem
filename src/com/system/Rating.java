package com.system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rating {
    final private static String[] allPEGIRatings = new String[]{"3", "7", "12", "15", "18"};

    public static String selectPEGIRating(Scanner input) {
        boolean error;
        int numberSelected;
        String ratingChoice = "";
        do {
            error = false;
            System.out.println("\nPlease select a rating from the following (choose their corresponding number):\n");
            for (int i = 0; i < allPEGIRatings.length; i++)  System.out.println(i + 1 + "." + " " + allPEGIRatings[i]);   // print list of PEGI ratings
            System.out.print("\nEnter your choice: ");
            try {
                numberSelected = input.nextInt();
                ratingChoice = allPEGIRatings[--numberSelected];
            } catch (InputMismatchException e) {                                                                          // if user does not enter an integer
                System.out.println("Invalid input. Please select a number.");
                error = true;
            } catch (IndexOutOfBoundsException e) {                                                                       // if user does not enter a number from the list
                System.out.println("Invalid input. Please select a valid number.");
                error = true;
            }
        } while (error);
        return ratingChoice;
    }
}
