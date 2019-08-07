package com.example.mylist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "albums")
public class MusicAlbum {

            @PrimaryKey(autoGenerate = true)
            private int ID;
            private String name;
            private String artist;
            private int year;
            private String genre;

    public MusicAlbum(int ID, String name, String artist, int year, String genre) {
        ID = ID;
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
