package co.kr.chanroid.mvvm_practice.di.component;

import co.kr.chanroid.mvvm_practice.activity.MainActivity;
import co.kr.chanroid.mvvm_practice.di.scope.ActivityScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        AndroidInjectionModule.class
})
public interface MainComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
}
