package co.kr.chanroid.mvvm_practice.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.ProgressBarManager;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.databinding.SplashViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXActivity;
import co.kr.chanroid.mvvm_practice.model.PermissionChecker;
import co.kr.chanroid.mvvm_practice.view.ISplashView;
import co.kr.chanroid.mvvm_practice.viewmodel.SplashViewModel;

public class SplashActivity extends DaggerAndroidXActivity implements ISplashView {

    @Inject
    SplashViewModel viewModel;
    @Inject
    SplashViewDataBinding viewDataBinding;
    @Inject
    ProgressBarManager progressBarManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding.setViewModel(viewModel);
        viewModel.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        String[] explains = PermissionChecker.result(this, requestCode, permissions, grantResults);
        viewModel.permissionResult(explains);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void changeProgress(int progress) {

    }

    @Override
    public int getProgress() {
        return 0;
    }

    @Override
    public void moveToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void moveToLogin() {

    }

    @Override
    public void permissionRequest(int requestCode, String[] permissions) {
        if (!PermissionChecker.request(this, requestCode, permissions)) {
            viewModel.permissionResult(new String[0]);
        }
    }

    @Override
    public void permissionExplain(String[] permissions) {

    }
}
