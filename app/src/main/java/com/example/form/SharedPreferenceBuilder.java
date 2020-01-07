package com.example.form;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceBuilder {

    SharedPreferences sharedPreferences;
    public static final String MOVIE_BOOKING = "com.example.form.movieBookingSharedFile";
    Context context;

    @Inject
    public SharedPreferenceBuilder(Context context) {
        this.context = context;
    }

    @Provides
    public Context getContext() {
        return context;
    }

    public String addDataInSharedPref(String key, String value) {

        sharedPreferences = context.getSharedPreferences(MOVIE_BOOKING, Context.MODE_PRIVATE);

        sharedPreferences.edit().putString(key, value).commit();
        return "success";

    }


}
