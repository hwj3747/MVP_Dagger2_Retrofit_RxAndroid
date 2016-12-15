package com.haiyangroup.education.util.rximageloader.cacheobservers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import com.haiyangroup.education.util.rximageloader.Data;
import com.haiyangroup.education.util.rximageloader.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * NetCacheObservable load data from intenet
 * Created by Liyanshun on 2015/8/24.
 */
public class NetCacheObservable extends CacheObservable {
    @Override
    public Observable<Data> getObservable(String url) {
        return Observable.create(new Observable.OnSubscribe<Data>() {
            @Override
            public void call(Subscriber<? super Data> subscriber) {
                Data data;
                Bitmap bitmap = null;
                InputStream inputStream = null;
                Logger.i("get img on net:" + url);
                try {
                    final URLConnection con = new URL(url).openConnection();
                    con.setDoInput(true);
                    inputStream = con.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                data = new Data(bitmap, url);
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
