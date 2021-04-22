package com.tests;

import com.system.DiscFile;
import com.system.Music;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReadDiscDetailsFromFileTest {
    ReadDiscDetailsFromFile readDetails = new ReadDiscDetailsFromFile();

    Music expectedMusicCD = new Music("Jazz Music","10/10/2019","Jazz","Tom Smith",10, 120);
    DiscFile expectedMusicFile = new DiscFile(expectedMusicCD, expectedMusicCD.getTitle(), expectedMusicCD.getFullDetails(), "jazz");

    // RED step: minimum code for method to fail
    @Test
    public void readDiscDetailsTest(){
        fail();
    }

    // GREEN step: Test to see whether the object's file exists or not.
    @Test
    public void checkIfFileExists(){
        String actual = readDetails.readDiscDetailsFromFile("textfiles\\jazz.txt");
        assertTrue(actual!=null);
    }

    // REFACTOR step: Test to see whether the method will read the first line from the object's file and return it.
    @Test
    public void readFirstLineTest(){
        String expected = "Title: Jazz Music";
        String actual = readDetails.readDiscDetailsFromFile("textfiles\\jazz.txt");
        assertEquals(expected,actual);
    }

    // REFACTOR step: Test to see whether the method will read all the lines from the object's file and return it.
    @Test
    public void readFullDetailsTest(){
        String expected = expectedMusicFile.getFullDetails();
        String actual = readDetails.readDiscDetailsFromFile("textfiles\\jazz.txt");
        assertEquals(expected,actual);
    }
}
