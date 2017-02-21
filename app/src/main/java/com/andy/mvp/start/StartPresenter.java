package com.andy.mvp.start;

import com.andy.entity.Response;
import com.andy.net.HomeRequest;
import com.andy.net.Request;
import com.andy.net.RequestListener;

class StartPresenter implements StartContract.Presenter {
    private Request mRequest = new Request();

    @Override
    public void requestHomeData(final StartContract.View v) {
        HomeRequest mHomeRequest = new HomeRequest(new RequestListener() {
            @Override
            public void onSuccess(Response response) {
                v.requestHomeDataSuccess(response);
            }

            @Override
            public void onFailure(Response response) {
                v.requestHomeDataFailure(response);
            }
        });

        mRequest.setCommand(mHomeRequest)
                .execute();
    }
}
