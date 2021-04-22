package com.tests;

import java.io.File;

public class RenameFile {
    public boolean renameFile(String originalFilename, String newFilename){
        boolean fileRenamed = false;
        File originalFile = new File("textfiles\\"+originalFilename+".txt");
        File newFile = new File("textfiles\\"+newFilename+".txt");
        boolean alreadyExists=false;
        if (originalFile.renameTo(newFile)) {
            fileRenamed = true;
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("File could not be renamed.");
        }
        return fileRenamed;
    }
}
