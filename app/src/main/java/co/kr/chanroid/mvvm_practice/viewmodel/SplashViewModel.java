package co.kr.chanroid.mvvm_practice.viewmodel;

import android.Manifest;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.view.ISplashView;
import co.kr.chanroid.mvvm_practice.worker.WorkerThreadPoolExecutor;

public class SplashViewModel {
    @Inject
    public SplashViewModel(ISplashView viewImpl) {
        this.viewImpl = viewImpl;
    }

    public MutableLiveData<String> loadingText = new MutableLiveData<>();
    public MutableLiveData<Integer> loadingProgress = new MutableLiveData<>();

    private ISplashView viewImpl;

    @Inject
    WorkerThreadPoolExecutor threadPoolExecutor;

    private static final int REQUEST_CODE_PERMISSION = 535;
    private static final String[] REQUEST_PERMISSIONS = new String[] {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public void start() {
        permissionRequest();
    }

    private void load() {
        loadingText.setValue("파일 준비중");
        loadingProgress.setValue(0);
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loadingProgress.postValue(i);
            }
        });
    }

    private void permissionRequest() {
        loadingText.setValue("권한 요청");
        loadingProgress.setValue(0);
        viewImpl.permissionRequest(REQUEST_CODE_PERMISSION, REQUEST_PERMISSIONS);
    }

    public void permissionResult(String[] needExplain) {
        if (needExplain.length > 0) {
            viewImpl.permissionExplain(needExplain);
        } else {
            load();
        }
    }
}
