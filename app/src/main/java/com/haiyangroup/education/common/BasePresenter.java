package com.haiyangroup.education.common;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * @author 何伟杰
 * @version 1.0, 2017/1/5
 */
public abstract class BasePresenter<V> {
    private V view;

    public void bindView(V view) {
        this.view = view;
    }

    public void unbindView() {
        this.view = null;
    }

    public V getView() {
        return this.view;
    }
}
