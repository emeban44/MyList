package com.example.mylist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.Nullable;

@Entity(tableName = "lists")
public class MyList {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String title;
    private String type;
    private String user;
    private String bigList;

    @Ignore
    public MyList(String title, String type, String user) {
        this.title = title;
        this.type = type;
        this.user = user;
        this.bigList="*";
    }

    public MyList(int id, String title, String type, String user, String big){
        this.ID=id;
        this.title=title;
        this.type=type;
        this.user=user;
        this.bigList=big;
    }
    public MyList(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getBigList() {
        return bigList;
    }

    public void setBigList(String bigList) {
        this.bigList = bigList;
    }

    public String addToBigList(String adding){
        return this.bigList+adding+"*";
    }
}
