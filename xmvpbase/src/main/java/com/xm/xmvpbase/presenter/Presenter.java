package com.xm.xmvpbase.presenter;

import androidx.annotation.Nullable;

import com.xm.xmvpbase.vu.Vu;

/**
 *
 */
public interface Presenter {

    /**
     * 设置与Presenter绑定的Vu接口实现
     *
     * @param vu 与Presenter绑定的Vu接口实现
     */
    void bindVu(@Nullable Vu vu);
}
