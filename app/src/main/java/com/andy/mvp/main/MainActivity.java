package com.andy.mvp.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.TextView;

import com.andy.entity.Home;
import com.andy.mvp.BaseActivity;
import com.andy.view.CircleImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private TextView mHome; //TODO：首页模块放目录
    private TextView mPhoto;
    private TextView mAboutMe;
    private CircleImageView mCircleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void findView() {
        setContentView(R.layout.activity_main);

        mHome = (TextView) findViewById(R.id.home);
        mPhoto = (TextView) findViewById(R.id.photo);
        mAboutMe = (TextView) findViewById(R.id.aboutMe);
        mCircleView = (CircleImageView) findViewById(R.id.headView);

        Home home = Home.getInstance();
        mHome.setText(home.getArticleList().getTitle());
        mPhoto.setText(home.getPhoto().getTitle());
        mAboutMe.setText(home.getAboutMe().getTitle());
        Glide.with(this).load(home.getHeadPhotoUrl()).asBitmap().into(mCircleView);
    }
}
