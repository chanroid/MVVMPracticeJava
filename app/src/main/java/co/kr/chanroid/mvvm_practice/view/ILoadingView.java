package co.kr.chanroid.mvvm_practice.view;

public interface ILoadingView {
    void showProgress();
    void hideProgress();
    void changeProgress(int progress);
    int getProgress();
}
