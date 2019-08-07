package com.example.mylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MovieListAdapter extends BaseAdapter {
    private Context context;
    private List<Movie> movies;

    public MovieListAdapter(Context context, List<Movie> movies) {
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
        Movie movie = movies.get(position);

        TextView title = convertView.findViewById(R.id.textTitle);
        TextView rating = convertView.findViewById(R.id.textRating);
        TextView year = convertView.findViewById(R.id.textYear);
        TextView genre = convertView.findViewById(R.id.textGenre);

        title.setText(movie.getName());
        rating.setText(movie.getRating());
        year.setText(movie.getYear());
        genre.setText(movie.getGenre());
        return convertView;
    }
}
