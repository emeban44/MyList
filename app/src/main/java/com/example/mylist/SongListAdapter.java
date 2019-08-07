package com.example.mylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SongListAdapter extends BaseAdapter {
    private Context context;
    private List<Song> movies;

    public SongListAdapter(Context context, List<Song> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.list_view, parent, false);
        Song movie = movies.get(position);

        TextView title = convertView.findViewById(R.id.textTitle);
        TextView rating = convertView.findViewById(R.id.textRating);
        TextView year = convertView.findViewById(R.id.textYear);
        TextView genre = convertView.findViewById(R.id.textGenre);

        title.setText(movie.getName());
        rating.setText(movie.getArtist());
        year.setText(movie.getYear());
        genre.setText(movie.getGenre());
        return convertView;
    }
}
