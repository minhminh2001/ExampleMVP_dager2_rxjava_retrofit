package com.example.minhpq.realmdemo.api;

import com.example.minhpq.realmdemo.model.User;
import com.example.minhpq.realmdemo.model.UserDetail;

import java.util.List;

import retrofit2.http.Path;
import rx.Observable;
import retrofit2.http.GET;

/**
 * Created by minhpq on 4/20/2018.
 */

public interface APIinterface {
    @GET("/users")
    Observable<List<User>> getListUser();
    @GET("/users/{login}")
    Observable<UserDetail> getUserDetail(@Path("login") String login);
}
