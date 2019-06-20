package co.kr.chanroid.mvvm_practice.activity;

import android.os.Bundle;

import co.kr.chanroid.mvvm_practice.R;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXActivity;

public class MainActivity extends DaggerAndroidXActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
