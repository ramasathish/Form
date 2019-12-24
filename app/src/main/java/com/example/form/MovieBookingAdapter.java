package com.example.form;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

public class MovieBookingAdapter extends RecyclerView.Adapter<MovieBookingAdapter.ViewHolder> {

    private MovieListItem movieList;

    public MovieBookingAdapter(MovieListItem movieList) {
        this.movieList = movieList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recycler_view_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int position){

        viewHolder.textView.setText(movieList.movieName.get(position));

    }

    @Override
    public int getItemCount() {
        return movieList.movieName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View view){
            super(view);
            this.textView=(TextView) view.findViewById(R.id.movie_name_id);
            this.relativeLayout=(RelativeLayout) view.findViewById(R.id.recycler_view_item_id);
        }
    }
}
