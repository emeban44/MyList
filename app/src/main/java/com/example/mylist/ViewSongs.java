package com.example.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ViewSongs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_songs);
        ListView listView = findViewById(R.id.movieListView);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        List<Song> list = MyAppDatabase.getDatabase(ViewSongs.this).myDAO().getUserSongs(user);

        SongListAdapter adapter = new SongListAdapter(ViewSongs.this, list);
        listView.setAdapter(adapter);

        // String movieTitle = list.get(15).getName();
        TextView exp = findViewById(R.id.experimentText);
        exp.setText(Integer.toString(list.size()));

      /*  ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent (ViewMovies.this, NavigationActivity.class);
                startActivity(goBack);
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
