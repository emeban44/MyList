package com.example.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {
    public SecondFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_layout, container, false);
        Button music = (Button) view.findViewById(R.id.createMusic);
        Button movie = (Button) view.findViewById(R.id.createMovie);
        Button sport = (Button) view.findViewById(R.id.createSport);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateList.class);
                intent.putExtra("user", getArguments().getString("username"));
                intent.putExtra("type", "music");
                startActivity(intent);
            }
        });

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateList.class);
                intent.putExtra("user", getArguments().getString("username"));
                intent.putExtra("type", "movie");
                startActivity(intent);
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateList.class);
                intent.putExtra("user", getArguments().getString("username"));
                intent.putExtra("type", "sport");
                startActivity(intent);
            }
        });

        return view;

    }




}
