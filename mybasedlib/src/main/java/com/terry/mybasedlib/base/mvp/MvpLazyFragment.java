package com.terry.mybasedlib.base.mvp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terry.mybasedlib.base.BaseLazyFragment;


public abstract class MvpLazyFragment<IV extends BaseView, P extends BasePresenter<IV>>
        extends BaseLazyFragment implements BaseView {
    public P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mPresenter == null) {
            mPresenter = createPresenter();
            mPresenter.attachView((IV) this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    @Override
    @NonNull
    public abstract P createPresenter();
}