package co.kr.chanroid.mvvm_practice.di;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class DaggerAndroidXFragment extends DaggerFragment {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    public ViewModelProvider getViewModelProvider() {
        return ViewModelProviders.of(this, getViewModelFactory());
    }

    public ViewModelProvider getViewModelProviderFromActivity() {
        if (getActivity() == null)
            return getViewModelProvider();
        else
            return ViewModelProviders.of(getActivity(), getViewModelFactory());
    }

    private ViewModelProvider.Factory getViewModelFactory() {
        return viewModelFactory;
    }
}
