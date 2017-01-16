package com.hwj3747.test.present;


import android.util.Log;

import com.hwj3747.test.common.BasePresenter;
import com.hwj3747.test.common.EndObserver;
import com.hwj3747.test.data.AbsReturn;
import com.hwj3747.test.data.AbsService;
import com.hwj3747.test.entity.TestEntity;
import com.hwj3747.test.view.TestView;
import com.hwj3747.test.view.TestView2;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class TestPresenter2 extends BasePresenter<TestView2> {
    AbsService mAbsService;

    @Inject
    public TestPresenter2(AbsService absService) {
        this.mAbsService=absService;
    }

    private Subscription mTestSubscription= Subscriptions.empty();


    public void test(){
        mAbsService.test().subscribe(TestObserver);
    }

    private Observer<AbsReturn<TestEntity>> TestObserver = new EndObserver<AbsReturn<TestEntity>>() {
        @Override
        public void onEnd() {

        }
        @Override
        public void onMyNext(AbsReturn<TestEntity> entity) {
            getView().show(entity);
            Log.i("log2",entity.getData().getName());
        }
        @Override
        public void onMyError() {
        }
    };
}
