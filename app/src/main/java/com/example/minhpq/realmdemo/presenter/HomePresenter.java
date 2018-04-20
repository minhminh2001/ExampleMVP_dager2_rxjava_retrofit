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

public class HomePresenter {
    private HomeView homeView;
    private APIinterface apIinterface;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();


    public HomePresenter(HomeView homeView, APIinterface apIinterface) {
        this.homeView = homeView;
        this.apIinterface = apIinterface;
    }


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

    public void onSucess() {
        homeView.showSuccess();
    }


    public void onError() {
        homeView.showNetworkError();
    }

    public void onStopSub() {
        compositeSubscription.unsubscribe();
    }
}
