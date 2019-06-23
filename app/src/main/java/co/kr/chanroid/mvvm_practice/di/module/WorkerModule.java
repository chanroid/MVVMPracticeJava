package co.kr.chanroid.mvvm_practice.di.module;

import androidx.work.WorkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkerModule {
    @Provides
    @Singleton
    WorkManager provideWorkManager() {
        return WorkManager.getInstance();
    }
}
