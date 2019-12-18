package com.example.form;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class WelcomeActivityViewModel extends ViewModel {
    public ObservableField<String> username=new ObservableField<String>();
    public  ObservableField<String>  contactNo=new ObservableField<String>();
    public  ObservableField<String>  emailId=new ObservableField<String>();
    public  ObservableField<String>  gender=new ObservableField<String>();
    public  ObservableField<String>  fordEmp=new ObservableField<String>();
    public  ObservableField<String>  country=new ObservableField<String>();
    public  ObservableField<String>  password=new ObservableField<String>();
    public  ObservableField<String> confPassword=new ObservableField<String>();
    public  ObservableField<String>  toastMessage=new ObservableField<String>();


}
