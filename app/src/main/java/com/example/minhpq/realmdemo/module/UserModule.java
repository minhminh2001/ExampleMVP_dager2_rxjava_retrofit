package com.example.minhpq.realmdemo.module;

import android.app.Application;

import com.example.minhpq.realmdemo.api.APIinterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by minhpq on 4/20/2018.
 */
@Module
public class UserModule {
    public static final String URL = "https://api.github.com";

    @Provides
    @Singleton
    public Retrofit providerRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    public APIinterface providerApiService(Retrofit retrofit) {
        return retrofit.create(APIinterface.class);
    }
}
