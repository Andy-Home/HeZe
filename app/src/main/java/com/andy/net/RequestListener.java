package com.andy.net;

import com.andy.entity.Response;

import java.util.Objects;

/**
 * 命令请求的回调接口
 * <p>
 * Created by andy on 17-2-14.
 */

public interface RequestListener {

    void onSuccess(Response response);

    void onFailure(Response response);
}
