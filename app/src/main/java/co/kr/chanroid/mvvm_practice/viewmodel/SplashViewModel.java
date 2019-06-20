package co.kr.chanroid.mvvm_practice.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import co.kr.chanroid.mvvm_practice.model.BaseModel;
import co.kr.chanroid.mvvm_practice.model.Task;
import co.kr.chanroid.mvvm_practice.model.Worker;

public class SplashViewModel extends AndroidViewModel {

    public MutableLiveData<String> loadingLiveText = new MutableLiveData<>();

    BaseModel baseModel = new BaseModel();

    public void start() {
        Task<String> task = new Task<>(new Worker<String>() {
            @Override
            public String work() throws Exception {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(2000);
                    loadingLiveText.postValue(baseModel.randomString());
                }
                return "";
            }
        });
        task.callback(s -> {

        });
        task.errorCallback(throwable -> {

        });
        task.start();
    }

    public SplashViewModel(@NonNull Application application) {
        super(application);
        loadingLiveText.setValue("Loading");
    }
}
