package com.xm.xmvp.cement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xm.xmvp.presenter.Presenter;
import com.xm.xmvp.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class CementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preMvpBinding(savedInstanceState);

        Presenter presenter = getPresenter();

        Vu.ActivityVu[] views = getActivityVus();

        if (presenter != null) {
            if (views != null) {
                for (Vu.ActivityVu view : views) {
                    presenter.bindVu(view);
                }
            }
        }

        if (views != null) {
            for (Vu.ActivityVu view : views) {
                if (view != null) {
                    view.bindPresenter(presenter);
                    //设置和View关联的Activity
                    view.bindActivity(this);
                    view.initView(savedInstanceState);
                }
            }
        }
        afterMvpBinding(savedInstanceState);
    }

    private Vu.ActivityVu[] getActivityVus() {
        return provideVus();
    }

    private Presenter getPresenter() {
        return providePresenter();
    }

    public Vu.ActivityVu[] provideVus() {
        Vu.ActivityVu activityVu = provideVu();
        return new Vu.ActivityVu[]{activityVu};
    }

    public abstract void preMvpBinding(Bundle savedInstanceState);

    public abstract void afterMvpBinding(Bundle savedInstanceState);


    @Nullable
    public abstract Vu.ActivityVu provideVu();

    @Nullable
    public abstract Presenter providePresenter();
}
