package com.example.minhpq.realmdemo.aplication;

import android.app.Application;

import com.example.minhpq.realmdemo.component.DaggerUserComponent;
import com.example.minhpq.realmdemo.component.UserComponent;
import com.example.minhpq.realmdemo.module.UserModule;

import dagger.Component;

/**
 * Created by minhpq on 4/20/2018.
 */

public class UserApplication extends Application {

    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        userComponent = DaggerUserComponent.builder().userModule(new UserModule()).build();
    }


    public UserComponent getUserComponent() {
        return userComponent;
    }
}
