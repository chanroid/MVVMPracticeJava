package co.kr.chanroid.mvvm_practice.di.component;

import javax.inject.Singleton;

import co.kr.chanroid.mvvm_practice.app.MVVMApplication;
import co.kr.chanroid.mvvm_practice.di.module.BaseModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        BaseModule.class
})
public interface MVVMAppComponent extends AndroidInjector<MVVMApplication> {
    @Component.Factory
    interface Factory extends AndroidInjector.Factory<MVVMApplication> {}
}
