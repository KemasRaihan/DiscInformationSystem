package com.tests;

import com.system.DiscFile;

import java.util.Vector;

public class SearchDiscByTitle {
    Vector<DiscFile> allDiscFiles= new Vector<DiscFile>();

    public DiscFile searchDiscByTitle(String title){
        DiscFile desiredDiscFile=null;
        for(DiscFile discFile:allDiscFiles) if(discFile.getDiscTitle().toUpperCase().equals(title.toUpperCase())) desiredDiscFile=discFile;
        return desiredDiscFile;
    }

}
