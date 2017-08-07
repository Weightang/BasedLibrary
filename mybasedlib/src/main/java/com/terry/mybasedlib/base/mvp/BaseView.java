package com.terry.mybasedlib.base.mvp;

import android.support.annotation.NonNull;

import com.terry.mybasedlib.baseapi.ExceptionHandle;


public interface BaseView {
    @NonNull
    BasePresenter createPresenter();

    void onFail(ExceptionHandle.ResponeThrowable e);

    void onFinish();
}