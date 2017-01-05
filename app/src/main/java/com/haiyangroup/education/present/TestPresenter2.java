package com.haiyangroup.education.present;


import android.util.Log;

import com.haiyangroup.education.common.BasePresenter;
import com.haiyangroup.education.common.EndObserver;
import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.data.AbsService;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.view.TestView;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class TestPresenter2 extends BasePresenter<TestView> {
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
