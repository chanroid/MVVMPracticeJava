package co.kr.chanroid.mvvm_practice.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import co.kr.chanroid.mvvm_practice.R;
import co.kr.chanroid.mvvm_practice.databinding.MainActivityViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXActivity;
import co.kr.chanroid.mvvm_practice.fragment.MainFragment;
import co.kr.chanroid.mvvm_practice.viewmodel.MainViewModel;

public class MainActivity extends DaggerAndroidXActivity {

    private MainActivityViewDataBinding viewDataBinding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = getViewModelProvider().get(MainViewModel.class);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewDataBinding.setLifecycleOwner(this);

        Toast.makeText(this, viewModel.randomText.getValue(), Toast.LENGTH_LONG).show();

        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(viewDataBinding.fragmentContainer.getId(), mainFragment)
                .commit();
    }
}
