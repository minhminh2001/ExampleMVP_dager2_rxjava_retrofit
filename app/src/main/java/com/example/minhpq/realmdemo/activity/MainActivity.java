package com.example.minhpq.realmdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.minhpq.realmdemo.api.APIinterface;
import com.example.minhpq.realmdemo.aplication.UserApplication;
import com.example.minhpq.realmdemo.model.User;
import com.example.minhpq.realmdemo.interfaces.OnItemlick;
import com.example.minhpq.realmdemo.presenter.HomePresenter;
import com.example.minhpq.realmdemo.R;
import com.example.minhpq.realmdemo.adapter.ListUserAdapter;
import com.example.minhpq.realmdemo.view.HomeView;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements HomeView {
    private ListUserAdapter listUserAdapter;
    private RecyclerView rv_userl;
    private HomePresenter homePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv_userl = (RecyclerView) findViewById(R.id.rv_user);
        homePresenter = new HomePresenter(this, apIinterface);
        homePresenter.getListUser();
        homePresenter.onSucess();
        homePresenter.onError();
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
        homePresenter.onStopSub();
    }
}
