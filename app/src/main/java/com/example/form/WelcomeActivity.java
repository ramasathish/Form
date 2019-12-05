package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    public Bundle getbundle=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      //  Intent mIntent = getIntent();
        getbundle=this.getIntent().getExtras();




        EditText editText1=(EditText) findViewById(R.id.name);
        editText1.setText(getbundle.getString("Name"));

        EditText number=(EditText)findViewById(R.id.number);
        number.setText(getbundle.getString("contact"));

        EditText email=(EditText)findViewById(R.id.email);
        email.setText(getbundle.getString("email"));

        EditText gender=(EditText)findViewById(R.id.gender);
        gender.setText(getbundle.getString("gender"));



        EditText country=(EditText)findViewById(R.id.country);
        country.setText(getbundle.getString("Country"));


        //Bundle b= mIntent.getExtras();
       /* Bundle b=mIntent.getBundleExtra("bundle");


        String nam=b.getString("Name");

        //showName.setText(nam);
        System.out.println(nam);*/



       /* Part of Parcelable interface


       RegistrationEntity registrationEntity = (RegistrationEntity) mIntent.getParcelableExtra("newEmp");
        System.out.println(registrationEntity.toString());

        EditText editText1=(EditText) findViewById(R.id.name);
        editText1.setText(registrationEntity.getUsername());

        EditText number=(EditText)findViewById(R.id.number);
        number.setText(registrationEntity.getContactNo());

        EditText email=(EditText)findViewById(R.id.email);
        email.setText(registrationEntity.getEmailId());

        EditText gender=(EditText)findViewById(R.id.gender);
        gender.setText(registrationEntity.getGender());



        EditText country=(EditText)findViewById(R.id.country);
        country.setText(registrationEntity.getCountry());
        */


    }
}
