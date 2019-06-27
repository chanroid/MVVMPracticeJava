package co.kr.chanroid.mvvm_practice.di.module;

import co.kr.chanroid.mvvm_practice.activity.MainActivity;
import co.kr.chanroid.mvvm_practice.activity.SplashActivity;
import co.kr.chanroid.mvvm_practice.di.scope.ActivityScope;
import co.kr.chanroid.mvvm_practice.di.scope.FragmentScope;
import co.kr.chanroid.mvvm_practice.fragment.CameraFragment;
import co.kr.chanroid.mvvm_practice.fragment.MainFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = SplashModule.class)
    SplashActivity bindSplashActivity();

    @ActivityScope
    @ContributesAndroidInjector
    MainActivity bindMainActivity();

    @FragmentScope
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    MainFragment bindMainFragment();

    @FragmentScope
    @ContributesAndroidInjector
    CameraFragment bindCameraFragment();
}
