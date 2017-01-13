package com.haiyangroup.education.data;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haiyangroup.education.entity.TestEntity;
import com.haiyangroup.education.entity.jsonOut;

import org.xml.sax.ErrorHandler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/1/28.
 */

public class AbsService {

    private static final String FORUM_SERVER_URL = "http://baike.baidu.com/api/openapi/";
    private AbsApi mAbsApi;
    private volatile static AbsService singleton;
    final static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .serializeNulls()
            .create();

    public AbsService() {
//
//        RequestInterceptor requestInterceptor = request -> {
//            request.addHeader("Accept", "text/html");
//            //request.addHeader("token",ConfigUtil.getToken());
//            request.addHeader("os","Android");
//            request.addHeader("ver","1");
//        };
//
//
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(FORUM_SERVER_URL)
//                .setRequestInterceptor(requestInterceptor)
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                        // .setClient(new OkClient(new OkHttpClient()))
//                .build();
//
//        mAbsApi = restAdapter.create(AbsApi.class);
        //gson converter

//公共参数
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                String method = originalRequest.method();
                Headers headers = originalRequest.headers();
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("scope", "103")
                        .addQueryParameter("format", "json")
                        .addQueryParameter("appid", "379020")
                        .addQueryParameter("bk_length", "600")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };

//打印日志
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(addQueryParameterInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FORUM_SERVER_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        mAbsApi = retrofit.create(AbsApi.class);
    }
    public AbsApi getApi() {

        return mAbsApi;
    }

    public interface AbsApi {
        @GET("BaikeLemmaCardApi")
        Observable<jsonOut>
        getBaidu(@Query("bk_key")String key);//获取新闻
    }

    public Observable<AbsReturn<TestEntity>> test(){
        return Observable.create(f->{
            TestEntity t=new TestEntity();
            t.setName("hahaha");
            AbsReturn<TestEntity> a=new AbsReturn<TestEntity>();
            a.setCode(1);
            a.setMessage("success");
            a.setData(t);
            f.onNext(a);
        });


    }

    public static AbsService getInstance() {
        if (singleton == null) {
            synchronized (AbsService.class) {
                if (singleton == null) {
                    singleton = new AbsService();
                }
            }
        }
        return singleton;
    }

    public static AbsApi getService(){
        return getInstance().mAbsApi;
    }
}
