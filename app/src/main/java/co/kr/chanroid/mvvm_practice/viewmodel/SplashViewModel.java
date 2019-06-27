package co.kr.chanroid.mvvm_practice.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.model.BaseModel;

public class SplashViewModel extends ViewModel {
    @Inject
    BaseModel baseModel;

    @Inject
    public SplashViewModel() {

    }

    public MutableLiveData<String> loadingText = new MutableLiveData<>();
    public MutableLiveData<Integer> loadingProgress = new MutableLiveData<>();

    public LiveData<Integer> load() {
        loadingText.setValue("파일 준비중");
        loadingProgress.setValue(0);
        return baseModel.doSomething();
    }

}
