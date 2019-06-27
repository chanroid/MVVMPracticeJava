package co.kr.chanroid.mvvm_practice.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import co.kr.chanroid.mvvm_practice.di.ViewModelFactory;
import co.kr.chanroid.mvvm_practice.di.qualifier.ViewModelKey;
import co.kr.chanroid.mvvm_practice.viewmodel.SplashViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface ViewModelModule {
    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    ViewModel bindSplashViewModel(SplashViewModel viewModel);
}
