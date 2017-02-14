package com.andy.mvp.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.TextView;

import com.andy.entity.Home;
import com.andy.mvp.BaseActivity;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private TextView mHome;
    private TextView mPhoto;
    private TextView mAboutMe;
    private TextView mArticleList;

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
        mArticleList = (TextView) findViewById(R.id.articleList);

        Home home = Home.getInstance();
        mHome.setText(home.getHome().getTitle());
        mPhoto.setText(home.getPhoto().getTitle());
        mAboutMe.setText(home.getAboutMe().getTitle());
        mArticleList.setText(home.getArticleList().getTitle());
    }
}
