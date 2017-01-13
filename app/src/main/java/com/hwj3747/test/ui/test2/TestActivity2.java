package com.hwj3747.test.ui.test2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hwj3747.test.R;
import com.hwj3747.test.base.BaseActivity;

public class TestActivity2 extends BaseActivity {
    public static TestActivity2 instance;
    TestActivityFragment2 testActivityFragment2=new TestActivityFragment2();

    public static void launch(Context context) {
        Intent intent = new Intent(context, TestActivity2.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.Layout, testActivityFragment2);
        transaction.commit();
    }


}
