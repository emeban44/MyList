package com.example.mylist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Movie.class, MusicAlbum.class, Song.class, SportsClub.class, MyList.class},version=1,exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {
    private static MyAppDatabase INSTANCE;
    public abstract MyDAO myDAO();
    public static MyAppDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, MyAppDatabase.class, "courses_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
