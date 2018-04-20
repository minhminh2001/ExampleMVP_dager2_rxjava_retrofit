package com.example.minhpq.realmdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minhpq.realmdemo.api.APIinterface;
import com.example.minhpq.realmdemo.aplication.UserApplication;
import com.example.minhpq.realmdemo.model.UserDetail;
import com.example.minhpq.realmdemo.presenter.DetailPresenter;
import com.example.minhpq.realmdemo.R;
import com.example.minhpq.realmdemo.view.DetailView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by minhpq on 4/20/2018.
 */

public class DetailActivity extends BaseActivity implements DetailView {
    private DetailPresenter detailPresenter;
    private ImageView imgAvatar;
    private TextView tvName2, tvCompany, tvLocation, tvBlog, tvEmail, tvFollower, tvFollowing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailPresenter = new DetailPresenter(this, apIinterface);
        String login = getIntent().getExtras().getString("login");
        detailPresenter.ShowDetailUser(login);
        imgAvatar = (ImageView) findViewById(R.id.img_avatar);
        tvName2 = (TextView) findViewById(R.id.tv_name2);
        tvCompany = (TextView) findViewById(R.id.tv_company);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        tvBlog = (TextView) findViewById(R.id.tv_blog);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvFollower = (TextView) findViewById(R.id.tv_followers);
        tvFollowing = (TextView) findViewById(R.id.tv_following);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_user;
    }


    @Override
    public void ShowUserDetail(UserDetail userDetail) {
        Picasso.with(this).load(userDetail.getAvatar_url())
                .into(imgAvatar);
        tvName2.setText(userDetail.getName());
        tvCompany.setText(userDetail.getCompany());
        tvLocation.setText(userDetail.getLocation());
        tvBlog.setText(userDetail.getBlog());
        tvEmail.setText(userDetail.getEmail());
        tvFollower.setText(String.valueOf(userDetail.getFollowers()));
        tvFollowing.setText(String.valueOf(userDetail.getFollowing()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailPresenter.onStopSub();
    }
}
