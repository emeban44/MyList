package com.example.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddToList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);
        Intent intent = getIntent();
        TextView title = findViewById(R.id.myListTitle);
        title.setText(intent.getStringExtra("title"));
        final String user = intent.getStringExtra("username");
        final int id = intent.getIntExtra("list id", 0);
        List<MyList> list = MyAppDatabase.getDatabase(AddToList.this).myDAO().getAllUserLists(user);
        String byg = list.get(id-1).getBigList();
        List<String> finalBig = biggie(byg);
        if (finalBig.size()>=1){
        ListView listView = findViewById(R.id.morningList);
        FinalAdapter adapter = new FinalAdapter(AddToList.this, finalBig);
        listView.setAdapter(adapter); }
        Button add = findViewById(R.id.addToList);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AddToList.this, ActuallyAddToList.class);
                intent1.putExtra("list id", id);
                intent1.putExtra("user", user);
                startActivity(intent1);
            }
        });
    }

    public void onPause() {
        super.onPause();
    }
   /* public void onResume(){
        super.onResume();
    } */
    public void onStop() {
        super.onStop();
        finish();
    }
    public List<String> biggie(String big){
        List<String> bigList = new ArrayList<>();
        for (int i=0; i<big.length(); i++){
           if (big.charAt(i) == '*'){
               for(int j=i+1; j<big.length(); j++){
                   if (big.charAt(j) == '*'){
                       String help = big.substring(i+1,j);
                       bigList.add(help);
                       break;
                   }
               }
           }
        }
        return bigList;
    }
}
