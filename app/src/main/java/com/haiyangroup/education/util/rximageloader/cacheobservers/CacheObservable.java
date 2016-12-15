package com.haiyangroup.education.util.rximageloader.cacheobservers;


import com.haiyangroup.education.util.rximageloader.Data;

import rx.Observable;

/**
 * Created by Liyanshun on 2015/8/24.
 */
public abstract class CacheObservable {
    public abstract Observable<Data> getObservable(String url);
}
