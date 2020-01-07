package com.example.form;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.form.databinding.ActivityMainBinding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    RegistrationViewModel registrationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        /* setContentView(R.layout.activity_main);Data */
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        registrationViewModel = new RegistrationViewModel();
        activityMainBinding.setRegViewModel(registrationViewModel);

    }

    static Toast toast;

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        System.out.println("Message" + message);
        if (message != null) {
            toast = Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT);
            toast.show();
          /*  Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.show();
                }
            }, 1000);*/
        }
    }

   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }*/

    public void onSubmit(View view) {
        final Intent intent = new Intent(this, WelcomeActivity.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to Proceed");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = registrationViewModel.username.get();
                String contactNo = registrationViewModel.contactNo.get();
                String email = registrationViewModel.emailId.get();
                String gender = registrationViewModel.gender.get();

                String country = registrationViewModel.country.get();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putString("contact", contactNo);
                bundle.putString("email", email);
                bundle.putString("gender", gender);
                bundle.putString("Country", country);

                intent.putExtras(bundle);
                //intent.putExtra("bundle",bundle);
                startActivity(intent);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        /*Using Parcelable interface

        RegistrationEntity registrationEntity=new RegistrationEntity(name,contactNo,email,gender,swit,country);
        intent.putExtra("newEmp",registrationEntity);*/
    }
}
