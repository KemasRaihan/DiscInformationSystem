package com.system;


public class Music extends Disc {
    private String artist;
    private int numberOfSongs;
    private int durationInMinutes;       // in minutes

    public Music(String title, String releaseDate, String genre, String artist, int numberOfSongs, int durationInMinutes) {
        super(title, releaseDate, genre);
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
        this.durationInMinutes = durationInMinutes;
    }

    public void setArtist(String artist){this.artist=artist;}
    public String getArtist() {return artist;}

    public void setNumberOfSongs(int numberOfSongs){this.numberOfSongs=numberOfSongs;}
    public int getNumberOfSongs() {return numberOfSongs;}

    public void setDurationInMinutes(int durationInMinutes){this.durationInMinutes=durationInMinutes;}
    public int getDurationInMinutes() {return durationInMinutes;}

    public String getFullDetails(){return super.getDefaultDetails()+"Artist: "+artist+"\nNumber Of Songs: "+numberOfSongs+"\nDuration (minutes): "+durationInMinutes+"\n";}
}
