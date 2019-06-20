package co.kr.chanroid.mvvm_practice.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Task<T> {

    Observable<T> observable;
    Disposable disposable;

    Consumer<T> callback;
    Consumer<Throwable> errorCallback;

    public void callback(Consumer<T> callback) {
        this.callback = callback;
    }

    public void errorCallback(Consumer<Throwable> errorCallback) {
        this.errorCallback = errorCallback;
    }

    public Task(Observable<T> observable) {
        this.observable =
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    public Task(Worker<T> worker) {
        this.observable = Observable.create(worker)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void start() {
        disposable = this.observable.subscribe(callback, errorCallback);
    }

}