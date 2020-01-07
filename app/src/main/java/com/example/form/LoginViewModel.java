package com.example.form;

import com.ford.responsebuilder.DaggerResponseBuilderComponent;
import com.ford.responsebuilder.FailureResponse;
import com.ford.responsebuilder.ResponseBuilder;
import com.ford.responsebuilder.ResponseBuilderComponent;
import com.ford.responsebuilder.SuccessResponse;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public ObservableField<String> username = new ObservableField<String>();
    public ObservableField<String> password = new ObservableField<String>();


    public boolean loginValidation() {
        ResponseBuilderComponent responseBuilderComponent = DaggerResponseBuilderComponent.builder().responseBuilder(new ResponseBuilder())
                .build();

        if("admin".equals(username.get()) && "admin".equals(password.get())) {

            SuccessResponse successResponse=responseBuilderComponent.getSuccessResponse();
            return successResponse.successMessage();

        }
        else{
            FailureResponse failureResponse= responseBuilderComponent.getFailureResponse();
           return failureResponse.FailureMessage();

        }

      //  return responseBuilderComponent.getResponseBuilder().validate(username.get(), password.get());

    }

}
