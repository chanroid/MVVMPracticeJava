package co.kr.chanroid.mvvm_practice.di;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public abstract class DaggerAndroidXActivity extends AppCompatActivity implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }

    public ViewModelProvider getViewModelProvider() {
        return ViewModelProviders.of(this, getViewModelFactory());
    }

    private ViewModelProvider.Factory getViewModelFactory() {
        return viewModelFactory;
    }
}
