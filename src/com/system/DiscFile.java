package com.system;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class DiscFile<T>{
    private T disc;
    private String discTitle;
    private String fullDetails;
    private String filename;
    private String filepath;

    public DiscFile(T disc, String discTitle, String fullDetails, String filename){
        this.disc=disc;
        this.discTitle=discTitle;
        this.fullDetails=fullDetails;
        this.filename=filename;
        this.filepath="textfiles\\"+filename+".txt";
        writeDiscDetailsToFile();
    }

    public void setDiscTitle(String discTitle){this.discTitle=discTitle;}
    public String getDiscTitle(){return discTitle;}

    public void setFullDetails(String fullDetails){this.fullDetails=fullDetails;}
    public String getFullDetails(){return fullDetails;}

    public void setFilename(String filename){this.filename=filename;}
    public String getFilename(){return filename;}

    public void writeDiscDetailsToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true)))
        {
            writer.write(fullDetails);
            writer.close();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readDiscDetailsFromFile(){
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

    public void renameFile(Scanner input){
        String newFilename;
        boolean fileRenamed = false;
        while(!fileRenamed) {
            System.out.print("Please enter a new filename: ");
            newFilename=input.nextLine();

            File originalFile = new File(filepath);
            File newFile = new File("textfiles\\" + newFilename + ".txt");

            if (originalFile.renameTo(newFile)) {
                fileRenamed = true;
                this.filename=newFilename;
                System.out.println("\nFile renamed successfully.");
            } else {
                System.out.println("\nFile could not be renamed.");
            }
        }
    }

    public void deleteFile(){
        File fileToDelete = new File(filepath);
        if(fileToDelete.delete()){
            System.out.println("\nFile successfully deleted.");
        }else{
            System.out.println("\nFile failed to be deleted.");
        }
    }
}
