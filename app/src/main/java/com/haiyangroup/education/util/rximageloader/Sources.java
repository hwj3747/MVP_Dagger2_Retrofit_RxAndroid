package com.haiyangroup.education.util.rximageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import com.haiyangroup.education.R;
import com.haiyangroup.education.util.rximageloader.cacheobservers.DiskCacheObservable;
import com.haiyangroup.education.util.rximageloader.cacheobservers.MemoryCacheOvservable;
import com.haiyangroup.education.util.rximageloader.cacheobservers.NetCacheObservable;

import rx.Observable;

public class Sources {
    Context mContext;
    MemoryCacheOvservable mMemoryCacheOvservable;
    DiskCacheObservable mDiskCacheObservable;
    NetCacheObservable mNetCacheObservable;

    public Sources(Context mContext) {
        this.mContext = mContext;
        mMemoryCacheOvservable = new MemoryCacheOvservable();
        mDiskCacheObservable = new DiskCacheObservable(mContext);
        mNetCacheObservable = new NetCacheObservable();
    }


    public Observable<Data> memory(String url) {
        return mMemoryCacheOvservable.getObservable(url)
                .compose(logSource("MEMORY"));
    }

    public Observable<Data> disk(String url) {
        return mDiskCacheObservable.getObservable(url)
                .filter(data -> data.bitmap != null)
                        //save picture to disk
                .doOnNext(mMemoryCacheOvservable::putData)
                .compose(logSource("DISK"));

    }

    public Observable<Data> network(String url) {
        return mNetCacheObservable.getObservable(url)
                .doOnNext(data -> {
                    //save picture to disk and memory
                    if (data.bitmap != null) {
                        mMemoryCacheOvservable.putData(data);
                        mDiskCacheObservable.putData(data);
                    }
                })
                .compose(logSource("NET"));
    }

    Observable.Transformer<Data, Data> logSource(final String source) {
        return dataObservable -> dataObservable.doOnNext(data -> {
            if (data != null && data.bitmap != null) {
                Logger.i(source + " has the data you are looking for!");
            } else {
                Logger.i(source + " not has the data!");
            }
        });
    }


    public Observable<Data> defaultReturn() {
        return Observable.defer(() -> {
                    Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher);
                    return Observable.just(new Data(bitmap, "default"));
                }
        );
    }
}
