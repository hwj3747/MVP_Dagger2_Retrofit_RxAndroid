package com.haiyangroup.education.present;


import android.util.Log;

import com.haiyangroup.education.common.EndObserver;
import com.haiyangroup.education.common.MyScope;
import com.haiyangroup.education.common.SchedulerProvider;
import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.data.AbsService;
import com.haiyangroup.education.data.DefaultData;
import com.haiyangroup.education.data.DefaultObj;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.view.TestView;
import com.haiyangroup.library.utils.SharedPreferencesUtil;

import javax.inject.Inject;

import compartment.BasePresenter;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTestSubscription != null && !mTestSubscription.isUnsubscribed()) {
            mTestSubscription.unsubscribe();
        }

    }


    public void test(){
        getBaseView().showLoading("");
        mAbsService.getApi().test1().compose(mSchedulerProvider.applySchedulers()).subscribe();
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
            Log.i("log",entity.getData().getName());
            getView().show(entity);
            getBaseView().hideLoading();
        }

        @Override
        public void onMyError() {
            getBaseView().hideLoading();
        }
    };
}
