package com.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //addTestFiles();
        Entry system = new Entry();
        system.welcomeUser();
        }

    public static void addTestFiles(){
         Info test = new Info();

         Music newMusic1 = new Music("Bob MArley Music","10/12/1975","R'n'B/Soul","Bob Marley",10,110);
         DiscFile<Music> newFile1 = new DiscFile<Music>(newMusic1, newMusic1.getTitle(), newMusic1.getFullDetails(), "bobmarley");

         Music newMusic2 = new Music("Linkin PArk Music","10/12/2001","Rock","Linkin Park",10,110);
         DiscFile<Music> newFile2 = new DiscFile<Music>(newMusic2, newMusic2.getTitle(), newMusic2.getFullDetails(), "linkinpark");

         Music newMusic3 = new Music("Nevermind","11/11/1991","Rock","Nirvana",9,100);
         DiscFile<Music> newFile3 = new DiscFile<Music>(newMusic3, newMusic3.getTitle(), newMusic3.getFullDetails(), "nirvana");

         Game newGame1 = new Game("Skyrim", "11/11/2011", "Role-Playing", "18","Xbox One");
         DiscFile<Game> newFile4 = new DiscFile<Game>(newGame1, newGame1.getTitle(), newGame1.getFullDetails(), "skyrim");

         Game newGame2 = new Game("Grand Theft Auto 5", "10/09/2013", "Action", "18","Xbox One");
         DiscFile<Game> newFile5 = new DiscFile<Game>(newGame2, newGame2.getTitle(), newGame2.getFullDetails(), "gta5");

         test.allDiscFiles.add(newFile1);
         test.allDiscFiles.add(newFile2);
         test.allDiscFiles.add(newFile3);
         test.allDiscFiles.add(newFile4);
         test.allDiscFiles.add(newFile5);
    }

}
