package com.haiyangroup.education.ui.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.haiyangroup.education.R;
import com.haiyangroup.education.common.App;
import com.haiyangroup.education.common.AppComponent;
import com.haiyangroup.education.common.AppModule;
import com.haiyangroup.education.common.ComponentHolder;
import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.present.TestPresenter;
import com.haiyangroup.education.present.TestPresenter2;
import com.haiyangroup.education.ui.test2.TestActivity2;
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
public class TestActivityFragment extends AbsBaseFragment{

    @InjectView(R.id.webView)
    WebView wv;
    @InjectView(R.id.loading_progress)
    ProgressBar loadingProgress;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
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
        WebSettings settings = wv.getSettings();
        settings.setDomStorageEnabled(true);

        wv.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        wv.getSettings().setSupportZoom(true);
// 设置出现缩放工具
        wv.getSettings().setBuiltInZoomControls(true);
//扩大比例的缩放
        wv.getSettings().setUseWideViewPort(true);
//自适应屏幕
        wv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv.getSettings().setLoadWithOverviewMode(true);

        wv.loadUrl("http://10.0.0.253:8080/sxpt/wapurl/login.html");
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                TestActivity.instance.setTitle(view.getTitle());
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        wv.setWebChromeClient(new WebChromeClient() {


            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.d("ANDROID_LAB", "TITLE=" + title);
                TestActivity.instance.setTitle(title);
            }
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                loadingProgress.setVisibility(View.VISIBLE);
                loadingProgress.setProgress(newProgress);
//                if (newProgress == 100) {
//                    MainActivity.this.setTitle("加载完成");
//                } else {
//                    MainActivity.this.setTitle("加载中.......");
//
//                }
                if(newProgress == 100)
                    loadingProgress.setVisibility(View.GONE);
            }
        });
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

    public void back() {
        if (wv.canGoBack()) {
            wv.goBack();//返回上一页面
        } else {
            TestActivity.instance.finish();
        }
    }
}
