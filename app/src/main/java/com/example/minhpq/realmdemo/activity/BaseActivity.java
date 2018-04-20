package com.example.minhpq.realmdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.minhpq.realmdemo.api.APIinterface;
import com.example.minhpq.realmdemo.aplication.UserApplication;

import javax.inject.Inject;

/**
 * Created by minhpq on 4/20/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    APIinterface apIinterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ((UserApplication) getApplication()).getUserComponent().inject(this);

    }

    public abstract int getLayoutId();

}