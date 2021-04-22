package com.system;

import java.util.Date;
import java.util.Scanner;

public class ReleaseDate {
    private int[] dateInputs = new int[3];

    public int getDay(Scanner input){
        int dayInput;
        System.out.print("Please enter day: ");
        dayInput = new NumberHandling().enterPositiveInteger(input);
        if (dayInput >= 1 && dayInput <= 31) return dayInput;
        return 0;
    }

    public int getMonth(Scanner input){
        int monthInput;
        System.out.print("Please enter month: ");
        monthInput = new NumberHandling().enterPositiveInteger(input);
        if (monthInput >=1 && monthInput <= 12) return monthInput;
        return 0;
    }

    public int getYear(Scanner input){
        int yearInput;
        System.out.print("Please enter year: ");
        yearInput = new NumberHandling().enterPositiveInteger(input);
        if (yearInput>0) return yearInput;
        return 0;
    }

    public String getValidDate(Scanner input){
        for(int i = 0; i < 3; i++){
            boolean validInput=false;
            while(!validInput) {
                switch (i) {
                    case 0:
                        dateInputs[i] = getDay(input);
                        break;
                    case 1:
                        dateInputs[i] = getMonth(input);
                        break;
                    case 2:
                        dateInputs[i] = getYear(input);
                        break;
                }
                if(dateInputs[i]==0) System.out.println("Invalid input. Please try again.");
                else validInput=true;
            }
        }
        return Integer.toString(dateInputs[0]) + "/" + Integer.toString(dateInputs[1]) + "/" + Integer.toString(dateInputs[2]);
    }


}
