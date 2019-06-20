package co.kr.chanroid.mvvm_practice.di.module;

import co.kr.chanroid.mvvm_practice.di.component.MainComponent;
import co.kr.chanroid.mvvm_practice.di.component.SplashComponent;
import dagger.Module;

@Module(subcomponents = {
        SplashComponent.class,
        MainComponent.class,
}, includes = {
        BindsModule.class,
        ProvidesModule.class,
})
public class BaseModule {
}
