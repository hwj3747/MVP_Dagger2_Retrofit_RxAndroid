package com.haiyangroup.education.util.rximageloader;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * The RxImageLoader use Rxjava to load bitmap,please call
 * {@link  #init} mothod before use.
 * Created by Liyanshun on 2015/8/24.
 */
public class RxImageLoader {
    static Sources sources;

    public static void init(Context mContext) {
        sources = new Sources(mContext);
    }


    private static final Map<Integer, String> cacheKeysMap = Collections
            .synchronizedMap(new HashMap<>());

    /**
     * get the observable that load img and set it to the given ImageView
     *
     * @param img the ImageView to show this img
     * @param url the url for the img
     * @return the observable to load img
     */
    public static <V> Observable<Data> getLoaderObservable(V img, String url, String size) {
        final String firstUrl = url;
        if (url == null || url.equals("")) {
            return sources.defaultReturn();
        } else {
            Log.i("url", url);
//            if(size.equals(""))
//                url = ConfigUtil.getImageUrl() + url+"?imageView2/2/w/100";
//            else if(size.equals("myurl")){
//                ;
//            }
//            else
//                url = ConfigUtil.getImageUrl() + url+"?imageView2/2/w/"+size;
        }
        if (img != null && url != null) {
            cacheKeysMap.put(img.hashCode(), url);
        }
        // Create our sequence for querying best available data
        Observable<Data> source = Observable.concat(sources.memory(url), sources.disk(url), sources.network(url), sources.defaultReturn())
                .first(data -> data != null && data.bitmap != null && data.isAvailable());

        final String finalUrl = url;
        return source.doOnNext(data -> {
            if (data.bitmap != null && data.url.equals(finalUrl))
                if (img != null && finalUrl.equals(cacheKeysMap.get(img.hashCode()))) {
                    if (img instanceof ImageView) {
                        if (((ImageView) img).getTag().toString() != null && ((ImageView) img).getTag().toString().equals(firstUrl))//防止异步加载图片错位
                            ((ImageView) img).setImageBitmap(data.bitmap);
                    }
                }
        });
    }
}
