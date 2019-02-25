package com.xm.xmvp.usecase;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class BaseUseCase<RESULT> {

    private Object param1;
    private Object param2;
    private Object param3;
    private Object param4;

    public BaseUseCase<RESULT> setParam1(Object p1) {
        this.param1 = p1;
        return this;
    }

    public BaseUseCase<RESULT> setParam2(Object p2) {
        this.param2 = p2;
        return this;
    }

    public BaseUseCase<RESULT> setParam3(Object p3) {
        this.param3 = p3;
        return this;
    }

    public BaseUseCase<RESULT> setParam4(Object p4) {
        this.param4 = p4;
        return this;
    }

    protected Object getParam1() {
        return param1;
    }

    protected Object getParam2() {
        return param2;
    }

    protected Object getParam3() {
        return param3;
    }

    protected Object getParam4() {
        return param4;
    }

    protected abstract Observable<RESULT> buildObservable();

    /**
     * 执行订阅action方法
     * 不附加线程控制
     *
     * @param listener OnUseCaseActionListener实现回调
     * @return
     */
    public Subscription runAction(final OnUseCaseActionListener listener) {
        final Observable<RESULT> observable = buildObservable();
        return observable.subscribe(new Action1<RESULT>() {
            @Override
            public void call(RESULT result) {
                if (observable != null && listener != null) {
                    listener.call(result);
                } else {
                    listener.call(null);
                }
            }
        });
    }

    /**
     * 执行订阅Subscriber方法
     * 不附加线程控制
     *
     * @param listener OnUseCaseSubscriberListener实现回调
     * @return
     */
    public Subscription runSubscriber(final OnUseCaseSubscriberListener listener) {
        final Observable<RESULT> observable = buildObservable();
        return observable.subscribe(new Subscriber<RESULT>() {
            @Override
            public void onCompleted() {
                if (observable != null && listener != null) {
                    listener.onCompleted();
                } else {
                    listener.onCompleted();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (observable != null && listener != null) {
                    listener.onError(e);
                } else {
                    listener.onError(null);
                }
            }

            @Override
            public void onNext(RESULT result) {
                if (observable != null && listener != null) {
                    listener.onNext(result);
                } else {
                    listener.onNext(null);
                }
            }
        });
    }

    /**
     * action回调
     *
     * @param <RESULT>
     */
    public interface OnUseCaseActionListener<RESULT> {

        void call(RESULT result);
    }

    /**
     * Subscriber回调
     *
     * @param <RESULT>
     */
    public interface OnUseCaseSubscriberListener<RESULT> {

        void onCompleted();

        void onError(Throwable e);

        void onNext(RESULT result);
    }
}
