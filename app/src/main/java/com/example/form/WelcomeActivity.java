package com.example.form;

import android.os.Bundle;

import com.example.form.databinding.ActivityWelcomeBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class WelcomeActivity extends AppCompatActivity {

    public Bundle getbundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_welcome);
        ActivityWelcomeBinding welcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);


        WelcomeActivityViewModel viewModel = new WelcomeActivityViewModel();

        welcomeBinding.setWelcomeViewModel(viewModel);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //  Intent mIntent = getIntent();
        getbundle = this.getIntent().getExtras();

        viewModel.username.set(getbundle.getString("Name"));

        viewModel.contactNo.set(getbundle.getString("contact"));

        viewModel.emailId.set(getbundle.getString("email"));

        viewModel.gender.set(getbundle.getString("gender"));

        viewModel.country.set(getbundle.getString("Country"));


    }
}
