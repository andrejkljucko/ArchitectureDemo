package com.ondrejruttkay.architecturedemo.common.util;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Onko on 08/09/2016.
 */
public class RxUtils {

    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> applyDelay() {
        return observable -> observable
                .flatMap(input -> {
                    try {
                        Thread.sleep(2000);
                        return Observable.just(input);
                    } catch (InterruptedException e) {
                        return Observable.error(e);
                    }
                });
    }
}
