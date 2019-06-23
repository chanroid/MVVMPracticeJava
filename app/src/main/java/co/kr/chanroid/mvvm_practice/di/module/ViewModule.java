package co.kr.chanroid.mvvm_practice.di.module;

import androidx.leanback.app.ProgressBarManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {
    @Provides
    ProgressBarManager provideProgressBarManager() {
        return new ProgressBarManager();
    }
}
