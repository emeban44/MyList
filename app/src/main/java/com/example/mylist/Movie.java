package com.example.mylist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "movies")
public class Movie {

            @PrimaryKey(autoGenerate = true)
            private int ID;
            private String name;
            private String genre;
            private String year;
            private String rating;
            private String user;

    @Ignore
    public Movie(String name, String genre, String year, String rating, String user){
        this.name=name;
        this.genre=genre;
        this.year=year;
        this.rating=rating;
        this.user = user;
    }


    public Movie(int ID, String name, String genre, String year, String rating, String user){
        this.ID=ID;
        this.name=name;
        this.genre=genre;
        this.year=year;
        this.rating=rating;
        this.user=user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
