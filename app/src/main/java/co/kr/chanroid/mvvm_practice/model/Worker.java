package co.kr.chanroid.mvvm_practice.model;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public abstract class Worker<R> implements ObservableOnSubscribe<R> {
    @Override
    public void subscribe(ObservableEmitter<R> emitter) throws Exception {
        R result = work();
        emitter.onNext(result);
    }

    public abstract R work() throws Exception;
}
