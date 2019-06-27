package co.kr.chanroid.mvvm_practice.di.module;

import androidx.databinding.DataBindingUtil;

import co.kr.chanroid.mvvm_practice.R;
import co.kr.chanroid.mvvm_practice.activity.SplashActivity;
import co.kr.chanroid.mvvm_practice.databinding.SplashViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {
    @Provides
    @ActivityScope
    SplashViewDataBinding provideViewDataBinding(SplashActivity activity) {
        final SplashViewDataBinding splashViewDataBinding = DataBindingUtil.setContentView(activity, R.layout.activity_splash);
        splashViewDataBinding.setLifecycleOwner(activity);
        return splashViewDataBinding;
    }

}
