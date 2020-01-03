package com.example.form;

import dagger.Component;

@Component
public interface ResponseBuilderComponent {
    ResponseBuilder getResponseBuilder();
    SuccessResponse getSuccessResponse();
    FailureResponse getFailureResponse();


}
