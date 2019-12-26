package com.example.form;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import com.example.form.databinding.LoginlayoutBinding;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel loginViewModel=new LoginViewModel();

    @Inject
    ResponseBuilder responseBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /* setContentView(R.layout.activity_main);Data */

        LoginlayoutBinding loginlayoutBinding = DataBindingUtil.setContentView(this, R.layout.loginlayout);

        loginlayoutBinding.setLoginViewModel(loginViewModel);



    }
    @Override
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle){
        super.onSaveInstanceState(bundle,persistableBundle);

    }
    public void onLogin(View view){

       ResponseBuilderComponent component=DaggerResponseBuilderComponent.create();
     //  responseBuilder = component.getResponseBuilder();
        component.compoenentInject(this);
        boolean response=responseBuilder.validate(loginViewModel.username.get(),loginViewModel.password.get());

        if(response) {
            Intent intent = new Intent(this, MovieBookingMainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
    }


}
