package com.hwj3747.test.present;


import android.util.Log;

import com.hwj3747.test.common.BasePresenter;
import com.hwj3747.test.common.EndObserver;
import com.hwj3747.test.common.SchedulerProvider;
import com.hwj3747.test.data.AbsReturn;
import com.hwj3747.test.data.AbsService;
import com.hwj3747.test.entity.TestEntity;
import com.hwj3747.test.entity.jsonOut;
import com.hwj3747.test.view.TestView;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class TestPresenter extends BasePresenter<TestView> {
    AbsService mAbsService;
    SchedulerProvider mSchedulerProvider;

    @Inject
    public TestPresenter(AbsService absService,SchedulerProvider schedulerProvider) {
        this.mAbsService=absService;
        this.mSchedulerProvider=schedulerProvider;
    }

    private Subscription mTestSubscription= Subscriptions.empty();

    public void test(String key){
//        mAbsService.getApi().getBaidu(key).compose(mSchedulerProvider.applySchedulers()).subscribe(TestObserver);
        mAbsService.getApi().getBaidu(key).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<jsonOut>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(jsonOut jsonOut) {
                getView().show(jsonOut);
            }
        });
    }

    private Observer<jsonOut> TestObserver = new EndObserver<jsonOut>() {
        @Override
        public void onEnd() {

        }
        @Override
        public void onMyNext(jsonOut entity) {
            getView().show(entity);
        }

        @Override
        public void onMyError() {
        }
    };
}
