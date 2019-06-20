package co.kr.chanroid.mvvm_practice.di.module;

import co.kr.chanroid.mvvm_practice.activity.MainActivity;
import co.kr.chanroid.mvvm_practice.activity.SplashActivity;
import co.kr.chanroid.mvvm_practice.di.scope.ActivityScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    SplashActivity bindSplashActivity();

    @ActivityScope
    @ContributesAndroidInjector
    MainActivity bindMainActivity();
}
