package com.example.form;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class SuccessResponse {
    @Inject
    public SuccessResponse() {

    }
@Provides
    public boolean successMessage(){
        return true;
    }
}
