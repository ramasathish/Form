package com.ford.responsebuilder;

import dagger.Component;

@Component
public interface ResponseBuilderComponent {
    ResponseBuilder getResponseBuilder();
    SuccessResponse getSuccessResponse();
    FailureResponse getFailureResponse();




}
