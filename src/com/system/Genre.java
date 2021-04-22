package com.system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Genre {
    final private static String[] allGameGenres = new String[]{"Action", "Adventure", "Fighting", "Puzzle", "Racing", "Role-Playing", "Shooter", "Sports", "Strategy"};
    final private static String[] allMusicGenres = new String[]{"Classical", "Hip-hop", "Jazz", "Pop", "R'n'B/Soul", "Rock"};

    public String selectGenre(Scanner input, boolean DiscIsMusic) {
        String[] allGenres;
        boolean error;
        int numberSelected;
        String genreChoice = "";

        if (DiscIsMusic)  allGenres = allMusicGenres;                // chooses genres from either game or music depending what type of disc the user wants to add
        else              allGenres = allGameGenres;

        do {
            error = false;
            System.out.println("\nPlease select a genre from the following (please choose the corresponding number):\n");
            for (int i = 0; i < allGenres.length; i++)  System.out.println(i + 1 + "." + " " + allGenres[i]);             // print list of genres for either music or game
            System.out.print("\nEnter your choice: ");
            try {
                numberSelected = input.nextInt();
                genreChoice = allGenres[--numberSelected];                                                                // selects genre from list
            } catch (InputMismatchException e) {                                                                          // if user does not input an integer
                error = true;
                System.out.println("Invalid input. Please enter a number. ");
            } catch (IndexOutOfBoundsException e) {                                                                       // if user enters a number that isn't from the list
                error = true;
                System.out.println("Invalid input. Please select a valid number. ");
            }
        } while (error);
        return genreChoice;
    }
}
