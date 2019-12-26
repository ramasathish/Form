package com.example.form;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    MovieListViewModel movieList = new MovieListViewModel();
    DashBoardViewModel dashBoardViewModel = new DashBoardViewModel();
    ArrayList<String> movies = new ArrayList();
    public static final String MOVIE_BOOKING = "com.example.form.movieBookingSharedFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);

        movies.add(movieList.movieName1.get());
        movies.add(movieList.movieName2.get());
        SharedPreferences sharedPreferences = getSharedPreferences(MOVIE_BOOKING, Context.MODE_PRIVATE);
        Map<String, ?> sharedData = sharedPreferences.getAll();
        for (Map.Entry entry : sharedData.entrySet()) {
            movies.add(entry.getValue().toString());
        }

        sharedPreferences.getString("movie1", "");
        MovieListItem movieListItem = new MovieListItem(movies);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        MovieBookingAdapter adapter = new MovieBookingAdapter(movieListItem);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
