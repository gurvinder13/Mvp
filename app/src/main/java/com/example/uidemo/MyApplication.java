package com.example.uidemo;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.example.uidemo.network.BaseRetrofitHandler;


public class MyApplication extends MultiDexApplication {
    private static final String TAG = MyApplication.class.getSimpleName();
    private static Context sAppContext;
    private static MyApplication mInstance;
    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
    public static Context getsAppContext() {
        return sAppContext.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        sAppContext = this;
        // for  RetrofitHandler
        BaseRetrofitHandler.getInstance().setupRetrofitAndOkHttp();


    }

}
