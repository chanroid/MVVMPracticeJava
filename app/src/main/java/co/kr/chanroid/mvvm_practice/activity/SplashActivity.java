package co.kr.chanroid.mvvm_practice.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.databinding.SplashViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXActivity;
import co.kr.chanroid.mvvm_practice.viewmodel.SplashViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class SplashActivity extends DaggerAndroidXActivity {

    SplashViewModel viewModel;

    @Inject
    SplashViewDataBinding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = getViewModelProvider().get(SplashViewModel.class);
        viewDataBinding.setViewModel(viewModel);

        RxPermissions rxPermissions = new RxPermissions(this);
        Disposable disposable = rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA).subscribe(aBoolean -> {

        }, throwable -> {

        }, () -> {
            viewModel.load();
            viewModel.loadingProgress.observe(this, integer -> {
                if (integer == 100) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            });
        });
    }
}
