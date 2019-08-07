package com.example.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddClub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_club);
        Intent intent = getIntent();
        final String  username = intent.getStringExtra("user");
        Button save = findViewById(R.id.saveClub);
      //  Button cancel = findViewById(R.id.cancelClub);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.clubName);
                EditText country = findViewById(R.id.clubCountry);
                EditText year = findViewById(R.id.clubYear);
                EditText sport = findViewById(R.id.clubSports);

                if (name.getText().toString().isEmpty() || country.getText().toString().isEmpty() || year.getText().toString().isEmpty() || sport.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fields cannot be left empty!",Toast.LENGTH_LONG).show();
                }
                else{

                    SportsClub movie = new SportsClub(name.getText().toString(), country.getText().toString(),year.getText().toString(),sport.getText().toString(),username);
                    movie.setName(name.getText().toString());
                    movie.setCountry(country.getText().toString());
                    movie.setYear(year.getText().toString());
                    movie.setSport(sport.getText().toString());
                    MyAppDatabase.getDatabase(AddClub.this).myDAO().addClub(movie);

                    Intent switching = new Intent(AddClub.this, NavigationActivity.class);
                    switching.putExtra("username",username);
                    startActivity(switching);


                }
            }
        });
/*
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                startActivity(intent);
            }
        }); */
    }public void onPause() {
        super.onPause();
        this.finish();
    }
    public void onStop() {
        super.onStop();
        finish();
    }
}
