package com.hwj3747.test.present;


import android.util.Log;

import com.hwj3747.test.common.BasePresenter;
import com.hwj3747.test.common.EndObserver;
import com.hwj3747.test.common.SchedulerProvider;
import com.hwj3747.test.data.AbsReturn;
import com.hwj3747.test.data.AbsService;
import com.hwj3747.test.entity.TestEntity;
import com.hwj3747.test.view.TestView;

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

    public void test(String key){
        mAbsService.getApi().getBaidu(key).compose(mSchedulerProvider.applySchedulers()).subscribe(v->{getView().show(v);});
    }

    private Observer<AbsReturn<TestEntity>> TestObserver = new EndObserver<AbsReturn<TestEntity>>() {
        @Override
        public void onEnd() {

        }
        @Override
        public void onMyNext(AbsReturn<TestEntity> entity) {
            Log.i("log", entity.getData().getName());
//            getView().show(entity);
        }

        @Override
        public void onMyError() {
        }
    };
}
