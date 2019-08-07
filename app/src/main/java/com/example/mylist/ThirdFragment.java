package com.example.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThirdFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_layout, container, false);
          Button adding = (Button) view.findViewById(R.id.addMovie);
        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddMovie.class);
                intent.putExtra("user", getArguments().getString("username"));
                startActivity(intent);
           }
         });
        Button addSong = (Button) view.findViewById(R.id.addSong);
        addSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddSong.class);
                intent.putExtra("user", getArguments().getString("username"));
                startActivity(intent);
            }
        });
        Button addClub = (Button) view.findViewById(R.id.addClub);
        addClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddClub.class);
                intent.putExtra("user", getArguments().getString("username"));
                startActivity(intent);

            }
        });

        Button viewMovies = view.findViewById(R.id.viewMovies);
        viewMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         /*       FragmentManager manager = getFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                Fragment fragment = new ViewMovies();
                Fragment fragment1 = new ThirdFragment();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();  */
              Intent intent = new Intent(getActivity(), ViewMovies.class);
                intent.putExtra("user", getArguments().getString("username"));
              startActivity(intent);

            }
        });
        Button viewSongs = view.findViewById(R.id.viewSongs);
        viewSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*   FragmentManager manager = getFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                Fragment fragment = new ViewSongs();
                Fragment fragment1 = new ThirdFragment();
                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit(); */
                Intent intent = new Intent(getActivity(), ViewSongs.class);
                intent.putExtra("user", getArguments().getString("username"));
                  startActivity(intent);

            }
        });

        Button viewSports = view.findViewById(R.id.viewClubs);
        viewSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewSports.class);
                intent.putExtra("user", getArguments().getString("username"));
                startActivity(intent);
            }
        });
        return view;
    }
}
