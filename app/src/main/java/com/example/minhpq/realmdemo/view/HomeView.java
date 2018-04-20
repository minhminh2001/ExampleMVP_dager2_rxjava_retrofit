package com.example.minhpq.realmdemo.view;

import com.example.minhpq.realmdemo.model.User;

import java.util.List;

/**
 * Created by minhpq on 4/20/2018.
 */

public interface HomeView {
    void showListUser(List<User> userList);
    void showSuccess();
    void showNetworkError();
}
