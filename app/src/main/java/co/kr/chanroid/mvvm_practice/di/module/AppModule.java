package co.kr.chanroid.mvvm_practice.di.module;

import android.content.Context;

import co.kr.chanroid.mvvm_practice.app.MVVMApplication;
import dagger.Binds;
import dagger.Module;

@Module
public interface AppModule {
    @Binds
    Context bindAppContext(MVVMApplication application);
}
