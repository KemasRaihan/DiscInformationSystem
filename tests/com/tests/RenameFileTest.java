package com.tests;

import com.system.DiscFile;
import com.system.Music;
import org.junit.Test;
import static org.junit.Assert.*;

public class RenameFileTest {
    RenameFile rename = new RenameFile();

    Music expectedMusicCD = new Music("Jazz Music","10/10/2019","Jazz","Tom Smith",10, 120);
    DiscFile<Music> expectedMusicFile = new DiscFile<Music>(expectedMusicCD, expectedMusicCD.getTitle(), expectedMusicCD.getFullDetails(), "jazz");

    // RED step: minimum code for method to fail.
    @Test
    public void renameFileTest(){
        fail();
    }

    // GREEN step: minimum code for method to pass.
    @Test
    public void checkFilename(){
        boolean actual = rename.renameFile("jazz","tomsmith");
        assertTrue(actual);
    }

    // REFACTOR step: Test to see whether the method has renamed the file or not.
    @Test
    public void checkIfFileHasBeenRenamedOrNot(){
        boolean actual = rename.renameFile("jazz","tomsmith");
        assertTrue(actual);
    }

    // REFACTOR step: Test to see whether the filename already exists for other files in the directory.
    @Test
    public void checkIfNewFilenameAlreadyExists(){
        Music randomMusicCD1 = new Music("Random CD 1", "11/12/1993","Rock","Jack",12,100);
        DiscFile<Music> randomMusicFile1  = new DiscFile<Music>(randomMusicCD1, randomMusicCD1.getTitle(), randomMusicCD1.getFullDetails(), "randomcCD1");

        Music randomMusicCD2 = new Music("Random CD 2", "08/05/2004","Pop","Ben",8,70);
        DiscFile<Music> randomMusicFile2  = new DiscFile<Music>(randomMusicCD2, randomMusicCD1.getTitle(), randomMusicCD2.getFullDetails(), "randomCD2");

        boolean actual = rename.renameFile("tomsmith","badboymusic");
        assertTrue(actual);
    }


}
