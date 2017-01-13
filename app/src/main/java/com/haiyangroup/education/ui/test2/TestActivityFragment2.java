package com.haiyangroup.education.ui.test2;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haiyangroup.education.R;
import com.haiyangroup.education.common.App;
import com.haiyangroup.education.common.AppComponent;
import com.haiyangroup.education.common.AppModule;
import com.haiyangroup.education.common.ComponentHolder;
import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.entity.jsonOut;
import com.haiyangroup.education.present.TestPresenter;
import com.haiyangroup.education.present.TestPresenter2;
import com.haiyangroup.education.view.TestView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import icepick.Icepick;
import icepick.State;

/**
 * A placeholder fragment containing a simple view.
 */
public class TestActivityFragment2 extends Fragment implements TestView {

    @Inject
    TestPresenter presenter;

    @Inject
    TestPresenter2 presenter2;

    @InjectView(R.id.editText)
    EditText editText;

    @InjectView(R.id.text)
    TextView text;

    @InjectView(R.id.search)
    Button search;

    public TestActivityFragment2() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Icepick.restoreInstanceState(this, savedInstanceState);
        ComponentHolder.getAppComponent().inject(this);

        presenter.bindView(this);

        presenter2.bindView(this);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
//        search.setOnClickListener(v->presenter2.test());


        search.setOnClickListener(v-> presenter.test(editText.getText().toString()));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save state of all @State annotated members
        //Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView =inflater.inflate(R.layout.fragment_test2, container, false);

        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void show(jsonOut test) {
        if(test==null||test.getCard()==null)
            text.setText("暂无百科");
        else {
            String text1="";
            for(jsonOut.TCard tCard:test.getCard()) {

                text1 += tCard.getName() + ":" +tCard.getFormat().toString()+"\n";
             }
            text.setText(text1);
        }
    };
}
