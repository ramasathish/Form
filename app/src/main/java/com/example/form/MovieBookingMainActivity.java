package com.example.form;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.form.databinding.DashboardBinding;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MovieBookingMainActivity extends AppCompatActivity {
    private MovieListViewModel movieList = new MovieListViewModel();
    private DashBoardViewModel dashBoardViewModel = new DashBoardViewModel();
    private ArrayList<String> movies = new ArrayList();
    public static final String MOVIE_BOOKING = "com.example.form.movieBookingSharedFile";

    @Inject  SharedPreferenceBuilder sharedPreferenceBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* setContentView(R.layout.activity_main);Data */

        DashboardBinding dashboardBinding = DataBindingUtil.setContentView(this, R.layout.dashboard);

        dashboardBinding.setDashBoardViewModel(dashBoardViewModel);

        TextView navigateLink = (TextView) findViewById(R.id.navigateLink);
        navigateLink.setMovementMethod(LinkMovementMethod.getInstance());

    }


    public void addNewMovie(View view) {
        SharedPreferenceComponent sharedPreferenceComponent = DaggerSharedPreferenceComponent.builder().
                sharedPreferenceBuilder(new SharedPreferenceBuilder(this)).build();

          sharedPreferenceComponent.getSharedPreferenceObj(this);
          sharedPreferenceBuilder.addDataInSharedPref(dashBoardViewModel.newMovie.get(), dashBoardViewModel.newMovie.get());

     //   sharedPreferenceComponent.getSharedPreferenceBuilder().addDataInSharedPref(dashBoardViewModel.newMovie.get(), dashBoardViewModel.newMovie.get());

        Toast.makeText(view.getContext(), dashBoardViewModel.newMovie.get() + " Added in Shared Preferences", Toast.LENGTH_LONG).show();
    }

    public void navigateRecyclerViewPage(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);

    }
}
