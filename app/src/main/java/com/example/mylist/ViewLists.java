package com.example.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ViewLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lists);
        ListView listView = findViewById(R.id.listOfLists);
        Intent intent = getIntent();
        final String user = intent.getStringExtra("user");
        List<MyList> list = MyAppDatabase.getDatabase(ViewLists.this).myDAO().getAllUserLists(user);
      //MyAppDatabase.getDatabase(ViewLists.this).myDAO().deleteAllLists(list);
        ListListAdapter adapter = new ListListAdapter(ViewLists.this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyList myList = (MyList) parent.getItemAtPosition(position);
                Intent intent = new Intent(ViewLists.this, AddToList.class);
                intent.putExtra("list id", myList.getID());
                intent.putExtra("username", user);
                intent.putExtra("title", myList.getTitle());
                startActivity(intent);
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
