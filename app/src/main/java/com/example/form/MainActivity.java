package com.example.form;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }*/

    public void onSubmit(View view){

        EditText editText;
        editText=(EditText) findViewById(R.id.namef);
        String name=editText.getText().toString();

        editText=(EditText) findViewById(R.id.mobilef);
        String contactNo=editText.getText().toString();

        editText=(EditText) findViewById(R.id.emailf);
        String email=editText.getText().toString();

        RadioGroup rad;
        rad=(RadioGroup)findViewById(R.id.radioGroup);

    /*    rad.clearCheck();
        rad.setOnCheckedChangeListener(
                new radioGroup.OnCheckedChangeListener(){});*/
    int selectedId=rad.getCheckedRadioButtonId();
    RadioButton value=(RadioButton) findViewById(selectedId);
    String gender= value.getText().toString();

    Spinner spinner=(Spinner) findViewById(R.id.countryList);
    String country=spinner.getSelectedItem().toString();

        Switch sw=(Switch) findViewById(R.id.fordEmployee);
     //  Boolean switch=sw.isChecked();
        String swit=sw.getText().toString();

        editText=(EditText) findViewById(R.id.pass);
        String pwd=editText.getText().toString();

        editText=(EditText) findViewById(R.id.confpassf);
        String pwdcnf=editText.getText().toString();


        Intent intent=new Intent(this,WelcomeActivity.class);

        //Creating new object of bundle and adding the parameters

        Bundle bundle =new Bundle();
        bundle.putString("Name",name);
        bundle.putString("contact",contactNo);
        bundle.putString("email",email);
        bundle.putString("gender",gender);
        bundle.putString("Country",country);
        bundle.putString("Switch",swit);

        intent.putExtras(bundle);
        //intent.putExtra("bundle",bundle);


            startActivity(intent);


        /*Using Parcelable interface

        RegistrationEntity registrationEntity=new RegistrationEntity(name,contactNo,email,gender,swit,country);
        intent.putExtra("newEmp",registrationEntity);*/






    }
}
