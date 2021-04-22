package com.tests;

import com.system.DiscFile;
import com.system.Music;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchDiscByTitleTest {
    SearchDiscByTitle searchDisc = new SearchDiscByTitle();
    Music expectedMusicCD = new Music("Jazz Music","10/10/2019","Jazz","Tom Smith",10, 120);
    DiscFile<Music> expectedMusicFile = new DiscFile<Music>(expectedMusicCD, expectedMusicCD.getTitle(), expectedMusicCD.getFullDetails(), "jazz");


    // RED step: minimum code to fail.
    @Test
    public void searchDiscTest(){
        fail();
    }

    // GREEN step: Test to see whether the method will return the expected disc object from the vector 'allDiscFiles' i.e. the minimum code for method to pass.
    @Test
    public void returnDiscFromVectorTest(){
        searchDisc.allDiscFiles.add(expectedMusicFile);
        DiscFile expected = expectedMusicFile;
        DiscFile actual = searchDisc.searchDiscByTitle("Jazz Music");
        assertEquals(expected, actual);
    }

    // REFACTOR step: Test to see if the parameter title matches with the disc object's title in the vector 'allDiscFiles'.
    @Test
    public void checkIfTitleMatches(){
        searchDisc.allDiscFiles.add(expectedMusicFile);
        DiscFile expected = expectedMusicFile;
        DiscFile actual = searchDisc.searchDiscByTitle("Jazz Music");
        assertEquals(expected, actual);
    }

    // REFACTOR step: Test to see whether the method will return the expected disc object from the vector 'allDiscFiles',
    // regardless of upper case or lower case letters in the parameter title.
    @Test
    public void upperCaseTest(){
        searchDisc.allDiscFiles.add(expectedMusicFile);
        DiscFile expected = expectedMusicFile;
        DiscFile actual = searchDisc.searchDiscByTitle("jazz music");
        assertEquals(expected, actual);
    }


    // REFACTOR step: Test to see whether the method will return the expected disc object from the vector 'allDiscFiles',
    // when the vector contains multiple objects, by comparing titles.
    @Test
    public void checkThroughMultipleDiscs(){
        Music randomMusicCD1 = new Music("Random CD 1", "11/12/1993","Rock","Jack",12,100);
        DiscFile<Music> randomMusicFile1  = new DiscFile<Music>(randomMusicCD1, randomMusicCD1.getTitle(), randomMusicCD1.getFullDetails(), "randomcCD1");

        Music randomMusicCD2 = new Music("Random CD 2", "08/05/2004","Pop","Ben",8,70);
        DiscFile<Music> randomMusicFile2  = new DiscFile<Music>(randomMusicCD2, randomMusicCD1.getTitle(), randomMusicCD2.getFullDetails(), "randomCD2");

        searchDisc.allDiscFiles.add(randomMusicFile1);
        searchDisc.allDiscFiles.add(randomMusicFile2);
        searchDisc.allDiscFiles.add(expectedMusicFile);
        DiscFile expected = expectedMusicFile;
        DiscFile actual = searchDisc.searchDiscByTitle("Jazz Music");
        assertEquals(expected, actual);
    }


}
