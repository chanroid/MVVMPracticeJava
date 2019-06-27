package co.kr.chanroid.mvvm_practice.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import co.kr.chanroid.mvvm_practice.databinding.CameraTestViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXFragment;
import co.kr.chanroid.mvvm_practice.worker.Preview;

public class CameraFragment extends DaggerAndroidXFragment {
    private CameraTestViewDataBinding viewDataBinding;
    private Preview mPreview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = CameraTestViewDataBinding.inflate(getLayoutInflater());
        viewDataBinding.setLifecycleOwner(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPreview = new Preview(viewDataBinding.textureView);
    }

    private static final String TAG = "MAINACTIVITY";

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200:
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    int grantResult = grantResults[i];
                    if (permission.equals(Manifest.permission.CAMERA)) {
                        if(grantResult == PackageManager.PERMISSION_GRANTED) {
                            mPreview = new Preview(viewDataBinding.textureView);
                            Log.d(TAG,"mPreview set");
                        } else {
                            Toast.makeText(getActivity(),"Should have camera permission to run", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPreview.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPreview.onPause();
    }

}
