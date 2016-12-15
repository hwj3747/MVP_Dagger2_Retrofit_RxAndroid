package com.haiyangroup.education.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.haiyangroup.education.common.App;
import com.haiyangroup.library.absBase.AbsBaseActivity;
import com.haiyangroup.library.absBase.AbsBaseFragment;
import com.haiyangroup.library.utils.SharedPreferencesUtil;

import javax.inject.Inject;

/**
 * 根据应用自定义功能
 *
 * @author limj
 */
public abstract class BaseActivity extends AbsBaseActivity {
    @Inject
    @Nullable
    protected LayoutInflaterFactory layoutInflaterHook;
    private AbsBaseFragment mActiveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //App.getAppComponent(this).inject(this);

        if (layoutInflaterHook != null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            LayoutInflaterCompat.setFactory(layoutInflater, layoutInflaterHook);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onRestoreData(Bundle savedInstanceState) {
                mActiveFragment = (AbsBaseFragment) getSupportFragmentManager().getFragment(
                savedInstanceState, AbsBaseFragment.class.getName());

    }

    @Override
    protected void onPrepareData() {

    }

    @Override
    protected void onSaveData(Bundle outState) {
        getSupportFragmentManager()
                .putFragment(outState, AbsBaseFragment.class.getName(), mActiveFragment);

    }

    public void showContent(AbsBaseFragment fragment,int id) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();

        if (!fragment.isAdded()) {
            ft.add(id, fragment);
            if (null != mActiveFragment) {
                ft.hide(mActiveFragment);
            }
        } else {
            ft.hide(getActiveFragment()).show(fragment);
        }
        ft.commitAllowingStateLoss();
        mActiveFragment = fragment;
        SharedPreferencesUtil.getInstance(this).putInt("mActiveFragment", mActiveFragment.getId());
    }

    public AbsBaseFragment getActiveFragment() {
        if (null == mActiveFragment) {
            int id = SharedPreferencesUtil.getInstance(this).getInt("mActiveFragment", -1);
            mActiveFragment = (AbsBaseFragment) mFragmentManager.findFragmentById(id);
        }
        return mActiveFragment;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(null != this.getCurrentFocus()){
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super .onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
