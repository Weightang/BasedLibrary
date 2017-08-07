package com.terry.mybasedlib.base.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.terry.mybasedlib.base.BaseActivity;


public abstract class MvpActivity<IV extends BaseView, P extends BasePresenter<IV>>
        extends BaseActivity implements BaseView {

    public P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (mPresenter == null) {
            mPresenter = createPresenter();
            mPresenter.attachView((IV) this);
        }
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @NonNull
    @Override
    public abstract P createPresenter();
}