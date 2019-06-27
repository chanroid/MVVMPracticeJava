package co.kr.chanroid.mvvm_practice.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> randomText_ = new MutableLiveData<>();
    public LiveData<String> randomText = randomText_;

    @Inject
    MainViewModel() {
        String value = String.valueOf((int) (Math.random() * 100));
        randomText_.setValue(value);
    }
}
