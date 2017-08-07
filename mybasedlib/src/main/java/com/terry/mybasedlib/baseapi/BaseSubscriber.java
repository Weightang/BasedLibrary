package com.terry.mybasedlib.baseapi;


import io.reactivex.observers.DisposableObserver;

/**
 * Created by wj on 2016/10/27.
 */

public abstract class BaseSubscriber<T> extends DisposableObserver<T> {
    public abstract void onSuccess(T t);

    public abstract void onFail(ExceptionHandle.ResponeThrowable e);

    public abstract void onFinished();


    @Override
    public void onComplete() {
        onFinished();
    }

    @Override
    public void onError(Throwable e) {
        onFail(ExceptionHandle.handleException(e));
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }
}
