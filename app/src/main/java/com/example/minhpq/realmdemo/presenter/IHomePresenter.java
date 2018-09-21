package com.example.minhpq.realmdemo.presenter;

import com.example.minhpq.realmdemo.api.APIinterface;
import com.example.minhpq.realmdemo.model.User;
import com.example.minhpq.realmdemo.view.HomeView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by minhpq on 4/20/2018.
 */

public interface IHomePresenter {
    void getListUser();
    void onSucess();
    void onError();
    void onStopSub();
}
