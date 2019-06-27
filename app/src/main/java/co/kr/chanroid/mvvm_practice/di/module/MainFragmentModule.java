package co.kr.chanroid.mvvm_practice.di.module;

import co.kr.chanroid.mvvm_practice.databinding.MainFragmentViewDataBinding;
import co.kr.chanroid.mvvm_practice.di.scope.FragmentScope;
import co.kr.chanroid.mvvm_practice.fragment.MainFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {
    @Provides
    @FragmentScope
    MainFragmentViewDataBinding provideViewDataBinding(MainFragment fragment) {
        MainFragmentViewDataBinding mainFragmentViewDataBinding = MainFragmentViewDataBinding.inflate(fragment.getLayoutInflater());
        mainFragmentViewDataBinding.setLifecycleOwner(fragment);
        return mainFragmentViewDataBinding;
    }

}
