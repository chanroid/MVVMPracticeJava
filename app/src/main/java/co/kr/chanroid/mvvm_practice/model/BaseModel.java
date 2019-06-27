package co.kr.chanroid.mvvm_practice.model;

import android.os.Environment;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;

import okhttp3.ResponseBody;

public class BaseModel {
    private static final String TAG = "dd";

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

    public void writeResponseBodyToDisk(ResponseBody body, MutableLiveData<Integer> liveData) {
        new Thread(() -> {
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                // todo change the file location/name according to your needs
                File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + "Future Studio Icon.png");

                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;
                    int percent = (int) (fileSizeDownloaded / fileSize * 100);
                    liveData.postValue(percent);
                    Log.d(TAG, "file download: " + percent);
                }

                outputStream.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
