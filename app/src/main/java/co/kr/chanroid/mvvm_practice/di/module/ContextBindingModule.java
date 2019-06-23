package co.kr.chanroid.mvvm_practice.di.module;

import android.app.Application;
import android.content.Context;

import co.kr.chanroid.mvvm_practice.app.MVVMApplication;
import dagger.Binds;
import dagger.Module;

@Module
public interface ContextBindingModule {
    @Binds
    Application bindApplication(MVVMApplication application);

    @Binds
    Context bindApplicationContext(MVVMApplication application);
}
