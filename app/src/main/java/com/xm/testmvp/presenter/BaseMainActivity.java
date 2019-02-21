package com.xm.testmvp.presenter;

import com.xm.testmvp.MyForkApp;
import com.xm.testmvp.di.MainActivityComponent;
import com.xm.xmvp.di.base.BaseMvpDiActivity;
import com.xm.xmvpbase.vu.Vu;

/**
 * created on 2019/1/27.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class BaseMainActivity<V extends Vu.ActivityVu> extends BaseMvpDiActivity<V> {
    private MainActivityComponent activityComponent;

    public MainActivityComponent getMainActivityComponent() {
        if (this.activityComponent == null) {
            this.activityComponent = MyForkApp.getMainActivityComponent(this);
        }
        return this.activityComponent;
    }

    @Override
    public void onDestroy() {
        activityComponent = null;
        super.onDestroy();
    }
}
