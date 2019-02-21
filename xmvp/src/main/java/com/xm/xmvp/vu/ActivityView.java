package com.xm.xmvp.vu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.xm.xmvp.presenter.Presenter;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class ActivityView<P extends Presenter> implements Vu.ActivityVu {

    private Activity activity;

    private P presenter;

    @Override
    public void bindPresenter(@Nullable Presenter presenter) {
        this.presenter = (P) presenter;
    }

    @Override
    public void bindActivity(@NonNull Activity activity) {
        this.activity = activity;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        if (this.activity != null) {
            LayoutInflater layoutInflater = this.activity.getLayoutInflater();
            int layoutRes = provideLayoutRes();
            View contentView = layoutInflater.inflate(layoutRes, null, false);
            this.activity.setContentView(contentView);
            bindBfView(this, contentView);
        }
    }

    @Override
    public void bindBfView(Object object, View view) {

    }

    @Override
    public void unBindBfView(Object object) {

    }

    public <T extends View> T findViewById(@IdRes int res) {
        return getActivity().findViewById(res);
    }

    @Override
    public void releaseView() {
        unBindBfView(this);
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Context getContext() {
        return this.activity;
    }

    public P getPresenter() {
        return this.presenter;
    }

    /**
     * 提供View相关的布局资源ID
     *
     * @return 布局资源ID
     */
    @LayoutRes
    protected abstract int provideLayoutRes();
}
