package com.example.form;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import com.example.form.databinding.LoginlayoutBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LoginlayoutBinding loginlayoutBinding = DataBindingUtil.setContentView(this, R.layout.loginlayout);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginlayoutBinding.setLoginViewModel(loginViewModel);

    }

    @Override
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);

    }

    public void onLogin(View view) {

        boolean response = loginViewModel.loginValidation();
        if (response) {
            Intent intent = new Intent(this, MovieBookingMainActivity.class);
            startActivity(intent);

        } else
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }
}
