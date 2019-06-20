package co.kr.chanroid.mvvm_practice.di;

import android.content.Context;

import androidx.multidex.MultiDex;

import dagger.android.DaggerApplication;

public abstract class DaggerMultiDexApplication extends DaggerApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
