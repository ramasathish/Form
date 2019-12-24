package com.example.form;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.form.databinding.DashboardBinding;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieBookingMainActivity extends AppCompatActivity {
    MovieListViewModel movieList=new MovieListViewModel();
    DashBoardViewModel dashBoardViewModel=new DashBoardViewModel();
    ArrayList<String> movies=new ArrayList();

    public static final String MOVIE_BOOKING ="com.example.form.movieBookingSharedFile";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        /* setContentView(R.layout.activity_main);Data */
        DashboardBinding dashboardBinding= DataBindingUtil.setContentView(this,R.layout.dashboard);

        dashboardBinding.setDashBoardViewModel(dashBoardViewModel);


    }
    public void navigateRecyclerViewPage(View view) {
        setContentView(R.layout.recyclerview_main);

      movies.add(movieList.movieName1.get());
      movies.add(movieList.movieName2.get());


    MovieListItem movieListItem=new MovieListItem(movies);


    RecyclerView recyclerView=(RecyclerView) findViewById(R.id.my_recycler_view);
        MovieBookingAdapter adapter=new MovieBookingAdapter(movieListItem);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void addNewMovie(View view) {


    Toast.makeText(view.getContext(),dashBoardViewModel.newMovie.get(),Toast.LENGTH_LONG).show();
    movies.add(dashBoardViewModel.newMovie.get());

      //  SharedPreferences sharedPreferences=getSharedPreferences(MOVIE_BOOKING,)
    }
    }
