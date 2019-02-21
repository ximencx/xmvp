package com.xm.xmvpbase.presenter;

import android.support.annotation.Nullable;

import com.xm.xmvpbase.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public interface Presenter {

    /**
     * 设置与Presenter绑定的Vu接口实现
     *
     * @param vu 与Presenter绑定的Vu接口实现
     */
    void bindVu(@Nullable Vu vu);
}
