package com.haiyangroup.education.ui.test2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.haiyangroup.education.R;
import com.haiyangroup.education.base.BaseActivity;

public class TestActivity2 extends BaseActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, TestActivity2.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_test;
    }

    @Override
    protected void onInitTitle() {
        mAppBar.removeAllViews();
        mAppBar.initTitle(this);
        mAppBar.setTitleText("门户APP");
    }

    @Override
    protected void onResolveIntent(Intent intent) {

    }

    @Override
    protected void onInitFragment() {
        showContent(new TestActivityFragment2(),R.id.Layout);
    }

}
