package com.example.mylist;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMovie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        Intent intent = getIntent();
        final String  username = intent.getStringExtra("user");
        Button save = findViewById(R.id.saveMovie);
   //     Button cancel = findViewById(R.id.cancelMovie);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = findViewById(R.id.titleMovie);
                EditText genre = findViewById(R.id.genreMovie);
                EditText year = findViewById(R.id.yearMovie);
                EditText rating = findViewById(R.id.ratingMovie);

                if (title.getText().toString().isEmpty() || genre.getText().toString().isEmpty() || year.getText().toString().isEmpty() || rating.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fields cannot be left empty!",Toast.LENGTH_LONG).show();
                }
                else{

                    Movie movie = new Movie(title.getText().toString(), genre.getText().toString(),year.getText().toString(),rating.getText().toString(),username);
                    movie.setName(title.getText().toString());
                    movie.setGenre(genre.getText().toString());
                    movie.setYear(year.getText().toString());
                    movie.setRating(rating.getText().toString());
                    movie.setUser(username);
                    MyAppDatabase.getDatabase(AddMovie.this).myDAO().addMovie(movie);

                    Intent switching = new Intent(AddMovie.this, NavigationActivity.class);
                    switching.putExtra("username",username);
                    startActivity(switching);


                }
            }
        });
/*
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddMovie.this, NavigationActivity.class);
                startActivity(intent);
            }
        }); */

    }
    public void onPause() {
        super.onPause();
        this.finish();
    }
    public void onStop() {
        super.onStop();
        finish();
    }
}
