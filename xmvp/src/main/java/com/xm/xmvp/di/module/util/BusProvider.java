package com.xm.xmvp.di.module.util;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class BusProvider {

    private final Bus mainBus;

    public BusProvider() {
        this.mainBus = new Bus(ThreadEnforcer.ANY);
    }

    /**
     * {@link Bus#register(Object)}
     *
     * @param object object whose handler methods should be registered
     */
    public void register(Object object) {
        this.mainBus.register(object);
    }

    /**
     * {@link Bus#unregister(Object)}
     *
     * @param object object whose producer and handler methods should be unregistered.
     */
    public void unregister(Object object) {
        this.mainBus.unregister(object);
    }

    /**
     * {@link Bus#post(Object)}
     *
     * @param event event to post.
     */
    public void post(Object event) {
        this.mainBus.post(event);
    }
}
