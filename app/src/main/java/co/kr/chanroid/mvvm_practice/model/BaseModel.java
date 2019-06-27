package co.kr.chanroid.mvvm_practice.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

public class BaseModel {
    @Inject
    BaseModel() {

    }

    public LiveData<Integer> doSomething() {
        MutableLiveData<Integer> liveData = new MutableLiveData<>();
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    liveData.postValue(i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return liveData;
    }
}
