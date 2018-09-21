package com.example.minhpq.realmdemo.presenter;

import com.example.minhpq.realmdemo.api.APIinterface;
import com.example.minhpq.realmdemo.model.UserDetail;
import com.example.minhpq.realmdemo.view.DetailView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by minhpq on 4/20/2018.
 */

public interface IDetailPresenter {
    void ShowDetailUser(String login);
    void onStopSub();
}
