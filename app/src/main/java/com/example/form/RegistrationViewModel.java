package com.example.form;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.regex.Pattern;

import androidx.databinding.ObservableField;

public class RegistrationViewModel  {
    public  ObservableField<String> username=new ObservableField<String>();
    public  ObservableField<String>  contactNo=new ObservableField<String>();
    public  ObservableField<String>  emailId=new ObservableField<String>();
    public  ObservableField<String>  gender=new ObservableField<String>();
    public final ObservableField<String>  fordEmp=new ObservableField<String>();
    public final ObservableField<String>  country=new ObservableField<String>();
    public final ObservableField<String>  password=new ObservableField<String>();
    public final ObservableField<String> confPassword=new ObservableField<String>();
    public final ObservableField<String>  toastMessage=new ObservableField<String>();
    public  ObservableField<Boolean>  buttonEnabled=new ObservableField<>();


    public static ObservableField<Boolean> isValidUsername=new ObservableField<Boolean>(false);
    public static ObservableField<Boolean> isValidContactNo=new ObservableField<Boolean>(false);
    public static ObservableField<Boolean> isValidEmailId=new ObservableField<Boolean>(false);
    public static ObservableField<Boolean> isValidGender=new ObservableField<Boolean>(false);
    public static ObservableField<Boolean> isValidFordEmp=new ObservableField<Boolean>(false);
    public static ObservableField<Boolean> isValidCountry=new ObservableField<Boolean>(false);
    public static ObservableField<Boolean> isValidPassword=new ObservableField<Boolean>(false);
    public static ObservableField<Boolean> isValidConfPassword=new ObservableField<Boolean>(false);

    public void usernameValidation(View view, String name) {
        String regex = "^[A-Za-z0-9_.-]*$";
        Pattern pattern = Pattern.compile(regex);
        if(TextUtils.isEmpty(username.get())) {
            isValidUsername.set(false);
            Toast.makeText(view.getContext(), "UserName is Required", Toast.LENGTH_SHORT).show();

        }
            else if (!TextUtils.isEmpty(username.get()) && !pattern.matcher(username.get()).matches()) {
                isValidUsername.set(false);
                Toast.makeText(view.getContext(), "Invalid UserName", Toast.LENGTH_SHORT).show();

            } else if (!TextUtils.isEmpty(username.get()) && username.get().length() < 5) {
                isValidUsername.set(false);

                Toast.makeText(view.getContext(), "UserName must be more than 5", Toast.LENGTH_SHORT).show();


            } else {
                isValidUsername.set(true);
            }

        enableButton();
    }
    public void passwordValidation(View view, String name) {
        String regex = "^[A-Za-z0-9_.!@#$%^&*()++]*$";
        Pattern pattern = Pattern.compile(regex);
        if(TextUtils.isEmpty(password.get())) {
            isValidPassword.set(false);
            Toast.makeText(view.getContext(), "Password is Required", Toast.LENGTH_SHORT).show();

        }
        else if (!TextUtils.isEmpty(password.get()) && !pattern.matcher(password.get()).matches()) {
            isValidPassword.set(false);
            Toast.makeText(view.getContext(), "Invalid Password", Toast.LENGTH_SHORT).show();

        } else if (!TextUtils.isEmpty(password.get()) && password.get().length() < 5) {
            isValidPassword.set(false);

            Toast.makeText(view.getContext(), "Password must be more than 6", Toast.LENGTH_SHORT).show();


        } else {
            isValidPassword.set(true);
        }

        enableButton();
    }

public void contactnoValidation(View view,String message){

        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
    if(TextUtils.isEmpty(contactNo.get())) {
        isValidContactNo.set(false);
        Toast.makeText(view.getContext(), "Contact No is Required", Toast.LENGTH_SHORT).show();

    }
    else if (!TextUtils.isEmpty(contactNo.get()) && !pattern.matcher(contactNo.get()).matches()) {
        isValidContactNo.set(false);
        Toast.makeText(view.getContext(), "Invalid Contact No", Toast.LENGTH_SHORT).show();

    }
        else if (!pattern.matcher(contactNo.get()).matches()) {
            Toast.makeText(view.getContext(),"Contact No is invalid",Toast.LENGTH_SHORT).show();
            isValidContactNo.set(false);
        } else
            isValidContactNo.set(true);

    enableButton();
}

public void emailIdValidation(View view,String message){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regex);
    if(TextUtils.isEmpty(emailId.get())) {
        isValidEmailId.set(false);
        Toast.makeText(view.getContext(), "EmailId is Required", Toast.LENGTH_SHORT).show();

    }
    else if (!TextUtils.isEmpty(emailId.get()) && !pattern.matcher(emailId.get()).matches()) {
        isValidEmailId.set(false);
        Toast.makeText(view.getContext(), "Invalid EmailId", Toast.LENGTH_SHORT).show();

    }



        else
            isValidEmailId.set(true);



    enableButton();
}




    public void genderValidation(String value) {

        gender.set(value);
           if (!TextUtils.isEmpty(gender.get())) {
                isValidGender.set(true);
            }

         else {
            System.out.println("gender checkkkk");
            gender.set("");
            isValidGender.set(false);


        }
        enableButton();
    }

    public void spinnerValidation(AdapterView parent,View view,int pos,long id){
        country.set((String) parent.getSelectedItem());

            System.out.println("previous validation are success");
            if(!parent.getSelectedItem().equals("select")) {
                isValidCountry.set(true);
            }

        else{
            parent.setSelection(0);
            isValidCountry.set(false);


        }
        enableButton();

    }

    public void passwordClick(View view, String name){
        System.out.println("Password"+password.get());

        System.out.println("confPassword"+confPassword.get());
           if(TextUtils.isEmpty(confPassword.get())) {
               Toast.makeText(view.getContext(), "Confirm Password is required", Toast.LENGTH_SHORT).show();

            isValidConfPassword.set(false);
            confPassword.set("");
        }

        else if(  (!TextUtils.isEmpty(confPassword.get())) && !password.get().equals(confPassword.get())) {
               Toast.makeText(view.getContext(), "Confirm Password not matched with Password", Toast.LENGTH_SHORT).show();

            isValidConfPassword.set(false);
            confPassword.set("");
        }

           else if(password.get().equals(confPassword.get())){
               System.out.println("matching");
                isValidConfPassword.set(true);
            }

       enableButton();
    }

public void agreeCheckBoxValidation(String value){
    System.out.println("Value  "+value);
}

    public void enableButton(){
        System.out.println(isValidUsername.get() +"  "+ isValidEmailId.get() +"  "+ isValidContactNo.get()
                +"  "+ isValidGender.get() +"  "+ isValidCountry.get() +"  "+ isValidPassword.get()+"   "+isValidConfPassword.get());
        if(isValidUsername.get() && isValidEmailId.get() && isValidContactNo.get()
            && isValidGender.get() && isValidCountry.get()
                && isValidPassword.get()  && isValidConfPassword.get()){
            buttonEnabled.set(true);
        }
        else
            buttonEnabled.set(false);
    }
}
