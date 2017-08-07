package com.terry.mybasedlib.base.mvp;

import android.support.annotation.UiThread;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by zhangwei on 16/10/21.
 */

public abstract class BasePresenter<IV extends BaseView> {
    Reference<IV> mViewRef;//View接口类型的弱引用
    //    CompletableOnSubscribe mCompositeSubscription;
    CompositeDisposable mCompositeDisposable;

    private IV view;
    private IV iv;

    @UiThread
    public void attachView(IV v) {
        mViewRef = new WeakReference<>(v);
        this.view = v;
    }

    public IV getView() {
        if (mViewRef != null) {
            iv = mViewRef.get();
        } else {
            mViewRef = new WeakReference<>(view);
            iv = mViewRef.get();
        }
        return iv;
    }

    public boolean isAttchView() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @UiThread
    public void detachView() {
//        onUnsubscribe();
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }


    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe(Disposable disposable) {
        if (mCompositeDisposable != null && mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.remove(disposable);
        }
    }

    //RXjava注册
    public void addSubscription(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}