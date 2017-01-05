package com.haiyangroup.education.present;


import android.util.Log;

import com.haiyangroup.education.common.BasePresenter;
import com.haiyangroup.education.common.EndObserver;
import com.haiyangroup.education.common.SchedulerProvider;
import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.data.AbsService;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.view.TestView;


import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
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

    public void test(){
        mAbsService.test().compose(mSchedulerProvider.applySchedulers()).subscribe(TestObserver);
    }

    private Observer<AbsReturn<TestEntity>> TestObserver = new EndObserver<AbsReturn<TestEntity>>() {
        @Override
        public void onEnd() {

        }
        @Override
        public void onMyNext(AbsReturn<TestEntity> entity) {
            Log.i("log", entity.getData().getName());
            getView().show(entity);
        }

        @Override
        public void onMyError() {
        }
    };
}
