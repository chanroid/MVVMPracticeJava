package co.kr.chanroid.mvvm_practice.app;

import co.kr.chanroid.mvvm_practice.di.DaggerMultiDexApplication;
import co.kr.chanroid.mvvm_practice.di.component.DaggerMVVMAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MVVMApplication extends DaggerMultiDexApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerMVVMAppComponent.factory().create(this);
    }
}
