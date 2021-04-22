package com.system;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Info {
    public static Vector<DiscFile> allDiscFiles = new Vector<DiscFile>();

    public static void launchMenu(Scanner input) {
        boolean keepUsing = true;
        while (keepUsing) {
            System.out.println("\nDisc Information Management");
            System.out.println("-----------------------------\n");
            System.out.println("1. Add New Music CD.");
            System.out.println("2. Add New Game Disc");
            System.out.println("3. Search Disc.");
            System.out.println("4. Remove Disc.");
            System.out.println("5. Rename Text File.");
            System.out.println("6. Display Details in Reverse Order.");
            System.out.print("\nEnter your choice: ");

            boolean DiscIsMusic;
            boolean validInput;

            do {
                validInput = true;
                String userInput = input.nextLine();
                switch (userInput) {
                    case "1":
                        addNewDisc(input, DiscIsMusic = true);
                        break;
                    case "2":
                        addNewDisc(input, DiscIsMusic = false);
                        break;
                    case "3":
                        printSearchedDiscDetails(input);
                        break;
                    case "4":
                        removeDisc(input);
                        break;
                    case "5":
                        renameFileFromVector(input);
                        break;
                    case "6":
                        if(allDiscFiles.size()==0) System.out.println("\nThere are no discs currently in your list. Please add a disc to display their details.\n");
                        else displayDetailsInReverseOrder(allDiscFiles.size());
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        validInput=false;
                }
            }while(!validInput);
        }

    }

    public static void addNewDisc(Scanner input, boolean DiscIsMusic) {
        System.out.println("\nAdd New Disc");
        System.out.println("------------------");

        System.out.print("\nEnter CD title: ");
        String titleInput = input.nextLine();

        String genreInput = new Genre().selectGenre(input, DiscIsMusic);

        System.out.println("\nEnter the release date. ");
        String releaseDateInput = new ReleaseDate().getValidDate(input);

        input.nextLine();                                                         // consume newline leftover

        String filename = "disc"+Integer.toString(allDiscFiles.size() + 1);

        if (DiscIsMusic) {                                                         // goes to this path if user wants to add a music CD and adds details only exclusive to music CDs
            System.out.print("\nEnter name of artist: ");
            String artistInput = input.nextLine();

            System.out.print("\nEnter number of songs: ");
            int numberOfSongsInput = new NumberHandling().enterPositiveInteger(input);

            System.out.print("\nEnter duration (in minutes): ");
            int durationInput = new NumberHandling().enterPositiveInteger(input);

            Music newMusicCD = new Music(titleInput, releaseDateInput, genreInput, artistInput, numberOfSongsInput, durationInput);
            DiscFile<Music> newDiscFile = new DiscFile<Music>(newMusicCD, newMusicCD.getTitle(), newMusicCD.getFullDetails(), filename);

            input.nextLine();                                                       // consume newline leftover

            allDiscFiles.add(newDiscFile);

            System.out.println("\nMusic CD details successfully added.");

        } else {                                                                    // goes to this path if user wants to add a game disc and adds details only exclusive to game discs
            String ratingInput = new Rating().selectPEGIRating(input);

            input.nextLine();                                                       // consume newline leftover

            System.out.print("\nEnter platform: ");
            String platformInput = input.nextLine();

            Game newGameDisc = new Game(titleInput, releaseDateInput, genreInput, ratingInput, platformInput);
            DiscFile<Game> newDiscFile = new DiscFile<Game>(newGameDisc, newGameDisc.getTitle(), newGameDisc.getFullDetails(), filename);

            allDiscFiles.add(newDiscFile);

            System.out.println("\nGame disc details successfully added.\n");
        }
    }

    private static DiscFile searchDiscFileByTitle(String title) {
        DiscFile desiredFile = null;
        for (DiscFile discFile : allDiscFiles) if (discFile.getDiscTitle().toUpperCase().equals(title.toUpperCase())) desiredFile = discFile;
        return desiredFile;
    }


    private static String checkIfTitleExists(Scanner input){
        boolean validDisc=false;
        String title="";
        while(!validDisc) {
            System.out.print("Enter title: ");
            String titleInput = input.nextLine();

            DiscFile discFile = searchDiscFileByTitle(titleInput);

            if (discFile != null) {
                validDisc = true;
                title = discFile.getDiscTitle();
            } else System.out.println("Disc is not found. Please try again.");
        }
        return title;
    }

    private static String EnterYOrN(Scanner input, String message){
        String userInput="";
        boolean validInput;
        do{
            validInput=true;
            System.out.print(message);
            userInput=input.nextLine().toUpperCase();
            if(!userInput.equals("Y") && !userInput.equals("N")){       // if the user does not enter 'Y' or 'N' the loop will prompt to user to enter again until they enter either one
                validInput=false;
                System.out.println("Invalid input. Please try again");
            }
        }while(!validInput);
        return userInput;
    }

    private static void printSearchedDiscDetails(Scanner input){
        boolean searchAnotherDisc = true;
        while(searchAnotherDisc) {
            System.out.println("\nSearch Disc");
            System.out.println("------------");

            String title = checkIfTitleExists(input);
            System.out.println("\n"+searchDiscFileByTitle(title).readDiscDetailsFromFile()+"\n");

            String userInput = EnterYOrN(input, "Would you like to search another disc (Y/N)? ");
            if (userInput.equals("N")) searchAnotherDisc = false;
        }

    }

    private static void removeDisc(Scanner input) {
        boolean deleteAnotherDisc = true;
        while (deleteAnotherDisc) {
            System.out.println("\nRemove Disc");
            System.out.println("-------------");

            String title = checkIfTitleExists(input);
            DiscFile fileToDelete = searchDiscFileByTitle(title);

            String deleteThis = EnterYOrN(input, "Are you sure you would like to delete the following disc (Y/N): \n\n"+fileToDelete.readDiscDetailsFromFile()+"\n\nEnter your choice: ");
            
            if (deleteThis.equals("Y")) {
                fileToDelete.deleteFile();
                allDiscFiles.remove(fileToDelete);
            }
            String userInput = EnterYOrN(input, "Would you like to delete another disc (Y/N)? ");
            if (userInput.equals("N")) deleteAnotherDisc = false;
        }
    }

    private static void renameFileFromVector(Scanner input){
        boolean renameAnotherFile = true;
        while(renameAnotherFile) {
           System.out.println("\nRename file");
           System.out.println("------------");

           String title = checkIfTitleExists(input);
           searchDiscFileByTitle(title).renameFile(input);

           String userInput = EnterYOrN(input, "Would you like to rename another file (Y/N)? ");
           if (userInput.equals("N")) renameAnotherFile = false;
        }
    }

    private static int displayDetailsInReverseOrder(int n){
        if(n==0) return 0;
        else {
            System.out.print("\n"+allDiscFiles.get(n - 1).readDiscDetailsFromFile()+"\n");
            return displayDetailsInReverseOrder(n - 1);
        }
    }
}