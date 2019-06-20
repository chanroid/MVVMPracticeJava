package co.kr.chanroid.mvvm_practice.di.component;

import javax.inject.Singleton;

import co.kr.chanroid.mvvm_practice.app.MVVMApplication;
import co.kr.chanroid.mvvm_practice.di.module.ActivityBindingModule;
import co.kr.chanroid.mvvm_practice.di.module.AppModule;
import co.kr.chanroid.mvvm_practice.di.module.SystemServiceModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBindingModule.class,
        SystemServiceModule.class
})
public interface AppComponent extends AndroidInjector<MVVMApplication> {
    @Component.Factory
    interface Factory extends AndroidInjector.Factory<MVVMApplication> {}
}
