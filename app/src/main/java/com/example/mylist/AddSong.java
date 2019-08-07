package com.example.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddSong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);
        Intent intent = getIntent();
        final String  username = intent.getStringExtra("user");
        Button save = findViewById(R.id.saveSong);
      //  Button cancel = findViewById(R.id.cancelSong);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = findViewById(R.id.songTitle);
                EditText artist = findViewById(R.id.songArtist);
                EditText year = findViewById(R.id.songYear);
                EditText genre = findViewById(R.id.songGenre);

                if (title.getText().toString().isEmpty() || genre.getText().toString().isEmpty() || year.getText().toString().isEmpty() || artist.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fields cannot be left empty!",Toast.LENGTH_LONG).show();
                }else{
                    Song movie = new Song(title.getText().toString(), genre.getText().toString(),year.getText().toString(),artist.getText().toString(), username);
                    movie.setName(title.getText().toString());
                    movie.setGenre(genre.getText().toString());
                    movie.setYear(year.getText().toString());
                    movie.setArtist(artist.getText().toString());
                    MyAppDatabase.getDatabase(AddSong.this).myDAO().addSong(movie);

                    Intent switching = new Intent(AddSong.this, NavigationActivity.class);
                    switching.putExtra("username",username);
                    startActivity(switching);
                }
            }
        });
/*
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSong.this, NavigationActivity.class);
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
