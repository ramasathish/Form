package com.ford.responsebuilder;

import dagger.Component;

@Component(modules = ResponseBuilder.class)
public interface ResponseBuilderComponent {
    ResponseBuilder getResponseBuilder();
    SuccessResponse getSuccessResponse();
    FailureResponse getFailureResponse();

    void inject(ResponseBuilder responseBuilder);




}
