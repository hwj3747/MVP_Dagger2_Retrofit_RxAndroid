package com.haiyangroup.education.ui.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.haiyangroup.education.R;
import com.haiyangroup.education.base.BaseActivity;
import com.haiyangroup.education.common.App;

public class TestActivity extends BaseActivity {
    public static TestActivity instance;
    TestActivityFragment testActivityFragment=new TestActivityFragment();

    public static void launch(Context context) {
        Intent intent = new Intent(context, TestActivity.class);
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
        App.getInstance().addActivity(TestActivity.this);
        instance=TestActivity.this;
        mAppBar.setVisibility(View.GONE);
        mAppBar.removeAllViews();
        mAppBar.initTitle(this);
        mAppBar.setTitleText("实训平台");
    }

    @Override
    protected void onResolveIntent(Intent intent) {

    }

    @Override
    protected void onInitFragment() {
        showContent(testActivityFragment,R.id.Layout);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            testActivityFragment.back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
