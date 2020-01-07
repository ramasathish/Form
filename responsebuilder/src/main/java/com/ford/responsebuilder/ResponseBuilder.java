package com.ford.responsebuilder;

import dagger.Module;
import dagger.Provides;

@Module
public class ResponseBuilder {
    private SuccessResponse successResponse;
    private FailureResponse failureResponse;

    /*
@Inject
    public ResponseBuilder(SuccessResponse successResponse, FailureResponse failureResponse) {
        this.successResponse = successResponse;
        this.failureResponse = failureResponse;
    }

     */
    public ResponseBuilder(SuccessResponse successResponse, FailureResponse failureResponse) {
        this.successResponse = successResponse;
        this.failureResponse = failureResponse;
    }
    public ResponseBuilder() {
        this.successResponse = successResponse;
        this.failureResponse = failureResponse;
    }
    @Provides
    public SuccessResponse provideSuccessResponse(){
    return new SuccessResponse();
    }
    @Provides
    public FailureResponse provideFailureResponse(){
    return new FailureResponse();
    }

    @Provides
    public ResponseBuilder provideResponseBuilder(SuccessResponse successResponse,FailureResponse failureResponse){
        return new ResponseBuilder(successResponse,failureResponse);

    }

/*    ResponseBuilderComponent responseBuilderComponent= DaggerResponseBuilderComponent.builder().responseBuilder(new ResponseBuilder(successResponse,failureResponse)).build();


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

 */
}
