package com.xm.xmvp.presenter;

import android.support.annotation.Nullable;

import com.xm.xmvp.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class ConstrainedPresenter<V extends Vu> implements Presenter {
    /**
     * View层V的接口实现对象
     */
    private V vu;

    /**
     * 获取View层V的接口实现对象
     *
     * @return View层V的接口实现对象
     */
    public V getVu() {
        return this.vu;
    }

    @Override
    public void bindVu(@Nullable Vu vi) {
        if (vi == null) {
            return;
        }
        //noinspection unchecked
        this.vu = ((V) vi);
    }
}
