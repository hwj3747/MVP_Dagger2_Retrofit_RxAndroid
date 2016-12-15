package com.haiyangroup.education.data;


import com.haiyangroup.education.entity.TestEntity;

import java.util.ArrayList;
import java.util.Observer;

import javax.inject.Inject;

import dagger.Module;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/1/28.
 */

public class AbsService {

    private static final String FORUM_SERVER_URL = "https://sk.haiyangroup.com:9081/SAAS";
    private AbsApi mAbsApi;

    public AbsService() {

        RequestInterceptor requestInterceptor = request -> {
            request.addHeader("Accept", "text/html");
            //request.addHeader("token",ConfigUtil.getToken());
            request.addHeader("os","Android");
            request.addHeader("ver","1");
        };


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(FORUM_SERVER_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                        // .setClient(new OkClient(new OkHttpClient()))
                .build();

        mAbsApi = restAdapter.create(AbsApi.class);
    }
    public AbsApi getApi() {

        return mAbsApi;
    }

    public interface AbsApi {

        @GET("/sys/sms")
        Observable<AbsReturn<TestEntity>>
        test();//发送验证码

        @GET("/appService/home/homePage")
        Observable<AbsReturn<DefaultData>>
        test1();//获取新闻

    }

    public Observable<AbsReturn<TestEntity>> test(){
        return Observable.create(f->{
            TestEntity t=new TestEntity();
            t.setName("hahaha");
            AbsReturn<TestEntity> a=new AbsReturn<TestEntity>();
            a.setData(t);
            f.onNext(a);
        });


    }
}
