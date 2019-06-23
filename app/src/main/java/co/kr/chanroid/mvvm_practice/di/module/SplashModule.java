package co.kr.chanroid.mvvm_practice.di.module;

import androidx.databinding.DataBindingUtil;

import co.kr.chanroid.mvvm_practice.R;
import co.kr.chanroid.mvvm_practice.activity.SplashActivity;
import co.kr.chanroid.mvvm_practice.databinding.SplashViewDataBinding;
import co.kr.chanroid.mvvm_practice.view.ISplashView;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {
        SplashModule.SplashBindModule.class
})
public class SplashModule {
    @Module
    public interface SplashBindModule {
        @Binds
        ISplashView bindSplashView(SplashActivity viewImpl);
    }

    @Provides
    SplashViewDataBinding provideViewDataBinding(SplashActivity activity) {
        final SplashViewDataBinding splashViewDataBinding = DataBindingUtil.setContentView(activity, R.layout.activity_splash);
        splashViewDataBinding.setLifecycleOwner(activity);
        return splashViewDataBinding;
    }

}
