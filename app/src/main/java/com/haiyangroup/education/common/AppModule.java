package com.haiyangroup.education.common;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterFactory;

import com.haiyangroup.education.data.AbsService;
import com.haiyangroup.education.present.TestPresenter;
import com.haiyangroup.education.present.TestPresenter2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    public SchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.DEFAULT;
    }

    @Provides
    public AbsService provideApi() {
        AbsService mService = new AbsService();
        return mService;
    }

    @Provides
    public TestPresenter providePresenter(AbsService absService,SchedulerProvider schedulerProvider) {
        return new TestPresenter(absService,schedulerProvider);
    }

    @Provides
    public TestPresenter2 providePresenter2(AbsService absService) {
        return new TestPresenter2(absService);
    }

    @Provides
    @Nullable
    public LayoutInflaterFactory provideLayoutInflaterFactory() {
        return null;
    }
}
