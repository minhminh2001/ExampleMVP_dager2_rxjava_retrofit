package com.example.minhpq.realmdemo.presenter;

import com.example.minhpq.realmdemo.api.APIinterface;
import com.example.minhpq.realmdemo.model.UserDetail;
import com.example.minhpq.realmdemo.view.DetailView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class DetailPresenterIplm implements IDetailPresenter {
    private DetailView detailView;
    private APIinterface apIinterface;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();


    public DetailPresenterIplm(DetailView detailView, APIinterface apIinterface) {
        this.detailView = detailView;
        this.apIinterface = apIinterface;
    }

    @Override
    public void ShowDetailUser(String login) {
        Subscription subscription = apIinterface.getUserDetail(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserDetail userDetail) {
                        detailView.ShowUserDetail(userDetail);
                    }
                });

        compositeSubscription.add(subscription);
    }

    @Override
    public void onStopSub() {
        compositeSubscription.unsubscribe();
    }

}
