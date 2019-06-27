package co.kr.chanroid.mvvm_practice.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.databinding.SplashViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXActivity;
import co.kr.chanroid.mvvm_practice.viewmodel.SplashViewModel;

public class SplashActivity extends DaggerAndroidXActivity {

    SplashViewModel viewModel;

    @Inject
    SplashViewDataBinding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = getViewModelProvider().get(SplashViewModel.class);
        viewDataBinding.setViewModel(viewModel);

        viewModel.load().observe(this, integer -> {
            viewModel.loadingProgress.setValue(integer);
            if (integer == 100) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
    }
}
