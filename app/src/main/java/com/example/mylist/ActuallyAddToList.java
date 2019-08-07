package com.example.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ActuallyAddToList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actually_add_to_list);
        Intent intent = getIntent();
        final String user = intent.getStringExtra("user");
        final int id = intent.getIntExtra("list id", 0);
        Button add = findViewById(R.id.actuallyAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MyList> list = MyAppDatabase.getDatabase(ActuallyAddToList.this).myDAO().getAllUserLists(user);
                EditText name = findViewById(R.id.nameTitleText);
                String big = list.get(id-1).getBigList() + name.getText().toString() + "*";
                String type = list.get(id-1).getType();
                MyList myList = new MyList(id,list.get(id-1).getTitle(),type,user,big);
                MyAppDatabase.getDatabase(ActuallyAddToList.this).myDAO().updateList(myList);
                Intent goBack = new Intent(ActuallyAddToList.this, ViewLists.class);
                goBack.putExtra("user",user);
                startActivity(goBack);
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
