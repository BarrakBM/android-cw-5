package com.example.day4app;

import java.io.Serializable;

public class TvShows implements Serializable {

    private String name;
    private String seasons;
    private String year;
    private String time;
    private String genre;
    private int img;
    private String epi;


    public TvShows(String name, String seasons, String year, int img, String epi, String genre) {

       this.name = name;
       this.seasons = seasons;
       this.year = year;
       this.img = img;
       this.epi = epi;
       this.genre = genre;



    }

    public String getEpi() {
        return epi;
    }

    public void setEpi(String epi) {
        this.epi = epi;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
