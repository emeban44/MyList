package com.example.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        Button create = findViewById(R.id.create);

        Intent pickUp = getIntent();
        final String user = pickUp.getStringExtra("user");
        final String type = pickUp.getStringExtra("type");
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = findViewById(R.id.listTitle);
                String listTitle = title.getText().toString();
                MyList myList = new MyList(listTitle, type, user);
                MyAppDatabase.getDatabase(CreateList.this).myDAO().addList(myList);
                Intent switching = new Intent(CreateList.this, NavigationActivity.class);
                switching.putExtra("username",user);
                startActivity(switching);
            }
        });
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
