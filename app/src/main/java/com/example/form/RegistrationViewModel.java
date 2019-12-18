package com.example.form;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

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


    public TextWatcher usernameTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String regex = "^[A-Za-z0-9_.-]*$";
            Pattern pattern = Pattern.compile(regex);
            if(TextUtils.isEmpty(username.get())){
               isValidUsername.set(false);

               toastMessage.set("UserName is Required");
            }else if(! pattern.matcher(username.get()).matches()){
                isValidUsername.set(false);
                toastMessage.set("Invalid UserName");
            }
            else if(username.get().length()<5){
                isValidUsername.set(false);

                toastMessage.set("UserName must be more than 5");
            }
            else{
                isValidUsername.set(true);
            }
            enableButton();

        }
    };


    public TextWatcher contactNoWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if(isValidUsername.get()) {
                String regex = "^[0-9]*$";
                Pattern pattern = Pattern.compile(regex);
                if (TextUtils.isEmpty(contactNo.get())) {
                    toastMessage.set("Contact No is Required");
                    isValidContactNo.set(false);
                } else if (!pattern.matcher(contactNo.get()).matches()) {
                    toastMessage.set("Contact No is invalid");
                    isValidContactNo.set(false);
                } else
                    isValidContactNo.set(true);
            }else{

                contactNo.set("");
                //  toastMessage.set("UserName is Required");
                displayToastMessage(isValidUsername.get(),
                        isValidContactNo.get(),
                        isValidEmailId.get(),
                        isValidGender.get(),
                        isValidFordEmp.get(),
                        isValidCountry.get(),
                        isValidPassword.get());
            }
            enableButton();
        }
    };

    public TextWatcher passwordWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            if(isValidUsername.get() && isValidContactNo.get() && isValidCountry.get() && isValidGender.get() && isValidEmailId.get()){

                if(TextUtils.isEmpty(password.get())){
                    toastMessage.set("Password is Required");
                    isValidPassword.set(false);
                }
                else if(password.get().length()<7){
                    toastMessage.set("Password must be more than 7");
                    isValidPassword.set(false);
                }
                else
                    isValidPassword.set(true);
            }

            else {
                password.set("");
                //   toastMessage.set("Contact No is Required");
                displayToastMessage(isValidUsername.get(),
                        isValidContactNo.get(),
                        isValidEmailId.get(),
                        isValidGender.get(),
                        isValidFordEmp.get(),
                        isValidCountry.get(),
                        isValidPassword.get());
            }
            enableButton();
        }


    };
    public TextWatcher emailIdWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if(isValidUsername.get() && isValidContactNo.get()){
                String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

                Pattern pattern = Pattern.compile(regex);

                if(TextUtils.isEmpty(emailId.get())){
                    toastMessage.set("Email Id is Required");
                    isValidEmailId.set(false);}
                if (!pattern.matcher(emailId.get()).matches()){
                    toastMessage.set("EmailId is not Valid");
                    isValidEmailId.set(false);}
                else
                    isValidEmailId.set(true);

            }
            else{
                emailId.set("");
                displayToastMessage(isValidUsername.get(),
                        isValidContactNo.get(),
                        isValidEmailId.get(),
                        isValidGender.get(),
                        isValidFordEmp.get(),
                        isValidCountry.get(),
                        isValidPassword.get());
            }
            enableButton();
        }
    };
    public void genderValidation(String value){

        gender.set(value);
        if(isValidUsername.get() && isValidContactNo.get() && isValidEmailId.get() ) {
            if (!TextUtils.isEmpty(gender.get())) {
                isValidGender.set(true);
            }

        }
        else {
            System.out.println("gender checkkkk");
            gender.set("");
            isValidGender.set(false);
            displayToastMessage(isValidUsername.get(),
                    isValidContactNo.get(),
                    isValidEmailId.get(),
                    isValidGender.get(),
                    isValidFordEmp.get(),
                    isValidCountry.get(),
                    isValidPassword.get());

        }
        enableButton();
    }
    public void spinnerValidation(AdapterView parent,View view,int pos,long id){
        country.set((String) parent.getSelectedItem());
        if(isValidUsername.get() && isValidContactNo.get() && isValidEmailId.get() &&  isValidGender.get()){
            System.out.println("previous validation are success");
            if(!parent.getSelectedItem().equals("select")) {
                isValidCountry.set(true);
            }
        }
        else{
            parent.setSelection(0);
            isValidCountry.set(false);
            displayToastMessage(isValidUsername.get(),
                    isValidContactNo.get(),
                    isValidEmailId.get(),
                    isValidGender.get(),
                    isValidFordEmp.get(),
                    isValidCountry.get(),
                    isValidPassword.get());

        }
        enableButton();

    }

    public void passwordClick(View view, String name){
         if(isValidUsername.get() && isValidContactNo.get() && isValidEmailId.get() &&  isValidGender.get()&& isValidPassword.get() && isValidCountry.get()){
            if(password.get().equals(confPassword.get())){
                isValidConfPassword.set(true);
            }


        }
       else if(  (!TextUtils.isEmpty(password.get())) && !password.get().equals(confPassword.get())){
           toastMessage.set("Confirm Password not matched with Password");
           isValidConfPassword.set(false);
            confPassword.set("");
           displayToastMessage(isValidUsername.get(),
                   isValidContactNo.get(),
                   isValidEmailId.get(),
                   isValidGender.get(),
                   isValidFordEmp.get(),
                   isValidCountry.get(),
                   isValidPassword.get());
       }
       else{
           confPassword.set("");
            isValidConfPassword.set(false);
            displayToastMessage(isValidUsername.get(),
                    isValidContactNo.get(),
                    isValidEmailId.get(),
                    isValidGender.get(),
                    isValidFordEmp.get(),
                    isValidCountry.get(),
                    isValidPassword.get());
        }
       enableButton();
    }

    public void displayToastMessage(Boolean validUsername,
                                    Boolean validContactNo,
                                    Boolean validEmailId,
                                    Boolean validGender,
                                    Boolean validFordEmp,
                                    Boolean validCountry,
                                    Boolean validPassword){

        System.out.println(isValidUsername.get() +"  "+ isValidContactNo.get()+"  "+ isValidEmailId.get()
                +"  "+ isValidGender.get() +"  "+ isValidCountry.get() +"  "+ isValidPassword.get());

        if(!isValidUsername.get()){
           isValidUsername.set(false);
            toastMessage.set("UserName is Required");
           }
        else if(!isValidContactNo.get()){
            isValidCountry.set(false);
            toastMessage.set("ContactNo is Required");
        }
        else if(!isValidEmailId.get()){
            isValidEmailId.set(false);
            toastMessage.set("EmailId is Required");
            System.out.println(toastMessage.get());
        }
        else if(!isValidGender.get()){
            isValidGender.set(false);
            toastMessage.set("Gender is Required");
        }
        else if(!isValidCountry.get()){
            isValidCountry.set(false);
            toastMessage.set("Country is Required");}
        else if(!isValidPassword.get()){
           isValidPassword.set(false);
            toastMessage.set("Password is Required");}

    }

    public void enableButton(){
       /* System.out.println(isValidUsername.get() +"  "+ isValidEmailId.get() +"  "+ isValidContactNo.get()
                +"  "+ isValidGender.get() +"  "+ isValidCountry.get() +"  "+ isValidPassword.get());*/
        if(isValidUsername.get() && isValidEmailId.get() && isValidContactNo.get()
            && isValidGender.get() && isValidCountry.get() && isValidPassword.get()){
            buttonEnabled.set(true);
        }
        else
            buttonEnabled.set(false);
    }
}
