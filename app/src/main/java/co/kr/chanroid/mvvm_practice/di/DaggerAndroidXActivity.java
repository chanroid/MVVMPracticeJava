package co.kr.chanroid.mvvm_practice.di;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasAndroidInjector;

public abstract class DaggerAndroidXActivity extends AppCompatActivity implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }
}
