package com.example.form;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.form.databinding.DashboardBinding;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MovieBookingMainActivity extends AppCompatActivity {
    MovieListViewModel movieList = new MovieListViewModel();
    DashBoardViewModel dashBoardViewModel = new DashBoardViewModel();
    ArrayList<String> movies = new ArrayList();
    public static final String MOVIE_BOOKING = "com.example.form.movieBookingSharedFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* setContentView(R.layout.activity_main);Data */

        DashboardBinding dashboardBinding = DataBindingUtil.setContentView(this, R.layout.dashboard);

        dashboardBinding.setDashBoardViewModel(dashBoardViewModel);

        TextView navigateLink=(TextView)findViewById(R.id.navigateLink);
        navigateLink.setMovementMethod(LinkMovementMethod.getInstance());

    }


    public void addNewMovie(View view) {


        SharedPreferences sharedPreferences = getSharedPreferences(MOVIE_BOOKING, Context.MODE_PRIVATE);

        sharedPreferences.edit().putString(dashBoardViewModel.newMovie.get(), dashBoardViewModel.newMovie.get()).commit();

        Toast.makeText(view.getContext(), dashBoardViewModel.newMovie.get() + " Added in Shared Preferences", Toast.LENGTH_LONG).show();
    }
    public void navigateRecyclerViewPage(View view) {
         Intent intent=new Intent(this,RecyclerViewActivity.class);
         startActivity(intent);

    }
}
