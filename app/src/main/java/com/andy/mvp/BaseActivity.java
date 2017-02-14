package com.andy.mvp;

import android.app.Activity;
import android.os.Bundle;

/**
 * 项目的基础Activity
 * <p>
 * Created by andy on 17-2-14.
 */

public abstract class BaseActivity extends Activity {

    protected abstract void findView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findView();
    }
}
