package com.system;

public class Disc {
    private String title;
    private String releaseDate;
    private String genre;

    public Disc(String title, String releaseDate, String genre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public void setTitle(String title) {this.title = title;}
    public String getTitle() {return title;}

    public void setReleaseDate(String releaseDate) {this.releaseDate = releaseDate;}
    public String getReleaseDate() {return releaseDate;}

    public void setGenre(String genre){this.genre=genre;}
    public String getGenre() {return genre;}

    public String getDefaultDetails() {return "Title: " + title + "\nRelease Date: " + releaseDate + "\nGenre: " + genre + "\n";}
}