package com.example.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ViewSports extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sports);
        ListView listView = findViewById(R.id.movieListView);
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");

        List<SportsClub> list = MyAppDatabase.getDatabase(ViewSports.this).myDAO().getUserClubs(user);

        SportsListAdapter adapter = new SportsListAdapter(ViewSports.this, list);
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
