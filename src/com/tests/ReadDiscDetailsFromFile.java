package com.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadDiscDetailsFromFile {

    public String readDiscDetailsFromFile(String filepath){
        ArrayList<String> linesRead = new ArrayList<String>();
        BufferedReader reader = null;
        String line="";
        try{
            reader = new BufferedReader(new FileReader(filepath));
            while(line!=null){
                line=reader.readLine();
                linesRead.add(line);
            }
        }catch(IOException e){
                System.out.println(e.getMessage());
        }finally{
            try{
                if(reader != null) reader.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        String fullDetails = linesRead.get(0);
        for(int i=1; i<linesRead.size()-1; i++) fullDetails+="\n"+linesRead.get(i);
        return fullDetails;
    }
}
