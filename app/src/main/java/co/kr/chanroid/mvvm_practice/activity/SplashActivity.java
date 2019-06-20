package co.kr.chanroid.mvvm_practice.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;

import co.kr.chanroid.mvvm_practice.R;
import co.kr.chanroid.mvvm_practice.databinding.SplashViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXActivity;
import co.kr.chanroid.mvvm_practice.viewmodel.SplashViewModel;

public class SplashActivity extends DaggerAndroidXActivity implements LifecycleOwner {

    SplashViewModel viewModel;
    SplashViewDataBinding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        viewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        viewModel.start();

        viewDataBinding.setViewModel(viewModel);
        viewDataBinding.setLifecycleOwner(this);
    }
}
