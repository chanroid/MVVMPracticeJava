package co.kr.chanroid.mvvm_practice.viewmodel;

import android.os.Environment;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.model.BaseModel;
import co.kr.chanroid.mvvm_practice.model.RetrofitTest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashViewModel extends ViewModel {
    private static final String TAG = "dd";
    @Inject
    BaseModel baseModel;
    @Inject
    RetrofitTest retrofitTest;

    @Inject
    public SplashViewModel() {

    }

    public MutableLiveData<String> loadingText = new MutableLiveData<>();
    public MutableLiveData<Integer> loadingProgress = new MutableLiveData<>();

    public void load() {
        loadingText.setValue("파일 준비중");
        loadingProgress.setValue(0);
        retrofitTest.downloadFile("https://i.ibb.co/JvsFCB2/ic-launcher.png").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "server contacted and has file");
                    baseModel.writeResponseBodyToDisk(response.body(), loadingProgress);
                } else {
                    Log.d(TAG, "server contact failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "error");
            }
        });
    }

}
