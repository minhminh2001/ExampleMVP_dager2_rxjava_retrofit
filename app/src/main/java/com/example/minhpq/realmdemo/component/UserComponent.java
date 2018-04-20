package com.example.minhpq.realmdemo.component;

import com.example.minhpq.realmdemo.activity.BaseActivity;
import com.example.minhpq.realmdemo.activity.DetailActivity;
import com.example.minhpq.realmdemo.activity.MainActivity;
import com.example.minhpq.realmdemo.module.UserModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by minhpq on 4/20/2018.
 */
@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {
    void inject(BaseActivity baseActivity);
}
