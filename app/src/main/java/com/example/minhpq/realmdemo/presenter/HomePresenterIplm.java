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

public class HomePresenterIplm implements IHomePresenter {
    private HomeView homeView;
    private APIinterface apIinterface;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();


    public HomePresenterIplm(HomeView homeView, APIinterface apIinterface) {
        this.homeView = homeView;
        this.apIinterface = apIinterface;
    }

    @Override
    public void getListUser() {
        Subscription subscription = apIinterface.getListUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<User> userList) {
                        homeView.showListUser(userList);
                    }
                });

        compositeSubscription.add(subscription);
    }

    @Override
    public void onSucess() {
        homeView.showSuccess();
    }

    @Override
    public void onError() {
        homeView.showNetworkError();
    }

    @Override
    public void onStopSub() {
        compositeSubscription.unsubscribe();
    }
}
