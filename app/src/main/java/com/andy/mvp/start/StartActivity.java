package com.andy.mvp.start;

import android.content.Intent;
import android.os.Bundle;

import com.andy.entity.Response;
import com.andy.mvp.BaseActivity;
import com.andy.mvp.main.MainActivity;
import com.andy.mvp.main.R;
import com.andy.net.HomeRequest;
import com.andy.net.Request;
import com.andy.net.RequestListener;

/**
 * 起始页
 * <p>
 * Created by andy on 17-2-14.
 */

public class StartActivity extends BaseActivity implements StartContract.View {

    private StartContract.Presenter mPresenter = new StartPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.requestHomeData(this);
    }

    @Override
    protected void findView() {
        setContentView(R.layout.activity_start);
    }

    @Override
    public void requestHomeDataSuccess(Response response) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void requestHomeDataFailure(Response response) {

    }
}
