package com.xm.xmvpbase.basemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xm.xmvpbase.presenter.Presenter;
import com.xm.xmvpbase.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class BaseMvpActivity<V extends Vu.ActivityVu, P extends Presenter> extends AppCompatActivity implements Presenter {

    private V view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preMvpBinding(savedInstanceState);
        //初始化组件
        Presenter presenter = getPresenter();
        Vu.ActivityVu view = getActivityVus();
        //绑定组件
        if (presenter != null) {
            if (view != null) {
                presenter.bindVu(view);
            }
        }
        if (view != null) {
            view.bindPresenter(presenter);
            //设置和View关联的Activity
            view.bindActivity(this);
            view.initView(savedInstanceState);
        }
        afterMvpBinding(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        view.releaseView();
        view.unBindBfView(this);
        view = null;
        super.onDestroy();
    }

    private Vu.ActivityVu getActivityVus() {
        return provideVus();
    }

    private P getPresenter() {
        return providePresenter();
    }

    private Vu.ActivityVu provideVus() {
        return provideVu();
    }

    @Override
    public void bindVu(@Nullable Vu vu) {
        if (vu == null) {
            return;
        }
        this.view = ((V) vu);
    }

    public V getVu() {
        return view;
    }

    public BaseMvpActivity getActivity() {
        return this;
    }

    @Nullable
    public abstract V provideVu();

    @Nullable
    public abstract P providePresenter();

    public abstract void preMvpBinding(Bundle savedInstanceState);

    public abstract void afterMvpBinding(Bundle savedInstanceState);

}
