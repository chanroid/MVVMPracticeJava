package co.kr.chanroid.mvvm_practice.di.component;

import co.kr.chanroid.mvvm_practice.activity.SplashActivity;
import co.kr.chanroid.mvvm_practice.di.module.BaseModule;
import co.kr.chanroid.mvvm_practice.di.scope.ActivityScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        AndroidInjectionModule.class,
})
public interface SplashComponent extends AndroidInjector<SplashActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SplashActivity> {}
}
