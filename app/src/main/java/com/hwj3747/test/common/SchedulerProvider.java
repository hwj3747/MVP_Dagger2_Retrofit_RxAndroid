package com.hwj3747.test.common;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public interface SchedulerProvider {
    <T> Observable.Transformer<T, T> applySchedulers();

    SchedulerProvider DEFAULT = new SchedulerProvider() {
        @Override public <T> Observable.Transformer<T, T> applySchedulers() {
            return observable -> observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
}
