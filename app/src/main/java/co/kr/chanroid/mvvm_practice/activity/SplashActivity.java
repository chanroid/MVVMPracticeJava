package co.kr.chanroid.mvvm_practice.activity;

import android.media.AudioManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.R;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXActivity;
import co.kr.chanroid.mvvm_practice.model.BaseModel;

public class SplashActivity extends DaggerAndroidXActivity {
    @Inject
    BaseModel baseModel;

    @Inject
    NotificationManagerCompat notificationManagerCompat;

    @Inject
    AudioManager audioManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }
}
