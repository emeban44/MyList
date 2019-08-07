package com.example.mylist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDAO {

    @Insert
    public void addMovie(Movie movie);

    @Insert
    void addSong(Song song);

    @Insert
    void addClub(SportsClub club);

    @Insert
    void addList(MyList list);

    @Query("SELECT * FROM movies")
    public List<Movie> getAllMovies();

    @Query("SELECT * FROM lists where user = :User")
    List<MyList> getAllUserLists(String User);

    @Query("SELECT * FROM songs")
    public List<Song> getAllSongs();

    @Query("SELECT * FROM clubs")
    public List<SportsClub> getaAllClubs();

    @Query("SELECT * FROM movies where user = :User")
    List<Movie> getUserMovies(String User);

    @Query("SELECT * FROM songs where user = :User")
    List<Song> getUserSongs(String User);

    @Query("SELECT * FROM clubs where user = :User")
    List<SportsClub> getUserClubs(String User);

    @Delete
    void deleteAllMovies(List<Movie> list);

    @Delete
    void deleteAllSongs(List<Song> list);

    @Delete
    void deleteAllClubs(List<SportsClub> list);

    @Delete
    void deleteAllLists(List<MyList> list);

    @Update
    void updateList(MyList list);

}
