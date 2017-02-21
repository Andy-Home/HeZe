package com.andy.mvp.start;

import com.andy.entity.Response;

interface StartContract {
    interface View {
        void requestHomeDataSuccess(Response response);

        void requestHomeDataFailure(Response response);
    }

    interface Presenter {
        /**
         * 请求主页的数据，缓存至本地
         */
        void requestHomeData(View v);
    }
}
