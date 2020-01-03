package com.example.form;

import dagger.Component;

@Component(modules = SharedPreferenceBuilder.class)
public interface SharedPreferenceComponent {
    void  getSharedPreferenceObj(MovieBookingMainActivity movieBookingMainActivity);

    SharedPreferenceBuilder getSharedPreferenceBuilder();
}
