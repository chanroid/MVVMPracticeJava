package co.kr.chanroid.mvvm_practice.di.component;

import javax.inject.Singleton;

import co.kr.chanroid.mvvm_practice.app.MVVMApplication;
import co.kr.chanroid.mvvm_practice.di.module.ActivityBindingModule;
import co.kr.chanroid.mvvm_practice.di.module.ContextBindingModule;
import co.kr.chanroid.mvvm_practice.di.module.SystemServiceModule;
import co.kr.chanroid.mvvm_practice.di.module.ThreadModule;
import co.kr.chanroid.mvvm_practice.di.module.ViewModelModule;
import co.kr.chanroid.mvvm_practice.di.module.ViewModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ContextBindingModule.class,
        ActivityBindingModule.class,
        ViewModelModule.class,
        ViewModule.class,
        ThreadModule.class,
        SystemServiceModule.class
})
public interface AppComponent extends AndroidInjector<MVVMApplication> {
    @Component.Factory
    interface Factory extends AndroidInjector.Factory<MVVMApplication> {}
}
