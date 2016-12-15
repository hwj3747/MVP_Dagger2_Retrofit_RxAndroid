package com.haiyangroup.education.common;

/**
 * @author 何伟杰
 * @version 1.0, 2016/12/9
 */
public class ComponentHolder {
    private static AppComponent sAppComponent;

    public static void setAppComponent(AppComponent appComponent) {
        sAppComponent = appComponent;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}