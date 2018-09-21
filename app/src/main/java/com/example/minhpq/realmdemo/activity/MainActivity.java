package com.example.minhpq.realmdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.minhpq.realmdemo.model.User;
import com.example.minhpq.realmdemo.interfaces.OnItemlick;
import com.example.minhpq.realmdemo.presenter.HomePresenterIplm;
import com.example.minhpq.realmdemo.presenter.IHomePresenter;
import com.example.minhpq.realmdemo.R;
import com.example.minhpq.realmdemo.adapter.ListUserAdapter;
import com.example.minhpq.realmdemo.view.HomeView;

import java.util.List;


public class MainActivity extends BaseActivity implements HomeView {
    private ListUserAdapter listUserAdapter;
    private RecyclerView rv_userl;
    private HomePresenterIplm homePresenterIplm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv_userl = (RecyclerView) findViewById(R.id.rv_user);
        homePresenterIplm = new HomePresenterIplm(this, apIinterface);
        homePresenterIplm.getListUser();
        homePresenterIplm.onSucess();
        homePresenterIplm.onError();
        rv_userl.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showListUser(final List<User> userList) {
        listUserAdapter = new ListUserAdapter(userList, this, new OnItemlick() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("login", userList.get(position).getLogin());
                startActivity(intent);
            }
        });
        rv_userl.setAdapter(listUserAdapter);
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenterIplm.onStopSub();
    }
}
