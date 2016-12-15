package com.haiyangroup.education.present;


import android.util.Log;

import com.haiyangroup.education.common.EndObserver;
import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.data.AbsService;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.view.TestView;

import javax.inject.Inject;

import compartment.BasePresenter;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTestSubscription != null && !mTestSubscription.isUnsubscribed()) {
            mTestSubscription.unsubscribe();
        }

    }


    public void test(){
        mAbsService.test().subscribe(TestObserver);
    }

    private Observer<AbsReturn<TestEntity>> TestObserver = new EndObserver<AbsReturn<TestEntity>>() {
        @Override
        public void onEnd() {
            if (getBaseView() != null) {
                getBaseView().hideLoading();
            }
        }
        @Override
        public void onMyNext(AbsReturn<TestEntity> entity) {
            Log.i("log2",entity.getData().getName());
            getBaseView().hideLoading();
        }
        @Override
        public void onMyError() {
            getBaseView().hideLoading();
        }
    };
}
