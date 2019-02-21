package com.xm.xmvp.usecase;

import rx.Observable;

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

    public Object getParam1() {
        return param1;
    }

    public Object getParam2() {
        return param2;
    }

    public Object getParam3() {
        return param3;
    }

    public Object getParam4() {
        return param4;
    }

    public abstract Observable<RESULT> builder();
}
