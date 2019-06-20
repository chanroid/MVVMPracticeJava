package co.kr.chanroid.mvvm_practice.di.module;

import android.content.Context;

import co.kr.chanroid.mvvm_practice.activity.MainActivity;
import co.kr.chanroid.mvvm_practice.activity.SplashActivity;
import co.kr.chanroid.mvvm_practice.app.MVVMApplication;
import co.kr.chanroid.mvvm_practice.di.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface BindsModule {
    @Binds
    Context bindAppContext(MVVMApplication application);

    @ActivityScope
    @ContributesAndroidInjector
    SplashActivity bindSplashActivity();

    @ActivityScope
    @ContributesAndroidInjector
    MainActivity bindMainActivity();
}
