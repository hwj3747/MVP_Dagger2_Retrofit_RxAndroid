package com.hwj3747.test.common;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterFactory;

import com.hwj3747.test.data.AbsService;
import com.hwj3747.test.present.TestPresenter;
import com.hwj3747.test.present.TestPresenter2;

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
        return AbsService.getInstance();
    }

    @Provides
    public AbsService.AbsApi provideAbsApi() {
        return AbsService.getService();
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
