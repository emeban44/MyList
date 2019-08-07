package com.example.mylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.home_layout,container, false);
        List<MyList> list = MyAppDatabase.getDatabase(getContext()).myDAO().getAllUserLists(getArguments().getString("username"));
        TextView counter = view.findViewById(R.id.counter);
        counter.setText(Integer.toString(list.size()));
        final String username = getArguments().getString("username");
        TextView userPlace = view.findViewById(R.id.placeForUser);
        userPlace.setText(username);
        Button viewLists = view.findViewById(R.id.viewLists);
        viewLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewLists.class);
                intent.putExtra("user", getArguments().getString("username"));
                startActivity(intent);
            }
        });


        return view;


    }

}
