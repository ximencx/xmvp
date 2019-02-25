package com.xm.xmvpbase.vu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xm.xmvpbase.presenter.Presenter;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class FragmentActivityView<P extends Presenter> extends Fragment implements Vu.ActivityVu {

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

    public Activity getHostActivity() {
        return this.activity;
    }

    public P getPresenter() {
        return this.presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutRes = provideLayoutRes();
        return inflater.inflate(layoutRes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindBfView(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unBindBfView(this);
    }

    @Override
    public void releaseView() {
    }

    @Override
    public void bindBfView(Object object, View view) {

    }

    @Override
    public void unBindBfView(Object object) {

    }

    /**
     * 提供View相关的布局资源ID
     *
     * @return 布局资源ID
     */
    @LayoutRes
    protected abstract int provideLayoutRes();
}

