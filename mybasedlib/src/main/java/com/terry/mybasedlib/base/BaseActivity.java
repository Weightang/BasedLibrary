package com.terry.mybasedlib.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.terry.mybasedlib.utils.AppManager;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            AppManager.getAppManager().addActivity(this);
        }
        before();
        setContentView(getLayoutId());
        if (savedInstanceState == null) {
            ButterKnife.bind(this);
            init();
        }
    }

    public abstract int getLayoutId();


    public void init() {
        initView();
        initData();
    }

    public abstract void before();

    public abstract void initView();

    public abstract void initData();


    @Override
    public void onBackPressed() {
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        App.getInstance().getRefWatcher().watch(this);
    }
}
