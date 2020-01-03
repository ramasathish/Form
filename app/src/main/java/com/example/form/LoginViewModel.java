package com.example.form;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public ObservableField<String> username=new ObservableField<String>();
    public ObservableField<String> password=new ObservableField<String>();


    public boolean loginValidation(){
        ResponseBuilderComponent responseBuilderComponent =  DaggerResponseBuilderComponent.create();
        return responseBuilderComponent.getResponseBuilder().validate(username.get(),password.get());
    }

}
