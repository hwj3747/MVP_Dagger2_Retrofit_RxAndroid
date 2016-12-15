package com.haiyangroup.education.common;

import android.app.Activity;
import android.content.Context;

import com.haiyangroup.library.utils.CrashHandler;

import java.util.LinkedList;
import java.util.List;

import compartment.ComponentCacheApplication;


public class App extends ComponentCacheApplication {
    private AppComponent component;


    //运用list来保存们每一个activity是关键
    private List<Activity> mList = new LinkedList<Activity>();
    //为了实现每次使用该类时不创建新的对象而创建的静态对象
    private static App instance;
    //实例化一次
    public synchronized static App getInstance(){
        if (null == instance) {
            instance = new App();
        }
        return instance;
    }
    // add Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    //关闭每一个list内的activity
    public void exit() {
        try {
            for (Activity activity:mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    //杀进程
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    protected AppModule getApplicationModule() {
        return new AppModule(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EndObserver.init(getApplicationContext());
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        ComponentHolder.setAppComponent(appComponent);
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());
//        EMChat.getInstance().init(getApplicationContext());
//        EMChat.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，避免消耗不必要的资源
//        EMChat.getInstance().setAutoLogin(true);
//
//        //开启测试模式
//        //  BeeCloud.setSandbox(true);
////此处第二个参数是控制台的test secret
//        BeeCloud.setAppIdAndSecret("b21dacc5-2294-4f1b-bbbd-58e14376da6a",
//                "59a764d5-f1fa-43c9-a27f-7a466cd652d7");
    }

//    public static AppComponent getAppComponent(Context context) {
//        App app = (App)context.getApplicationContext();
//        if (app.component == null) {
//            app.component = DaggerAppComponent.builder()
//                    .appModule(app.getApplicationModule())
//                    .build();
//        }
//        return app.component;
//    }

    public static void clearAppComponent(Context context) {
        App app = (App)context.getApplicationContext();
        app.component = null;
    }


}
