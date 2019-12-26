package com.example.form;

import javax.inject.Inject;

public class ResponseBuilder {
    private SuccessResponse successResponse;
    private FailureResponse failureResponse;
@Inject
    public ResponseBuilder(SuccessResponse successResponse, FailureResponse failureResponse) {
        this.successResponse = successResponse;
        this.failureResponse = failureResponse;
    }
    ResponseBuilderComponent responseBuilderComponent= DaggerResponseBuilderComponent.create();

        public boolean validate(String username, String password){
            if("admin".equals(username) && "admin".equals(password)) {

                SuccessResponse successResponse=responseBuilderComponent.getSuccessResponse();
                System.out.println("success response");
               return successResponse.successMessage();

            }
            else{
               FailureResponse failureResponse= responseBuilderComponent.getFailureResponse();
                System.out.println("failure response");
               return failureResponse.FailureMessage();

            }
        }
}
