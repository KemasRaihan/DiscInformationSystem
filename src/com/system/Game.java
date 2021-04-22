package com.system;

public class Game extends Disc {
    private String rating;
    private String platform;

    public Game(String title, String releaseDate, String genre, String rating, String platform){
        super(title, releaseDate, genre);
        this.rating=rating;
        this.platform=platform;
    }

    public void setRating(String rating){this.rating=rating;}
    public String getRating(){return rating;}

    public void setPlatform(String platform){this.platform=platform;}
    public String getPlatform(){return platform;}

    public String getFullDetails(){return super.getDefaultDetails()+"PEGI Rating: "+rating+"\nPlatform: "+platform+"\n";}
}