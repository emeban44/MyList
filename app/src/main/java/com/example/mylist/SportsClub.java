package com.example.mylist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "clubs")
public class SportsClub {
    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String name;
    private String country;
    private String year;
    private String sport;
    private String user;

    @Ignore
    public SportsClub(String name, String country, String year, String sport, String user) {
        this.sport = sport;
        this.name = name;
        this.country = country;
        this.year = year;
        this.user = user;
    }

    public SportsClub(int ID, String name, String country, String year, String sport, String user) {
        this.sport = sport;
        ID = ID;
        this.name = name;
        this.country = country;
        this.year = year;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
