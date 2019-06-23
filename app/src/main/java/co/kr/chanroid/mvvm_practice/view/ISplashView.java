package co.kr.chanroid.mvvm_practice.view;

import androidx.lifecycle.LifecycleOwner;

public interface ISplashView extends ILoadingView, IPermissionView, LifecycleOwner {
    void moveToMain();
    void moveToLogin();
}
