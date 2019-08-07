package com.example.mylist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "songs")
public class Song {
    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String name;
    private String artist;
    private String genre;
    private String year;
    private String user;


    @Ignore
    public Song(String name, String genre, String year, String rating, String user){
        this.name=name;
        this.genre=genre;
        this.year=year;
        this.artist=rating;
        this.user = user;
    }
    public Song(int ID, String name, String artist, String genre, String year, String user) {
        ID = ID;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
