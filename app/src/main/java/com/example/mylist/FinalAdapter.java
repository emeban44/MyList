package com.example.mylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FinalAdapter extends BaseAdapter {

    private Context context;
    private List<String> movies;

    public FinalAdapter(Context context, List<String> movies) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.final_list_view, parent, false);
        String movie = movies.get(position);

        TextView title = convertView.findViewById(R.id.textTitle);
        String pos = Integer.toString(position+1);
        pos+=". "+ movie;
        title.setText(pos);

        return convertView;
    }
}
