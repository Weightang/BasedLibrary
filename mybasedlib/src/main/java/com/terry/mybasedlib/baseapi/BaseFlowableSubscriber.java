package com.terry.mybasedlib.baseapi;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;

/**
 * Created by tang on 2017/6/12.
 */

public abstract class BaseFlowableSubscriber<T> implements FlowableSubscriber<T> {
    public abstract void onSuccess(T t);

    public abstract void onFail(ExceptionHandle.ResponeThrowable e);

    public abstract void onFinished();

    @Override
    public void onSubscribe(@NonNull Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        onFail(ExceptionHandle.handleException(t));
    }

    @Override
    public void onComplete() {
        onFinished();
    }
}
