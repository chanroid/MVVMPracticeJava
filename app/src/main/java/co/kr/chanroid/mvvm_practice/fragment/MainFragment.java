package co.kr.chanroid.mvvm_practice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import co.kr.chanroid.mvvm_practice.databinding.MainFragmentViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.DaggerAndroidXFragment;
import co.kr.chanroid.mvvm_practice.viewmodel.MainViewModel;

public class MainFragment extends DaggerAndroidXFragment {

    @Inject
    MainFragmentViewDataBinding viewDataBinding;

    private MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = getViewModelProviderFromActivity().get(MainViewModel.class);
        viewDataBinding.setViewModel(viewModel);
    }
}
