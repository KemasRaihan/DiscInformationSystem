package com.system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberHandling {

    public static int enterPositiveInteger(Scanner input) {
        int positiveInteger = 0; // default initialization
        boolean error = true;
        while (error) {
            // First test: check if user has entered an integer
            try {
                positiveInteger = input.nextInt();
                error = false;
                // Second test: check if user has entered a non-zero positive integer
                if (positiveInteger <= 0) {
                    System.out.print("Please enter a valid number: ");
                    error = true;
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid number: ");
                input.next();
            }
        }
        return positiveInteger;
    }
}
