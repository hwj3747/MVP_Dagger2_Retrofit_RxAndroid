package com.haiyangroup.education.ui.test2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.haiyangroup.education.R;
import com.haiyangroup.education.common.App;
import com.haiyangroup.education.common.AppComponent;
import com.haiyangroup.education.common.AppModule;
import com.haiyangroup.education.common.ComponentHolder;
import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.present.TestPresenter;
import com.haiyangroup.education.present.TestPresenter2;
import com.haiyangroup.education.view.TestView;
import com.haiyangroup.library.absBase.AbsBaseFragment;
import com.haiyangroup.library.utils.SharedPreferencesUtil;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import icepick.Icepick;
import icepick.State;

/**
 * A placeholder fragment containing a simple view.
 */
public class TestActivityFragment2 extends AbsBaseFragment implements TestView {

    @Inject
    TestPresenter presenter;

    @Inject
    TestPresenter2 presenter2;

    @State
    String mCodeData;



    public TestActivityFragment2() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        ComponentHolder.getAppComponent().inject(this);

        presenter.bindView(this);
        presenter.bindBaseView(this);

        presenter2.bindView(this);
        presenter2.bindBaseView(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_test;
    }

    @Override
    protected View getLoadingTargetView() {
        return findById(R.id.test);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
    }


    @Override
    protected void onViewInit() {
        presenter.test();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save state of all @State annotated members
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void show(AbsReturn<TestEntity> test) {

    }
}
