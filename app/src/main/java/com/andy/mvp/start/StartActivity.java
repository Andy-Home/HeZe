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

public class StartActivity extends BaseActivity {

    private Request request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        request = new Request(new HomeRequest(new RequestListener() {
            @Override
            public void onSuccess(Response response) {
                if (response.isSuccess()) {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure() {

            }
        }));
    }

    @Override
    protected void findView() {
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onResume() {
        super.onResume();
        request.execute();
    }
}
