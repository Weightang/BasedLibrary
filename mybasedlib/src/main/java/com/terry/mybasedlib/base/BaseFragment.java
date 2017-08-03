package com.terry.mybasedlib.base;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jp.index.App;
import com.jp.index.api.OkGoClient;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zhangwei on 16/10/21.
 */

public abstract class BaseFragment extends Fragment  {
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    private Unbinder bind;
    public EventBus eventBus = EventBus.getDefault();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
//        EventBus.getDefault().register(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        bind = ButterKnife.bind(this, view);
        before();
        initView();
        initData();
    }


    public void before() {
    }

    public abstract void initView();

    public abstract void initData();

    public abstract int getLayoutId();



    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGoClient.cancel(this);
        App.fixInputMethodManagerLeak(getContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            App.fixFocusedViewLeak(getActivity().getApplication());
        }

        //内存泄露检测
//        App.getInstance().getRefWatcher().watch(this);
//        EventBus.getDefault().unregister(this);
        if (bind != null) {
            bind.unbind();
        }
    }


}